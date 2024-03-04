package com.example.events;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ProcessInfo implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        if (execution.hasVariable("zwrot")){
            System.out.println(execution.getVariable("zwrot")+ " " + execution.getVariable("message"));
        }else{
            System.out.println("odebrano sygnał");
        }
    }
}
