package com.backend.programski_jezici.services;

import com.backend.programski_jezici.models.ProgramskiJezikModel;
import com.backend.programski_jezici.repositories.ProgramskiJeziciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgramskiJeziciService {

    private ProgramskiJeziciRepository programskiJeziciRepository;

    @Autowired
    public ProgramskiJeziciService(ProgramskiJeziciRepository programskiJeziciRepository) {
        this.programskiJeziciRepository = programskiJeziciRepository;
    }

    public List<ProgramskiJezikModel> findAll(){
        return this.programskiJeziciRepository.findAllCustom();
    }

    public List<ProgramskiJezikModel> findAllByWildcard (String wildcard){
        return this.programskiJeziciRepository.findAllCustom()
                .stream()
                .filter(programskiJezik ->
                        (programskiJezik.getName().toLowerCase().contains(wildcard.toLowerCase()))
                        || (String.valueOf(programskiJezik.getYearCreated()).equals(wildcard))
                        || (programskiJezik.getCreator().toLowerCase().contains(wildcard.toLowerCase()))
                        || (programskiJezik.getDescription().toLowerCase().contains(wildcard.toLowerCase()))
                        || (programskiJezik.getWebsite().toLowerCase().contains(wildcard.toLowerCase()))
                        || (programskiJezik.getTypingDisciplineModel().getTypeChecking().toLowerCase().contains(wildcard.toLowerCase()))
                        || (programskiJezik.getTypingDisciplineModel().getStrength().toLowerCase().contains(wildcard.toLowerCase()))
                        || (programskiJezik.getProgrammingStylesModelStyle()
                                .stream()
                                .anyMatch(stil -> stil.toLowerCase().contains(wildcard.toLowerCase())))
                ).collect(Collectors.toList());
    }

    public List<ProgramskiJezikModel> findAllByName (String name){
        return this.programskiJeziciRepository.findAllCustom()
                .stream()
                .filter(programskiJezik ->
                        programskiJezik.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<ProgramskiJezikModel> findAllByYearCreated (int yearCreated){
        return this.programskiJeziciRepository.findAllCustom()
                .stream()
                .filter(programskiJezik ->
                        programskiJezik.getYearCreated() == yearCreated)
                .collect(Collectors.toList());
    }

    public List<ProgramskiJezikModel> findAllByCreator (String creator){
        return this.programskiJeziciRepository.findAllCustom()
                .stream()
                .filter(programskiJezik ->
                        programskiJezik.getCreator().toLowerCase().contains(creator.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<ProgramskiJezikModel> findAllByDescription (String description){
        return this.programskiJeziciRepository.findAllCustom()
                .stream()
                .filter(programskiJezik ->
                        programskiJezik.getDescription().toLowerCase().contains(description.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<ProgramskiJezikModel> findAllByWebsite (String website){
        return this.programskiJeziciRepository.findAllCustom()
                .stream()
                .filter(programskiJezik ->
                        programskiJezik.getWebsite().toLowerCase().contains(website.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<ProgramskiJezikModel> findAllByTypeChecking (String typeChecking){
        return this.programskiJeziciRepository.findAllCustom()
                .stream()
                .filter(programskiJezik ->
                        programskiJezik.getTypingDisciplineModel().getTypeChecking().toLowerCase().contains(typeChecking.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<ProgramskiJezikModel> findAllByStrength (String strength){
        return this.programskiJeziciRepository.findAllCustom()
                .stream()
                .filter(programskiJezik ->
                        programskiJezik.getTypingDisciplineModel().getStrength().toLowerCase().contains(strength.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<ProgramskiJezikModel> findAllByStyle(String style){
        return this.programskiJeziciRepository.findAllCustom()
                .stream()
                .filter(programskiJezik ->
                        programskiJezik.getProgrammingStylesModelStyle()
                                .stream()
                                .anyMatch(element -> element.toLowerCase().contains(style.toLowerCase())))
                .collect(Collectors.toList());
    }

    public List<ProgramskiJezikModel> findAllByPopularFrameworks(String framework){
        return this.programskiJeziciRepository.findAllCustom()
                .stream()
                .filter(programskiJezik ->
                        programskiJezik.getPopularFrameworks()
                                .stream()
                                .anyMatch(element -> element.toLowerCase().contains(framework.toLowerCase())))
                .collect(Collectors.toList());
    }

    public List<ProgramskiJezikModel> findAllByPrimaryUses(String primaryUse){
        return this.programskiJeziciRepository.findAllCustom()
                .stream()
                .filter(programskiJezik ->
                        programskiJezik.getPrimaryUses()
                                .stream()
                                .anyMatch(element -> element.toLowerCase().contains(primaryUse.toLowerCase())))
                .collect(Collectors.toList());
    }



}
