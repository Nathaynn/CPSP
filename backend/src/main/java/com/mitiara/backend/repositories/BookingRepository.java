package com.mitiara.backend.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.mitiara.backend.models.Booking;
import com.mitiara.backend.models.BookingId;
import java.util.List;


public interface BookingRepository extends ListPagingAndSortingRepository<Booking, BookingId>,
ListCrudRepository <Booking, BookingId> {

  @Query("SELECT b FROM Booking b WHERE b.bClient.id = :clientId")
  List<Booking> findAllClientBookings(@Param("clientId") Integer clientId, Sort sort);

}
