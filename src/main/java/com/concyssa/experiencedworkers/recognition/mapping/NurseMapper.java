package com.concyssa.experiencedworkers.recognition.mapping;

import com.concyssa.experiencedworkers.recognition.domain.model.entity.Nurse;
import com.concyssa.experiencedworkers.recognition.resource.NurseResource.CreateNurseResource;
import com.concyssa.experiencedworkers.recognition.resource.NurseResource.NurseResource;
import com.concyssa.experiencedworkers.recognition.resource.NurseResource.UpdateNurseResource;
import com.concyssa.experiencedworkers.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class NurseMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;


    public NurseResource toResource(Nurse model){
          return mapper.map(model, NurseResource.class);
    }


    public Nurse toModel(CreateNurseResource resource){
        return mapper.map(resource, Nurse.class);
    }

    public Nurse toModel(UpdateNurseResource resource){
        return mapper.map(resource, Nurse.class);
    }

    public Page<NurseResource> modelListPage(List<Nurse> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, NurseResource.class), pageable, modelList.size());
    }


}
