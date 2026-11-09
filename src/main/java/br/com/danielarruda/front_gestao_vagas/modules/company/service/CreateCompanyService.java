package br.com.danielarruda.front_gestao_vagas.modules.company.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.danielarruda.front_gestao_vagas.modules.company.dto.CreateCompanyDTO;

@Service
public class CreateCompanyService {
    
    @Value ("${host.api.gestao.vagas}")
    private String hostAPIGestaoVagas;

    public void execute(CreateCompanyDTO createCompanyDTO) {

        RestTemplate rt = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CreateCompanyDTO> request = new HttpEntity<>(createCompanyDTO, headers);
        var url = hostAPIGestaoVagas.concat("/company/");
        var result = rt.postForObject(url, request, String.class);
        System.out.println(result);

    }
}
