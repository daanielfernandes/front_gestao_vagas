package br.com.danielarruda.front_gestao_vagas.modules.candidate.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.danielarruda.front_gestao_vagas.modules.candidate.dto.CreateJobsDTO;

@Service 
public class CreateJobService {
    
    public String execute(CreateJobsDTO job,  String token) {
        RestTemplate rt = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);

        HttpEntity<CreateJobsDTO> request = new HttpEntity<>(job,headers);

        var result = rt.postForObject("http://localhost:8080/company/job/", request, String.class);

        System.out.println(result);
        return result;
    }
}
