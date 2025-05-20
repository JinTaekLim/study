package com.study.study.test;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class Controller {

    private final JobLauncher jobLauncher;
    private final JobRegistry jobRegistry;

    @GetMapping("/test")
    public String test(String value) throws Exception {

        JobParameters jobParameters = new JobParametersBuilder()
            .addString("key", value)
            .toJobParameters();

        jobLauncher.run(jobRegistry.getJob("customerJob"), jobParameters);
        return "test";
    }
}
