package com.concyssa.experiencedworkers.recognition.service;

import com.concyssa.experiencedworkers.recognition.domain.model.entity.Worker;
import com.concyssa.experiencedworkers.recognition.domain.persistence.WorkerRepository;
import com.concyssa.experiencedworkers.recognition.domain.service.WorkerService;
import com.concyssa.experiencedworkers.shared.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {

    private static final String ENTITY = "Worker";
    private final WorkerRepository workerRepository;

    public WorkerServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public List<Worker> getAll() {
        return workerRepository.findAll();
    }

    @Override
    public Worker getById(Long workerId) {
        return workerRepository.findById(workerId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, workerId));
    }

    @Override
    public Worker create(Worker worker) {
        return workerRepository.save(worker);
    }

    @Override
    public Worker update(Long workerId, Worker request) {
        return workerRepository.findById(workerId).map(worker ->
                        workerRepository.save(
                                worker.withName(request.getName())
                                        .withLastname(request.getLastname())
                                        .withWorkPosition(request.getWorkPosition())
                                        .withUrlToImage(request.getUrlToImage())
                                        .withDescription(request.getDescription())
                                        .withLikes(request.getLikes())
                                        .withAge(request.getAge())
                                        .withGender(request.getGender())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, workerId));
    }

    @Override
    public Worker updateLikes(Long workerId, Worker request) {
        return workerRepository.findById(workerId).map(worker ->
                        workerRepository.save(
                                worker.withLikes(request.getLikes())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, workerId));
    }

    @Override
    public ResponseEntity<?> delete(Long workerId) {
        return workerRepository.findById(workerId).map(worker -> {
            workerRepository.delete(worker);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, workerId));
    }
}
