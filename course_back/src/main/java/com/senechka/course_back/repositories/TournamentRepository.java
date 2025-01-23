package com.senechka.course_back.repositories;

import com.senechka.course_back.entities.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
} 