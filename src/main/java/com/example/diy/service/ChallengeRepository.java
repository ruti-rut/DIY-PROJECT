package com.example.diy.service;

import com.example.diy.model.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChallengeRepository extends JpaRepository<Challenge,Long> {
}
