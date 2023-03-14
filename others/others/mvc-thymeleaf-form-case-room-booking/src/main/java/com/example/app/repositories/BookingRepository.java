package com.example.app.repositories;

import org.springframework.stereotype.Repository;

import com.example.app.entities.BookingEntity;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long>{
	
	@Query("SELECT b FROM BookingEntity b WHERE b.roomNumber = (:roomNumber) AND (((:from) < b.timeFrom AND b.timeFrom < (:to)) OR ((:to) < b.timeTo AND b.timeTo < (:to)))")
	public List<BookingEntity> findBookingsForRoomInTimeScope(@Param("roomNumber") Integer roomNumber, @Param("from") Date from, @Param("to") Date to);
	
}
