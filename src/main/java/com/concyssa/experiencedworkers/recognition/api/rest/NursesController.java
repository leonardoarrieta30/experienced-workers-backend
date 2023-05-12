package com.concyssa.experiencedworkers.recognition.api.rest;

import com.concyssa.experiencedworkers.recognition.domain.service.NurseService;
import com.concyssa.experiencedworkers.recognition.mapping.NurseMapper;
import com.concyssa.experiencedworkers.recognition.resource.NurseResource.CreateNurseResource;
import com.concyssa.experiencedworkers.recognition.resource.NurseResource.NurseResource;
import com.concyssa.experiencedworkers.recognition.resource.NurseResource.UpdateNurseResource;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping(value ="/api/v1/nurses", produces = "application/json")
@Tag(name = "Nurses", description = "Create, read, update and delete nurses")
public class NursesController {

    public final NurseService nurseService;

    public final NurseMapper mapper;


    public NursesController(NurseService nurseService, NurseMapper mapper) {
        this.nurseService = nurseService;
        this.mapper = mapper;
    }


    @GetMapping
    public Page<NurseResource> getAllNurses(Pageable pageable){
        return mapper.modelListPage(nurseService.getAll(), pageable);
    }

    //por buenas practicas al usuario se le devuelve el recurso no el modelo o entidad
    @GetMapping("{nurseId}")
    public NurseResource getNurseById(@PathVariable Long nurseId){
        return mapper.toResource(nurseService.getById(nurseId));
    }

    @PostMapping
    public ResponseEntity<NurseResource> createNurse(@RequestBody CreateNurseResource resource){
        return new ResponseEntity<>(mapper.toResource(nurseService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    //devuelve el recurso y a la vez lo mapea a modelo y lo actualiza

    @PutMapping("{nurseId}")
    public NurseResource updateNurse(@PathVariable Long nurseId, @RequestBody UpdateNurseResource resource){
        return mapper.toResource(nurseService.update(nurseId, mapper.toModel(resource)));
    }

    @DeleteMapping("{nurseId}")
    public ResponseEntity<?> deleteNurse(@PathVariable Long nurseId){
        return nurseService.delete(nurseId);
    }



}
