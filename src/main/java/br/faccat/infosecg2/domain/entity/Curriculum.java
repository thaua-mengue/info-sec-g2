package br.faccat.infosecg2.domain.entity;

import br.faccat.infosecg2.domain.dto.CurriculumRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@JsonIgnoreProperties(value = {"curriculum", "hibernateLazyInitializer"})
public class Curriculum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phoneNumber;

    private String email;

    private String webSite;

    private String experience;

    public Curriculum(CurriculumRequest curriculumRequest) {
        this.name = curriculumRequest.getName();
        this.phoneNumber = curriculumRequest.getPhoneNumber();
        this.email = curriculumRequest.getEmail();
        this.webSite = curriculumRequest.getWebSite();
        this.experience = curriculumRequest.getExperience();
    }
}