package com.concyssa.experiencedworkers.recognition.resource.WorkerResource;


import com.concyssa.experiencedworkers.recognition.domain.model.entity.Nurse;
import lombok.*;

import javax.persistence.OneToOne;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class WorkerResource {

    private Long id;

    private String name;

    private String lastname;

    private String workPosition;

    private String urlToImage;


    private String description;
    private String gender;
    private int likes;

    private int age;
}
