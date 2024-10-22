package com.example.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import com.example.model.entity.ReservationEntity;

import jakarta.persistence.LockModeType;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<ReservationEntity> findByRoomNameAndStartTimeLessThanAndEndTimeGreaterThan(
        String roomName, LocalDateTime endTime, LocalDateTime startTime);
    
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<ReservationEntity> findByIdNotAndRoomNameAndStartTimeLessThanAndEndTimeGreaterThan(
        Long id, String roomName, LocalDateTime endTime, LocalDateTime startTime);

}