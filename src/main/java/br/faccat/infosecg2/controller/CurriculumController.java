package br.faccat.infosecg2.controller;

import br.faccat.infosecg2.domain.dto.CurriculumRequest;
import br.faccat.infosecg2.domain.entity.Curriculum;
import br.faccat.infosecg2.service.CurriculumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curriculum")
@RequiredArgsConstructor
public class CurriculumController {

    private final CurriculumService curriculumService;

    @GetMapping
    public ResponseEntity<List<Curriculum>> getAll() {
        return ResponseEntity.ok(curriculumService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curriculum> getById(@PathVariable Long id) {
        return ResponseEntity.ok(curriculumService.getCurriculumById(id));
    }

    @PostMapping
    public ResponseEntity<Curriculum> saveCurriculum(
            @RequestHeader(value = "X-Name") String name,
            @RequestHeader(value = "X-PhoneNumber", required = false) String phoneNumber,
            @RequestHeader(value = "X-Email") String email,
            @RequestHeader(value = "X-WebSite", required = false) String webSite,
            @RequestHeader(value = "X-Experience") String experience) {

        var curriculumRequest = new CurriculumRequest(name, phoneNumber, email, webSite, experience);
        return ResponseEntity.status(HttpStatus.CREATED).body(curriculumService.saveCurriculum(curriculumRequest));
    }
}