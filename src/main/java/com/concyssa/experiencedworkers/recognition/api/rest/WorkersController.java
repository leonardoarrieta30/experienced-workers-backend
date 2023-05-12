package com.concyssa.experiencedworkers.recognition.api.rest;

import com.concyssa.experiencedworkers.recognition.domain.service.WorkerService;
import com.concyssa.experiencedworkers.recognition.mapping.WorkerMapper;
import com.concyssa.experiencedworkers.recognition.resource.WorkerResource.CreateWorkerResource;
import com.concyssa.experiencedworkers.recognition.resource.WorkerResource.UpdateWorkerResource;
import com.concyssa.experiencedworkers.recognition.resource.WorkerResource.WorkerResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/workers", produces = "application/json")
@Tag(name = "Workers", description = "Create, read, update and delete workers")
public class WorkersController {
    public final WorkerService workerService;
    private final WorkerMapper mapper;

    public WorkersController(WorkerService workerService, WorkerMapper mapper) {
        this.workerService = workerService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<WorkerResource> getAllWorkers(Pageable pageable){
        return mapper.modelListPage(workerService.getAll(), pageable);
    }

    @GetMapping("{workerId}")
    public WorkerResource getWorkerById(@PathVariable Long workerId){
        return mapper.toResource(workerService.getById(workerId));
    }

    @PostMapping
    public ResponseEntity<WorkerResource> createWorker(@RequestBody CreateWorkerResource resource){
        return new ResponseEntity<>(mapper.toResource(workerService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{workerId}")
    public WorkerResource updateWorker(@PathVariable Long workerId, @RequestBody UpdateWorkerResource resource){
        return mapper.toResource(workerService.update(workerId, mapper.toModel(resource)));
    }

    @PatchMapping("{workerId}")
    public ResponseEntity<WorkerResource> updateLikes(@PathVariable Long workerId, @RequestBody UpdateWorkerResource resource){
        return new ResponseEntity<>(mapper.toResource(workerService.updateLikes(workerId, mapper.toModel(resource))), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{workerId}")
    public ResponseEntity<?> deleteWorker(@PathVariable Long workerId) {
        return workerService.delete(workerId);
    }




}
