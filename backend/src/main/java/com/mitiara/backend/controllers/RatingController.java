package com.mitiara.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitiara.backend.models.Rating;
import com.mitiara.backend.services.RatingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("api/rating")
public class RatingController {

  @Autowired
  private RatingService ratingService;

  //create operations
  @PostMapping("/")
  public ResponseEntity<Object> createRating(@RequestBody Rating rating) {
      return ratingService.saveRating(rating);
  }

  //read operations
  @GetMapping("/{id}")
  public ResponseEntity<Object> fetchRating(@PathVariable("id") Integer id) {
      return ratingService.fetchRating(id);
  }

  //update operations
  @PutMapping("/value/{id}")
  public ResponseEntity<Object> updateValue(@PathVariable Integer id, @RequestBody Integer value) {
      return ratingService.updateRatingValue(id, value);
  }

  @PutMapping("/comment/{id}")
  public ResponseEntity<Object> updateComment(@PathVariable Integer id, @RequestBody String comment) {
      return ratingService.updateComment(id, comment);
  }

  @PutMapping("/header/{id}")
  public ResponseEntity<Object> updateHeader(@PathVariable Integer id, @RequestBody String header) {
      return ratingService.updateHeader(id, header);
  }

  //delete operation
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteRating(@PathVariable("id") Integer id) {
    return ratingService.deleteRating(id);
  }
 
}
