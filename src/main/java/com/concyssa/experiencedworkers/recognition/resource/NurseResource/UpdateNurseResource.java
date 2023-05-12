package com.concyssa.experiencedworkers.recognition.resource.NurseResource;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateNurseResource {
    private Long id;

    private String name;

    private Long DNI;

    private Long age;
}
