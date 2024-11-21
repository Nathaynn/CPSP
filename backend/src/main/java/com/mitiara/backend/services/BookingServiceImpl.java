package com.mitiara.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mitiara.backend.dtos.BookingCreateDTO;
import com.mitiara.backend.dtos.BookingResponseDTO;
import com.mitiara.backend.models.Booking;
import com.mitiara.backend.models.BookingId;
import com.mitiara.backend.models.Client;
import com.mitiara.backend.models.Receipt;
import com.mitiara.backend.repositories.BookingRepository;
import com.mitiara.backend.repositories.ClientRepository;
import com.mitiara.backend.repositories.ReceiptRepository;

import java.util.Optional;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{
  
  @Autowired
  private BookingRepository bookingRepository;

  @Autowired
  private ClientRepository clientRepository;

  @Autowired
  private ReceiptRepository receiptRepository;

  //create operation
  @Override
  public ResponseEntity<Object> saveBooking(BookingCreateDTO booking) {
    Optional<Client> client = clientRepository.findById(booking.getClientId());
    Optional<Receipt> receipt = receiptRepository.findById(booking.getReceiptId());
    if(client.isPresent() && receipt.isPresent()) {
      Booking saved = Booking.builder()
          .bClient(client.get())
          .bReceipt(receipt.get())
          .initialTime(booking.getInitialTime())
          .endingTime(booking.getEndingTime())
          .createdAt(booking.getCreatedAt())
          .build();
      try {
        bookingRepository.save(saved);
        return ResponseEntity.ok(
          new BookingResponseDTO(
          saved.getBReceipt().getId(),
          saved.getBClient().getId(),
          saved.getInitialTime(),
          saved.getEndingTime(),
          saved.getCreatedAt())
        );
      } catch (Exception e) {
        return ResponseEntity.badRequest().body("Error: Unable to save Booking. " + e.getMessage());
      }
    } else {
      return ResponseEntity.badRequest().body("Error: Unable to save Booking. Invalid client or receipt");
    }
    
  }

  //fetch operation
  @Override
  public ResponseEntity<Object> fetchBooking(Integer clientId, Integer receiptId) {
    BookingId bookingId = new BookingId(clientId, receiptId);
    Optional<Booking> booking = bookingRepository.findById(bookingId);
    if(booking.isPresent()) {
      Booking saved = booking.get();
      return ResponseEntity.ok(
        new BookingResponseDTO(
          saved.getBReceipt().getId(),
          saved.getBClient().getId(),
          saved.getInitialTime(),
          saved.getEndingTime(),
          saved.getCreatedAt())
      );
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  //fetch operation
  @Override
  public ResponseEntity<Object> fetchAllBookings(Integer clientId) {
    try {
      Sort sort = Sort.by(Sort.Order.asc("createdAt"));
      List<BookingResponseDTO> booking = bookingRepository.findAllClientBookings(clientId, sort).stream()
        .map(bk -> new BookingResponseDTO(
          bk.getBReceipt().getId(),
          bk.getBClient().getId(),
          bk.getInitialTime(),
          bk.getEndingTime(),
          bk.getCreatedAt()))
        .toList();
      return ResponseEntity.ok(booking);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error: Unable to fetch Bookings. " + e.getMessage());
    }
  }

  //delete operation
  @Override
  public ResponseEntity<Void> deleteBooking(Integer clientId, Integer receiptId) {
    BookingId bookingId = new BookingId(clientId, receiptId);
    Optional<Booking> booking = bookingRepository.findById(bookingId);
    if(booking.isPresent()) {
      bookingRepository.delete(booking.get());
      return ResponseEntity.ok().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

}