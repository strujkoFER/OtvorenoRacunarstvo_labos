package com.backend.programski_jezici.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "programming_languages")
public class ProgramskiJezikModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonProperty("name")
    @Column(name="name")
    private String name;

    @JsonProperty("year_created")
    @Column(name="year_created")
    private int yearCreated;

    @JsonProperty("creator")
    @Column(name="creator")
    private String creator;

    @JsonProperty("popular_frameworks")
    @JdbcTypeCode(SqlTypes.ARRAY)
    @Column(name="popular_frameworks", columnDefinition = "text[]")
    private List<String> popularFrameworks  = new ArrayList<>();

    @JsonProperty("primary_uses")
    @JdbcTypeCode(SqlTypes.ARRAY)
    @Column(name="primary_uses", columnDefinition = "text[]")
    private List<String> primaryUses  = new ArrayList<>();

    @JsonProperty("description")
    @Column(name="description")
    private String description;

    @JsonProperty("website")
    @Column(name="website")
    private String website;

    @JsonProperty("typing_discipline")
    @OneToOne(mappedBy = "programskiJezikModel", cascade = CascadeType.ALL, orphanRemoval = true)
    private TypingDisciplineModel typingDisciplineModel;

    @JsonProperty("programming_style")
    @OneToMany(mappedBy = "programskiJezikModel", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProgrammingStylesModel> programmingStylesModel  = new ArrayList<>();

    public ProgramskiJezikModel(String name, int year_created, String creator, String[] popular_frameworks, String[] primary_uses, String description, String website) {
        this.name = name;
        this.yearCreated = year_created;
        this.creator = creator;
        this.popularFrameworks = List.of(popular_frameworks);
        this.primaryUses = List.of(primary_uses);
        this.description = description;
        this.website = website;
    }

    public ProgramskiJezikModel() {}

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public List<String> getPopularFrameworks() {
        return popularFrameworks;
    }

    public void setPopularFrameworks(List<String> popularFrameworks) {
        this.popularFrameworks = popularFrameworks;
    }

    public List<String> getPrimaryUses() {
        return primaryUses;
    }

    public void setPrimaryUses(List<String> primaryUses) {
        this.primaryUses = primaryUses;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @JsonProperty("typing_discipline")
    public TypingDisciplineModel getTypingDisciplineModel() {
        return typingDisciplineModel;
    }

    @JsonProperty("programming_style")
    public List<String> getProgrammingStylesModelStyle() {
        List<String> list = new ArrayList<>();

        for (ProgrammingStylesModel temp : programmingStylesModel) {
            list.add(temp.getStyle());
        }
        return list;
    }

    @JsonIgnore
    public List<ProgrammingStylesModel> getProgrammingStylesModel() {
        return programmingStylesModel;
    }

    @JsonProperty("programming_style")
    public void setProgrammingStylesModel(List<String> styles) {
        this.programmingStylesModel.clear();

        if (styles == null) return;

        for (String style : styles) {
            this.programmingStylesModel.add(new ProgrammingStylesModel(style));
        }
    }

    public void setTypingDisciplineModel(TypingDisciplineModel typingDisciplineModel) {
        this.typingDisciplineModel = typingDisciplineModel;

        if (typingDisciplineModel != null) {
            typingDisciplineModel.setProgramskiJezikModel(this);
        }
    }



}
