package com.backend.programski_jezici.repositories;

import com.backend.programski_jezici.models.ProgramskiJezikModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProgramskiJeziciRepository extends JpaRepository<ProgramskiJezikModel, Integer> {

    // S obzirom da radim s malim datasetom neću komplicirati u backendu pa ću svo filtirianje raditi na frontendu
    // Kada budem u budućnosti radio na većim projektima ću više vremena potrošiti na repository filtering

    @Query("select pl from ProgramskiJezikModel pl join fetch pl.typingDisciplineModel td join fetch pl.programmingStylesModel ps")
    List<ProgramskiJezikModel> findAllCustom();


    //List<ProgramskiJezikModel> findAllById(int id);

    //List<ProgramskiJezikModel> findAllByName(String name);

    //ProgramskiJezikModel findAllByYearCreated(int year_created);

    //ProgramskiJezikModel findAllByCreator(String creator);

    //ProgramskiJezikModel findByPopularFrameworks(ArrayList<String> popular_frameworks);

    //ProgramskiJezikModel findByPrimaryUses(ArrayList<String> primary_uses);

    //ProgramskiJezikModel findAllByDescription(String description);

    //ProgramskiJezikModel findAllByWebsite(String website);

    //ProgramskiJezikModel findAllByTypingDisciplineModel_typeChecking(String typingDisciplineModel_type_checking);

    //ProgramskiJezikModel findAllByTypingDisciplineModel_strength(String typingDisciplineModel_strength);

    //ProgramskiJezikModel findAllByProgrammingStylesModel_style(String programmingStylesModel_style);
}
