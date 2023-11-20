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
    public ResponseEntity<Void> saveCurriculum(@RequestBody CurriculumRequest curriculumRequest) {
        curriculumService.saveCurriculum(curriculumRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
