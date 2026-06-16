package com.fatec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fatec.entities.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

}
