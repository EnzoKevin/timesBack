package com.fatec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fatec.entities.Match;

public interface MatchRepository extends JpaRepository<Match, Long> {

}
