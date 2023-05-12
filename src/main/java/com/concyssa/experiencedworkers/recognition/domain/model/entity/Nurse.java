package com.concyssa.experiencedworkers.recognition.domain.model.entity;

import com.concyssa.experiencedworkers.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Entity
@Table(name = "nurses")
public class Nurse extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long DNI;
    private Long age;

}
