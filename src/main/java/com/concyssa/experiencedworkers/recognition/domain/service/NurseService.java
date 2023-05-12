package com.concyssa.experiencedworkers.recognition.domain.service;

import com.concyssa.experiencedworkers.recognition.domain.model.entity.Nurse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NurseService {

    List<Nurse> getAll();


    Nurse getById(Long nurseId);

    Nurse update(Long nurseId, Nurse request);

    Nurse create(Nurse nurse);

    ResponseEntity<?> delete(Long nurseId);

}
