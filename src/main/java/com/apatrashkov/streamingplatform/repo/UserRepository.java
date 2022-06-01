package com.apatrashkov.streamingplatform.repo;

import com.apatrashkov.streamingplatform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
