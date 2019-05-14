package com.diego.reto.proyectoreto.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by jcumpale on 14/05/2019.
 */
@Entity
@Table(name = "students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "gender")
    private String gender;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "other_student_details")
    private String otherStudentDetails;


    @ManyToMany(mappedBy = "students")
    private Set<Parents> parents;

    public Students() {
        super();
    }

    public Students(String gender, String firstName, String middleName, String lastName, Date dateOfBirth, String otherStudentDetails, Set<Parents> parents) {
        this.gender = gender;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.otherStudentDetails = otherStudentDetails;
        this.parents = parents;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getOtherStudentDetails() {
        return otherStudentDetails;
    }

    public void setOtherStudentDetails(String otherStudentDetails) {
        this.otherStudentDetails = otherStudentDetails;
    }

    public Set<Parents> getParents() {
        return parents;
    }

    public void setParents(Set<Parents> parents) {
        this.parents = parents;
    }
}
