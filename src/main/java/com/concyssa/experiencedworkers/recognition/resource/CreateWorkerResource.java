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
public class CreateWorkerResource {
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
