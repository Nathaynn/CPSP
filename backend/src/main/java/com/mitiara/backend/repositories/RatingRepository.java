package com.mitiara.backend.repositories;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

import com.mitiara.backend.models.Rating;

public interface RatingRepository extends ListPagingAndSortingRepository<Rating, Integer>,
ListCrudRepository<Rating, Integer>
{

}
