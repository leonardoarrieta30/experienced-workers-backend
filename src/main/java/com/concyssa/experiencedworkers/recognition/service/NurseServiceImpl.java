package com.concyssa.experiencedworkers.recognition.service;

import com.concyssa.experiencedworkers.recognition.domain.model.entity.Nurse;
import com.concyssa.experiencedworkers.recognition.domain.persistence.NurseRepository;
import com.concyssa.experiencedworkers.recognition.domain.service.NurseService;
import com.concyssa.experiencedworkers.shared.exception.ResourceNotFoundException;
import com.concyssa.experiencedworkers.shared.exception.ResourceValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class NurseServiceImpl implements NurseService {

    private static final String ENTITY = "Nurse";
    private static final String Filter = "Diana";
    private final NurseRepository nurseRepository;

    private final Validator validator;

    public NurseServiceImpl(NurseRepository nurseRepository, Validator validator) {
        this.nurseRepository = nurseRepository;
        this.validator = validator;
    }

    @Override
    public List<Nurse> getAll() {
        return nurseRepository.findAll();
    }



    @Override
    public Nurse getById(Long nurseId) {
        return nurseRepository.findById(nurseId).orElseThrow(() -> new ResourceNotFoundException("Nurse", nurseId));
    }

    @Override
    public Nurse update(Long nurseId, Nurse request) {
        return nurseRepository.findById(nurseId).map(nurse ->
                nurseRepository.save(
                        nurse.withName(request.getName())
                                .withDNI(request.getDNI())
                                .withAge(request.getAge())
                )).orElseThrow(() -> new ResourceNotFoundException(ENTITY, nurseId));
    }

    @Override
    public Nurse create(Nurse nurse) {
//        Set<ConstraintViolation<Nurse>> violations = validator.validate(nurse);
//
//        if(!violations.isEmpty())
//            throw new ResourceValidationException(ENTITY, violations);
//
//        List<Nurse> nurseWithFilterName = nurseRepository.findAllNursesWithFilterName(Filter);


        return nurseRepository.save(nurse);
    }

    @Override
    public ResponseEntity<?> delete(Long nurseId) {
        return nurseRepository.findById(nurseId).map( nurse -> {
            nurseRepository.delete(nurse);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, nurseId));
    }
}
