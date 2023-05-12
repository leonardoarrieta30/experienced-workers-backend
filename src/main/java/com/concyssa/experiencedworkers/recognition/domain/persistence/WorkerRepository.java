package com.concyssa.experiencedworkers.recognition.domain.persistence;

import com.concyssa.experiencedworkers.recognition.domain.model.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {



}
