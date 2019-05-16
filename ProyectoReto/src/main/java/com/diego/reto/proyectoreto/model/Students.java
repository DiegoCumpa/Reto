package com.diego.reto.proyectoreto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by jcumpale on 14/05/2019.
 */

/**
 * Clase para entidad Students
 * @author jcumpale
 * Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    @Getter @Setter
    private Integer studentId;

    @Column(name = "gender")
    @Getter @Setter
    private String gender;

    @Column(name = "first_name")
    @Getter @Setter
    private String firstName;

    @Column(name = "middle_name")
    @Getter @Setter
    private String middleName;

    @Column(name = "last_name")
    @Getter @Setter
    private String lastName;

    @Column(name = "date_of_birth")
    @Getter @Setter
    private Date dateOfBirth;

    @Column(name = "other_student_details")
    @Getter @Setter
    private String otherStudentDetails;

    @JsonIgnore
    @ManyToMany(mappedBy = "students")
    @Getter @Setter
    private Set<Parents> parents;


}
