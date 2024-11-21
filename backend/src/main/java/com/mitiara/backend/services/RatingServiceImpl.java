package com.mitiara.backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mitiara.backend.models.Rating;
import com.mitiara.backend.repositories.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService {

  @Autowired
  private RatingRepository ratingRepository;

  //create operations
  @Override
  public ResponseEntity<Object> saveRating(Rating rating) {
    try {
      ratingRepository.save(rating);
      return ResponseEntity.ok(rating);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error: Unable to save Rating: " + e.getMessage());
    }
  }

  //fetch operations
  @Override
  public ResponseEntity<Object> fetchRating(Integer id) { 
    Optional<Rating> rating = ratingRepository.findById(id);
    if(rating.isPresent()) {
      return ResponseEntity.ok(rating.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }


  //update operations
  @Override
  public ResponseEntity<Object> updateRatingValue(Integer id, Integer ratingValue) {
    Optional<Rating> rating = ratingRepository.findById(id);
    if(rating.isPresent()) {
      Rating saved = rating.get();
      saved.setRatingValue(ratingValue);
      try{
        ratingRepository.save(saved);
        return ResponseEntity.ok(saved);
      } catch (Exception e) {
        return ResponseEntity.badRequest().body("Error: Unable to save Rating: " + e.getMessage());
      }
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @Override
  public ResponseEntity<Object> updateHeader(Integer id, String header) {
    Optional<Rating> rating = ratingRepository.findById(id);
    if(rating.isPresent()) {
      Rating saved = rating.get();
      saved.setHeader(header);;
      try{
        ratingRepository.save(saved);
        return ResponseEntity.ok(saved);
      } catch (Exception e) {
        return ResponseEntity.badRequest().body("Error: Unable to save Rating: " + e.getMessage());
      }
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @Override
  public ResponseEntity<Object> updateComment(Integer id, String comment) {
    Optional<Rating> rating = ratingRepository.findById(id);
    if(rating.isPresent()) {
      Rating saved = rating.get();
      saved.setComment(comment);;
      try{
        ratingRepository.save(saved);
        return ResponseEntity.ok(saved);
      } catch (Exception e) {
        return ResponseEntity.badRequest().body("Error: Unable to save Rating: " + e.getMessage());
      }
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  //delete operations
  @Override
  public ResponseEntity<Void> deleteRating(Integer id) {
    Optional<Rating> rating = ratingRepository.findById(id);
    if(rating.isPresent()) {
      ratingRepository.deleteById(id);
      return ResponseEntity.ok().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

}
