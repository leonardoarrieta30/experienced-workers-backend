package com.concyssa.experiencedworkers.recognition.resource.WorkerResource;

import com.concyssa.experiencedworkers.recognition.domain.model.entity.Nurse;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateWorkerResource {
    private Long id;

    private String name;

    private String lastname;

    private String workPosition;

    private String urlToImage;

    @Size(max = 500)
    private String description;

    private int likes;

    @Min(value= 18, message="The age minimum is 18 years old")
    private int age;

    private String gender;
}
