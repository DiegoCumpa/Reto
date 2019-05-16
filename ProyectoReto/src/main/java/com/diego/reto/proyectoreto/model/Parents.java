package com.diego.reto.proyectoreto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by jcumpale on 13/05/2019.
 */


/**
 * Clase para entidad Parents
 * @author jcumpale
 * Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parents")
public class Parents {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "parent_id")
    @Getter @Setter
    private Integer parentId;


    @Column(name="gender")
    @Getter @Setter
    private String gender;

    @Column(name="first_name")
    @Getter @Setter
    private String firstName;

    @Column(name="middle_name")
    @Getter @Setter
    private String middleName;

    @Column(name="last_name")
    @Getter @Setter
    private String lastName;

    @Column(name="other_parent_details")
    @Getter @Setter
    private String otherParentDetails;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "student_parents", joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "parent_id"))
    @Getter @Setter
    private Set<Students> students;


}
