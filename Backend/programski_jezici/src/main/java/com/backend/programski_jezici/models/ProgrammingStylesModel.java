package com.backend.programski_jezici.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

@Entity
@Table(name = "programming_styles")
public class ProgrammingStylesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="style")
    private String style;

    @ManyToOne
    @JoinColumn(name = "language_id")
    @JsonIgnore
    private ProgramskiJezikModel programskiJezikModel;

    public ProgrammingStylesModel(String style) {
        this.style = style;
    }

    public ProgrammingStylesModel() {}

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getId() {
        return this.id;
    }

    public void setProgramskiJezikModel(ProgramskiJezikModel pj) {
        this.programskiJezikModel = pj;
    }

}

