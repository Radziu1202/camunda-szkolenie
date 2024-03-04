package com.example.listeners;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;

public class CompleteListener implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {
        System.out.println("Complete task for user: "+   delegateTask.getAssignee());
    }
}
