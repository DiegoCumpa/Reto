package com.diego.reto.proyectoreto.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by jcumpale on 13/05/2019.
 */
@Entity
@Table(name = "parents")
public class Parents {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name="gender")
    private String gender;
    @Column(name="first_name")
    private String firstName;
    @Column(name="middle_name")
    private String middleName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="other_parent_details")
    private String otherParentDetails;

    @ManyToMany
    @JoinTable(name = "student_parents", joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "parent_id"))
    private Set<Students> students;

    public Parents() {
        super();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOtherParentDetails() {
        return otherParentDetails;
    }

    public void setOtherParentDetails(String otherParentDetails) {
        this.otherParentDetails = otherParentDetails;
    }

    public Set<Students> getStudents() {
        return students;
    }

    public void setStudents(Set<Students> students) {
        this.students = students;
    }
}
