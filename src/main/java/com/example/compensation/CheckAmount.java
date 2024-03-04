package com.example.compensation;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.Arrays;

public class CheckAmount implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        int kwota = (int) execution.getVariable("kwota");
        if (kwota < 1000){
            throw new RuntimeException("current amount is not enough");
        }
    }
}
