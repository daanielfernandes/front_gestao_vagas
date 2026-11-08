package br.com.danielarruda.front_gestao_vagas.modules.candidate.dto;

import lombok.Data;

@Data 
public class CreateJobsDTO {
    private String description;
    private String benefits;
    private String level;
}
