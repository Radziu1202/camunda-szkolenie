package com.example.listeners;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;

public class AssignmentListener implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {
        System.out.println("Assign task for user: "+   delegateTask.getAssignee());
    }
}
