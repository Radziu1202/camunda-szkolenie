package com.example.retries;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

public class ExceptionPrintThrow implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("próbuje wykonać zadanie");
        execution.createIncident("TestError", execution.getId(),"Rzucam błąd");
        throw new RuntimeException("An error occurred");
    }
}
