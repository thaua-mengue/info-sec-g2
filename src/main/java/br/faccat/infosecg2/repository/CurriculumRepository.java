package br.faccat.infosecg2.repository;

import br.faccat.infosecg2.domain.entity.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculumRepository extends JpaRepository<Curriculum, Long> {
}