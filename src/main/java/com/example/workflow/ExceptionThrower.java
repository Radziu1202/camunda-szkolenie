package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ExceptionThrower implements JavaDelegate {


    @Override
    public void execute(DelegateExecution execution) throws Exception {
        throw new RuntimeException();
    }
}
