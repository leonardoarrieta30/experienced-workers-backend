package com.concyssa.experiencedworkers.recognition.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("recognitionMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public WorkerMapper workerMapper(){
        return new WorkerMapper();
    }

    @Bean
    public NurseMapper nurseMapper(){
        return new NurseMapper();
    }

}
