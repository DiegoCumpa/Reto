package com.diego.reto.proyectoreto.model;

import lombok.*;

import javax.persistence.*;

/**
 * Created by jcumpale on 14/05/2019.
 */

/**
 * Clase para entidad FamilyMembers
 * @author jcumpale
 * version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "family_members")
public class FamilyMembers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "family_member_id")
    @Getter @Setter
    private Integer familyMemberId;

    @ManyToOne
    @JoinColumn(name = "family_id")
    @Getter @Setter
    private Families families;

    @Column(name = "parent_or_student_member")
    @Getter @Setter
    private String parentOrStudentMember;

    @OneToOne
    @JoinColumn(name = "parent_id")
    @Getter @Setter
    private Parents parents;

    @OneToOne
    @JoinColumn(name = "student_id")
    @Getter @Setter
    private Students students;


}
