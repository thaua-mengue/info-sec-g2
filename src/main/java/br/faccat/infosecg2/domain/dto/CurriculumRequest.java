package br.faccat.infosecg2.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumRequest {

    private String name;

    private String phoneNumber;

    private String email;

    private String webSite;

    private String experience;
}
