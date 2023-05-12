package com.concyssa.experiencedworkers.recognition.domain.model.entity;

import com.concyssa.experiencedworkers.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Entity
@Table(name = "workers")
public class Worker extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastname;

    private String workPosition;

    private String urlToImage;

    @Size(max = 500)
    private String description;

//    @OneToOne
//    private Nurse nurse;

    private int likes;

    @Min(value= 18, message="The age minimum is 18 years old")
    private int age;

    private String gender;

}
