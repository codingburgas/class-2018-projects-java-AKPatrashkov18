package com.apatrashkov.streamingplatform.repo;

import com.apatrashkov.streamingplatform.model.Stream;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamRepository extends JpaRepository<Stream, Long> {
}
