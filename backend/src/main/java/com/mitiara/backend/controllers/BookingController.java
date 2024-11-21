package com.mitiara.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitiara.backend.dtos.BookingCreateDTO;
import com.mitiara.backend.services.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/booking")
public class BookingController {

  @Autowired
  private BookingService bookingService;

  //save operation
  @PostMapping("/")
  public ResponseEntity<Object> saveBooking(@RequestBody BookingCreateDTO bookingCreateDTO) {
    return bookingService.saveBooking(bookingCreateDTO);
  }

  //fetch operations
  @GetMapping("/bookingId")
  public ResponseEntity<Object> getBooking(
    @RequestParam("client") Integer client, 
    @RequestParam("receipt") Integer receipt) {
      return bookingService.fetchBooking(client, receipt);
  }
  
  @GetMapping("/client/{id}")
  public ResponseEntity<Object> getAllBookings(@PathVariable("id") Integer clientId) {
      return bookingService.fetchAllBookings(clientId);
  }

  //delete operation
  @DeleteMapping("/bookingId")
  public ResponseEntity<Void> deleteBooking(
    @RequestParam("client") Integer client, 
    @RequestParam("receipt") Integer receipt
  ) {
      return bookingService.deleteBooking(client, receipt);
  }
  
}