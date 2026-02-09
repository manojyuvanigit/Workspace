package com.example.SpringBatch.SpringBatch.controller;

import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.JobExecution;
import org.springframework.batch.core.job.parameters.InvalidJobParametersException;
import org.springframework.batch.core.job.parameters.JobParameters;
import org.springframework.batch.core.job.parameters.JobParametersBuilder;
import org.springframework.batch.core.launch.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatchController {

    @Autowired
    private JobOperator jobOperator;

    @Autowired
     Job importPersonJob;


    @PostMapping("/import")
    public String JobLaunch(@PathVariable String jobName) throws JobInstanceAlreadyCompleteException, InvalidJobParametersException, JobExecutionAlreadyRunningException, JobRestartException {
        JobParameters params = new JobParametersBuilder()
                .addLong("runId", System.currentTimeMillis())
                .toJobParameters();
         jobOperator.start(importPersonJob, params);
        return "Job started";
    }
}
