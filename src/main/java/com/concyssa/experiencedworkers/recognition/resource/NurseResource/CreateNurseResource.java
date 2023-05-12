package com.concyssa.experiencedworkers.recognition.resource.NurseResource;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
public class CreateNurseResource {
    private String name;

    private Long DNI;
    private int age;
}
