package com.mitiara.backend.services;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;

import com.mitiara.backend.models.Rating;

public interface RatingService {

  //create operation
  ResponseEntity<Object> saveRating(Rating rating);

  //fetch operation
  ResponseEntity<Object> fetchRating(Integer id);

  //update operations
  ResponseEntity<Object> updateRatingValue(Integer id, Integer ratingValue);

  ResponseEntity<Object> updateHeader(Integer id, String header);

  ResponseEntity<Object> updateComment(Integer id, String comment);

  //delete operations
  ResponseEntity<Void> deleteRating(Integer id);



}
