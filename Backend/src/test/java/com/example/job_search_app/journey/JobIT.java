package com.example.job_search_app.journey;

import com.example.job_search_app.dto.JobDTO;
import com.example.job_search_app.entities.Job;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class JobIT {

    @Autowired
    private WebTestClient webTestClient;
    String JOB_URI = "/api/v1/jobs";

    JobDTO request = new JobDTO(
            "Full stack","2 years java","HCSC","chicago",
            LocalDate.now(),"interview",false
    );
    Job expectedJob = new Job(
            "Full stack","2 years java","HCSC","chicago",
            LocalDate.now(),"interview",false
    );
    @Test
    void canRegisterAJob() {

        //send post
        webTestClient.post()
                .uri(JOB_URI)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(request), JobDTO.class)
                .exchange()
                .expectStatus()
                .isOk();
    }

    @Test
    void canGetAll() {

        List<Job> allJobs = webTestClient.get()
                .uri(JOB_URI)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(new ParameterizedTypeReference<Job>() {
                })
                .returnResult()
                .getResponseBody();



        assertThat(allJobs).usingRecursiveFieldByFieldElementComparatorIgnoringFields("id")
                .contains(expectedJob);
    }

}
