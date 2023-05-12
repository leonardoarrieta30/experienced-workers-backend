package com.concyssa.experiencedworkers.recognition.resource.NurseResource;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
public class NurseResource {
    private Long id;
    private String name;

    private Long DNI;
    private Long age;
}
