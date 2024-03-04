package com.example.listeners;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;

public class TimeoutListener implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {
        System.out.println("Timeout task for user: "+   delegateTask.getAssignee());
    }
}