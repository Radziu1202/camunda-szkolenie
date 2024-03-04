package com.example.compensation;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class FlightCompensation implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
       execution.removeVariable("lot");
        System.out.println("rezerwacja lotu usunięta");
    }
}