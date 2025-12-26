package com.backend.programski_jezici.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

@Entity
@Table(name = "typing_discipline")
public class TypingDisciplineModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonProperty("type_checking")
    @Column(name="type_checking")
    private String typeChecking;

    @JsonProperty("strength")
    @Column(name="strength")
    private String strength;

    @OneToOne
    @JoinColumn(name = "language_id", unique = true)
    @JsonIgnore
    private ProgramskiJezikModel programskiJezikModel;

    public TypingDisciplineModel(String typeChecking, String strength) {
        this.typeChecking = typeChecking;
        this.strength = strength;
    }

    public TypingDisciplineModel() {}

    public String getTypeChecking() {
        return typeChecking;
    }

    public void setTypeChecking(String typeChecking) {
        this.typeChecking = typeChecking;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public void setProgramskiJezikModel(ProgramskiJezikModel pj) {
        this.programskiJezikModel = pj;
    }

}

