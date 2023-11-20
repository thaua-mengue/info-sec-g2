package br.faccat.infosecg2.service;

import br.faccat.infosecg2.domain.dto.CurriculumRequest;
import br.faccat.infosecg2.domain.entity.Curriculum;
import br.faccat.infosecg2.repository.CurriculumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurriculumService {

    private final CurriculumRepository curriculumRepository;

    public List<Curriculum> getAll() {
        try {
            return curriculumRepository.findAll();
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public Curriculum getCurriculumById(Long id) {
        try {
            return curriculumRepository.getReferenceById(id);
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public Curriculum saveCurriculum(CurriculumRequest curriculumRequest) {
        try {
            return curriculumRepository.save(new Curriculum(curriculumRequest));
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }
}