package com.diego.reto.proyectoreto.model;

import javax.persistence.*;

/**
 * Created by jcumpale on 14/05/2019.
 */
@Entity
@Table(name = "family_members")
public class FamilyMembers {

    @Id
    @GeneratedValue
    @Column(name = "family_member_id")
    private Integer familyMemberId;

    @ManyToOne
    @JoinColumn(name = "family_id")
    private Families families;

    @Column(name = "parent_or_student_member")
    private String parentOrStudentMember;

    @OneToOne
    @JoinColumn(name = "parent_id")
    private Parents parents;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Students students;

    public FamilyMembers() {
        super();
    }

    public FamilyMembers(Families families, String parentOrStudentMember, Parents parents, Students students) {
        this.families = families;
        this.parentOrStudentMember = parentOrStudentMember;
        this.parents = parents;
        this.students = students;
    }

    public Integer getFamilyMemberId() {
        return familyMemberId;
    }

    public void setFamilyMemberId(Integer familyMemberId) {
        this.familyMemberId = familyMemberId;
    }

    public Families getFamilies() {
        return families;
    }

    public void setFamilies(Families families) {
        this.families = families;
    }

    public String getParentOrStudentMember() {
        return parentOrStudentMember;
    }

    public void setParentOrStudentMember(String parentOrStudentMember) {
        this.parentOrStudentMember = parentOrStudentMember;
    }

    public Parents getParents() {
        return parents;
    }

    public void setParents(Parents parents) {
        this.parents = parents;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }
}
