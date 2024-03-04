package com.example;

import org.camunda.bpm.engine.*;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

public class Services implements JavaDelegate {

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    TaskService taskService;

    @Autowired
    RepositoryService repositoryService;

    @Autowired
    HistoryService historyService;
    @Autowired
    ManagementService managementService;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
    }
}
