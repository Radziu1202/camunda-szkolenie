package com.example.compensation;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class BookFlight implements JavaDelegate{

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        execution.setVariable("lot", "zarezerowany");
        System.out.println("Zarezerwowano lot");

    }
}
