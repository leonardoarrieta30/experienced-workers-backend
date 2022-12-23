package com.concyssa.experiencedworkers.recognition.mapping;

import com.concyssa.experiencedworkers.recognition.domain.model.entity.Worker;
import com.concyssa.experiencedworkers.recognition.resource.CreateWorkerResource;
import com.concyssa.experiencedworkers.recognition.resource.UpdateWorkerResource;
import com.concyssa.experiencedworkers.recognition.resource.WorkerResource;
import com.concyssa.experiencedworkers.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class WorkerMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public WorkerResource toResource(Worker model){
        return mapper.map(model, WorkerResource.class);
    }

    public Worker toModel(CreateWorkerResource resource){
        return mapper.map(resource, Worker.class);
    }

    public Worker toModel(UpdateWorkerResource resource){
        return mapper.map(resource, Worker.class);
    }

    public Page<WorkerResource> modelListPage(List<Worker> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, WorkerResource.class),pageable, modelList.size());
    }

}
