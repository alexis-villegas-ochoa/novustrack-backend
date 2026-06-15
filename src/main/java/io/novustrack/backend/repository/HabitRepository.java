package io.novustrack.backend.repository;

import io.novustrack.backend.model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitRepository extends JpaRepository <Habit, Long>{
}