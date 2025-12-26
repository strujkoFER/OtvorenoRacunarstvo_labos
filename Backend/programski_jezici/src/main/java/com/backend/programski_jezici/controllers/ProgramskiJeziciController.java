package com.backend.programski_jezici.controllers;

import com.backend.programski_jezici.models.ProgramskiJezikModel;
import com.backend.programski_jezici.services.ProgramskiJeziciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/programmingLanguages")
@CrossOrigin(origins = "http://localhost:4200")
public class ProgramskiJeziciController {

    private ProgramskiJeziciService programskiJeziciService;

    @Autowired
    public ProgramskiJeziciController(ProgramskiJeziciService programskiJeziciService) {
        this.programskiJeziciService = programskiJeziciService;
    }

    @GetMapping("/getAll")
    public List<ProgramskiJezikModel> findAll() {
        return programskiJeziciService.findAll();
    }

    @GetMapping("/getByName")
    public List<ProgramskiJezikModel> findAllByName(
            @RequestParam String name) {
        return programskiJeziciService.findAllByName(name);
    }

    @GetMapping("/getByYearCreated")
    public List<ProgramskiJezikModel> findAllByYearCreated(
            @RequestParam int yearCreated) {
        return programskiJeziciService.findAllByYearCreated(yearCreated);
    }

    @GetMapping("/getByCreator")
    public List<ProgramskiJezikModel> findAllByCreator(
            @RequestParam String creator) {
        return programskiJeziciService.findAllByCreator(creator);
    }

    @GetMapping("/getByDescription")
    public List<ProgramskiJezikModel> findAllByDescription(
            @RequestParam String description) {
        return programskiJeziciService.findAllByDescription(description);
    }

    @GetMapping("/getByWebsite")
    public List<ProgramskiJezikModel> findAllByWebsite(
            @RequestParam String website) {
        return programskiJeziciService.findAllByWebsite(website);
    }

    @GetMapping("/getByTypeChecking")
    public List<ProgramskiJezikModel> findAllByTypeChecking(
            @RequestParam String typeChecking) {
        return programskiJeziciService.findAllByTypeChecking(typeChecking);
    }

    @GetMapping("/getByStrength")
    public List<ProgramskiJezikModel> findAllByStrength(
            @RequestParam String strength) {
        return programskiJeziciService.findAllByStrength(strength);
    }

    @GetMapping("/getByStyle")
    public List<ProgramskiJezikModel> findAllByStyle(
            @RequestParam String style) {
        return programskiJeziciService.findAllByStyle(style);
    }

    @GetMapping("/getByWildcard")
    public List<ProgramskiJezikModel> findAllByWildcard(
            @RequestParam String wildcard) {
        return programskiJeziciService.findAllByWildcard(wildcard);
    }

    @GetMapping("/getByPopularFrameworks")
    public List<ProgramskiJezikModel> findAllByPopularFrameworks(
            @RequestParam String framework) {
        return programskiJeziciService.findAllByPopularFrameworks(framework);
    }

    @GetMapping("/getByPrimaryUses")
    public List<ProgramskiJezikModel> findAllByPrimaryUses(
            @RequestParam String primaryUse) {
        return programskiJeziciService.findAllByPrimaryUses(primaryUse);
    }

    @PostMapping("/postProgramskiJezik")
    public ResponseEntity<Object> create(@RequestBody ProgramskiJezikModel body) {
        ProgramskiJezikModel saved = programskiJeziciService.save(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/deleteProgramskiJezik/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        if (!programskiJeziciService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        programskiJeziciService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/putProgramskiJezik/{id}")
    public ResponseEntity<Object> update(
            @PathVariable int id,
            @RequestBody ProgramskiJezikModel body
    ) {
        try {
            ProgramskiJezikModel updated = programskiJeziciService.update(id, body);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }



}
