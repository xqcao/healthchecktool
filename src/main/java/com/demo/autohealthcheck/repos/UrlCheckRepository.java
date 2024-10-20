package com.demo.autohealthcheck.repos;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.autohealthcheck.models.UatComponent;

@Repository
public interface UrlCheckRepository extends JpaRepository<UatComponent, Long> {
  List<UatComponent> findByTimestampBetween(LocalDateTime start, LocalDateTime end);

    @Query("SELECT DISTINCT a.timestamp FROM UAT_COMPONENT a ORDER BY a.timestamp DESC")
    List<LocalDateTime> findDistinctTimestamp();

    UatComponent findByTimestamp(LocalDateTime timestamp);

}
