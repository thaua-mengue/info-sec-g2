package br.faccat.infosecg2.controller;

import br.faccat.infosecg2.domain.dto.CurriculumRequest;
import br.faccat.infosecg2.domain.entity.Curriculum;
import br.faccat.infosecg2.service.CurriculumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/curriculum")
@RequiredArgsConstructor
public class CurriculumController {

    private final CurriculumService curriculumService;

    @GetMapping
    public ResponseEntity<List<Curriculum>> getAll(@RequestHeader (value = "Authorization") String authorization) {
        return ResponseEntity.ok(curriculumService.getAll(authorization));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curriculum> getById(
            @PathVariable Long id,
            @RequestHeader (value = "Authorization") String authorization) {
        return ResponseEntity.ok(curriculumService.getCurriculumById(id, authorization));
    }

    @PostMapping
    public ResponseEntity<Curriculum> saveCurriculum(
            @RequestHeader (value = "Authorization") String authorization,
            @RequestHeader(value = "X-Name") String name,
            @RequestHeader(value = "X-PhoneNumber", required = false) String phoneNumber,
            @RequestHeader(value = "X-Email") String email,
            @RequestHeader(value = "X-WebSite", required = false) String webSite,
            @RequestHeader(value = "X-Experience") String experience) {

        var curriculumRequest = new CurriculumRequest(name, phoneNumber, email, webSite, experience);
        return ResponseEntity.status(HttpStatus.CREATED).body(curriculumService.saveCurriculum(authorization, curriculumRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable Long id,
            @RequestHeader (value = "Authorization") String authorization) {
        curriculumService.getCurriculumById(id, authorization);
        return ResponseEntity.ok().build();
    }
}