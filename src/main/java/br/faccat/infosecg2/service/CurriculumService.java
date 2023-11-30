package br.faccat.infosecg2.service;

import br.faccat.infosecg2.domain.dto.CurriculumRequest;
import br.faccat.infosecg2.domain.entity.Curriculum;
import br.faccat.infosecg2.repository.CurriculumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CurriculumService {

    // O ideal seria essa lista ficar pelo menos em um config-repo para poder ser alterado sem deploy e não ficar exposto no código.
    private static final List<String> AUTHORIZATIONS_LIST = List.of("Basic aW5mb3NlYzppbmZvc2VjMjAyMzI=");

    private final CurriculumRepository curriculumRepository;

    public List<Curriculum> getAll(String authorization) {
        try {
            verifyAuthorization(authorization);
            return curriculumRepository.findAll();
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public Curriculum getCurriculumById(Long id, String authorization) {
        try {
            verifyAuthorization(authorization);
            return curriculumRepository.getReferenceById(id);
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public Curriculum saveCurriculum(String authorization, CurriculumRequest curriculumRequest) {
        try {
            verifyAuthorization(authorization);
            return curriculumRepository.save(new Curriculum(curriculumRequest));
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    private void verifyAuthorization(String authorization) {
        if (!AUTHORIZATIONS_LIST.contains(authorization))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Operação não autorizada.");
    }
}