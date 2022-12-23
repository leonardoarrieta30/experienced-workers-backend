package com.concyssa.experiencedworkers.recognition.resource;


import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

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
