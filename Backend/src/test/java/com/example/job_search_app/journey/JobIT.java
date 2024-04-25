package com.example.job_search_app.journey;

import com.example.job_search_app.dto.JobDTO;
import com.example.job_search_app.entities.Job;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
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

    //    Job expectedJob = new Job(1L,
//            "Full stack","2 years java","HCSC","chicago",
//            LocalDate.now(),"interview",false
//    );
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

        JobDTO request = new JobDTO(
                "Full stack", "2 years java", "HCSC", "chicago",
                LocalDate.now(), "interview", false
        );

        webTestClient.post()
                .uri("/api/v1/jobs")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(request), JobDTO.class)
                .exchange()
                .expectStatus().isOk();

        // Then, retrieve all jobs
        List<JobDTO> allJobs = webTestClient.get()
                .uri("/api/v1/jobs")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(JobDTO.class)
                .returnResult().getResponseBody();

        // Compare the size of the retrieved list with 1
        assertThat(allJobs).isNotNull().hasSize(1);

        // Compare the attributes of the first job in the list with the expected job
        assert allJobs != null;
        assertThat(allJobs.get(0)).isEqualTo(request);
    }
}
