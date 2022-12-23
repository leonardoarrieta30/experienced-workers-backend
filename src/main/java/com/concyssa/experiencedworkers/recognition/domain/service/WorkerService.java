package com.concyssa.experiencedworkers.recognition.domain.service;

import com.concyssa.experiencedworkers.recognition.domain.model.entity.Worker;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WorkerService {
    List<Worker> getAll();
    Worker getById(Long workerId);
    Worker create(Worker worker);
    Worker update(Long workerId, Worker request);
    Worker updateLikes(Long workerId, Worker request);
    ResponseEntity<?> delete(Long workerId);
}
