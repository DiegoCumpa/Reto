package com.diego.reto.proyectoreto.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jcumpale on 14/05/2019.
 */
@Entity
@Table(name = "families")
public class Families {

    @Id
    @GeneratedValue
    @Column(name = "family_id")
    private Integer familyId;

    @OneToOne
    @JoinColumn(name = "head_of_family_parent_id")
    private Parents parents;

    @Column(name = "family_name")
    private String familyName;

    @OneToMany(mappedBy = "families")
    private List<FamilyMembers> familyMembers;

    public Families() {
        super();
    }

    public Families(Parents parents, String familyName, List<FamilyMembers> familyMembers) {
        this.parents = parents;
        this.familyName = familyName;
        this.familyMembers = familyMembers;
    }

    public Integer getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Integer familyId) {
        this.familyId = familyId;
    }

    public Parents getParents() {
        return parents;
    }

    public void setParents(Parents parents) {
        this.parents = parents;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public List<FamilyMembers> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(List<FamilyMembers> familyMembers) {
        this.familyMembers = familyMembers;
    }
}
