package com.diego.reto.proyectoreto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jcumpale on 14/05/2019.
 */

/**
 * Clase para entidad Families
 * @author jcumpale
 * version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "families")
public class Families {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "family_id")
    @Getter @Setter
    private Integer familyId;


    @OneToOne
    @JoinColumn(name = "parent_id")
    @Getter @Setter
    private Parents parents;

    @Column(name = "family_name")
    @Getter @Setter
    private String familyName;

    @JsonIgnore
    @OneToMany(mappedBy = "families")
    @Getter @Setter
    private List<FamilyMembers> familyMembers;


}
