package com.backend.programski_jezici.controllers;

import com.backend.programski_jezici.models.ApiWrapper;
import com.backend.programski_jezici.models.ProgramskiJezikModel;
import com.backend.programski_jezici.services.ProgramskiJeziciService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
    })
    public ResponseEntity<ApiWrapper<List<ProgramskiJezikModel>>> findAll() {
        List<ProgramskiJezikModel> all = programskiJeziciService.findAll();
        return ResponseEntity.ok(new ApiWrapper<>(all, 200));
    }

    @GetMapping("getById/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    public ResponseEntity<ApiWrapper<ProgramskiJezikModel>> getById(@PathVariable int id) {
        return programskiJeziciService.findById(id)
                .map(language -> ResponseEntity.ok(new ApiWrapper<>(language, 200)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiWrapper<>(null, 404)));
    }

    @GetMapping("/getByName")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
    })
    public ResponseEntity<ApiWrapper<List<ProgramskiJezikModel>>> findAllByName(
            @RequestParam String name) {
        List<ProgramskiJezikModel> all = programskiJeziciService.findAllByName(name);
        return ResponseEntity.ok(new ApiWrapper<>(all, 200));
    }

    @GetMapping("/getByYearCreated")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
    })
    public ResponseEntity<ApiWrapper<List<ProgramskiJezikModel>>> findAllByYearCreated(
            @RequestParam int yearCreated) {
        List<ProgramskiJezikModel> all = programskiJeziciService.findAllByYearCreated(yearCreated);
        return ResponseEntity.ok(new ApiWrapper<>(all, 200));
    }

    @GetMapping("/getByCreator")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
    })
    public ResponseEntity<ApiWrapper<List<ProgramskiJezikModel>>> findAllByCreator(
            @RequestParam String creator) {
        List<ProgramskiJezikModel> all = programskiJeziciService.findAllByCreator(creator);
        return ResponseEntity.ok(new ApiWrapper<>(all, 200));
    }

    @GetMapping("/getByDescription")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
    })
    public ResponseEntity<ApiWrapper<List<ProgramskiJezikModel>>> findAllByDescription(
            @RequestParam String description) {
        List<ProgramskiJezikModel> all = programskiJeziciService.findAllByDescription(description);
        return ResponseEntity.ok(new ApiWrapper<>(all, 200));
    }

    @GetMapping("/getByWebsite")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
    })
    public ResponseEntity<ApiWrapper<List<ProgramskiJezikModel>>> findAllByWebsite(
            @RequestParam String website) {
        List<ProgramskiJezikModel> all = programskiJeziciService.findAllByWebsite(website);
        return ResponseEntity.ok(new ApiWrapper<>(all, 200));
    }

    @GetMapping("/getByTypeChecking")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
    })
    public ResponseEntity<ApiWrapper<List<ProgramskiJezikModel>>> findAllByTypeChecking(
            @RequestParam String typeChecking) {
        List<ProgramskiJezikModel> all = programskiJeziciService.findAllByTypeChecking(typeChecking);
        return ResponseEntity.ok(new ApiWrapper<>(all, 200));
    }

    @GetMapping("/getByStrength")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
    })
    public ResponseEntity<ApiWrapper<List<ProgramskiJezikModel>>> findAllByStrength(
            @RequestParam String strength) {
        List<ProgramskiJezikModel> all = programskiJeziciService.findAllByStrength(strength);
        return ResponseEntity.ok(new ApiWrapper<>(all, 200));
    }

    @GetMapping("/getByStyle")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
    })
    public ResponseEntity<ApiWrapper<List<ProgramskiJezikModel>>> findAllByStyle(
            @RequestParam String style) {
        List<ProgramskiJezikModel> all = programskiJeziciService.findAllByStyle(style);
        return ResponseEntity.ok(new ApiWrapper<>(all, 200));
    }

    @GetMapping("/getByWildcard")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
    })
    public ResponseEntity<ApiWrapper<List<ProgramskiJezikModel>>> findAllByWildcard(
            @RequestParam String wildcard) {
        List<ProgramskiJezikModel> all = programskiJeziciService.findAllByWildcard(wildcard);
        return ResponseEntity.ok(new ApiWrapper<>(all, 200));
    }

    @GetMapping("/getByPopularFrameworks")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
    })
    public ResponseEntity<ApiWrapper<List<ProgramskiJezikModel>>> findAllByPopularFrameworks(
            @RequestParam String framework) {
        List<ProgramskiJezikModel> all = programskiJeziciService.findAllByPopularFrameworks(framework);
        return ResponseEntity.ok(new ApiWrapper<>(all, 200));
    }

    @GetMapping("/getByPrimaryUses")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
    })
    public ResponseEntity<ApiWrapper<List<ProgramskiJezikModel>>> findAllByPrimaryUses(
            @RequestParam String primaryUse) {
        List<ProgramskiJezikModel> all = programskiJeziciService.findAllByPrimaryUses(primaryUse);
        return ResponseEntity.ok(new ApiWrapper<>(all, 200));
    }

    @PostMapping("/postProgramskiJezik")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<ApiWrapper<ProgramskiJezikModel>> create(@RequestBody ProgramskiJezikModel body) {
        try {
            ProgramskiJezikModel saved = programskiJeziciService.save(body);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiWrapper<>(saved, 201));
        } catch (Exception ex) {
            ApiWrapper<ProgramskiJezikModel> response = new ApiWrapper<>(null, 500);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @DeleteMapping("/deleteProgramskiJezik/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No Content"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    public ResponseEntity<Object> delete(@PathVariable int id) {
        if (!programskiJeziciService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiWrapper<>(null, 404));
        }

        programskiJeziciService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ApiWrapper<>(null, 204));
    }

    @PutMapping("/putProgramskiJezik/{id}")
    @DeleteMapping("/deleteProgramskiJezik/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    public ResponseEntity<ApiWrapper<ProgramskiJezikModel>> update(
            @PathVariable int id,
            @RequestBody ProgramskiJezikModel body
    ) {
        try {
            ProgramskiJezikModel updated = programskiJeziciService.update(id, body);
            return ResponseEntity.ok(new ApiWrapper<>(updated, 200));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiWrapper<>(null, 404));
        }
    }



}
