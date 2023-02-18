package com.example.splunkdemo.service;

import com.example.splunkdemo.dto.JobStatus;
import com.example.splunkdemo.dto.Order;
import com.example.splunkdemo.util.Mapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class JobService {

    Logger logger = LogManager.getLogger(JobService.class);

    public JobStatus process(Order order)  {
        logger.info("JobService:process request {} ", Mapper.mapToJsonString(order));
        if (otherApiResults()) {
            //rest call
            return JobStatus.SUCCESS;
        } else {
            return JobStatus.FAILED;
        }
    }

    private boolean otherApiResults() {
        return new Random().nextBoolean();
    }
}
