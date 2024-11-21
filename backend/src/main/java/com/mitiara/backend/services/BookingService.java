package com.mitiara.backend.services;

import org.springframework.http.ResponseEntity;

import com.mitiara.backend.dtos.BookingCreateDTO;

public interface BookingService {

  ResponseEntity<Object> saveBooking(BookingCreateDTO booking);

  ResponseEntity<Object> fetchBooking(Integer clientId, Integer receiptId);

  ResponseEntity<Object> fetchAllBookings(Integer clientId);

  ResponseEntity<Void> deleteBooking(Integer clientId, Integer receiptId);

}