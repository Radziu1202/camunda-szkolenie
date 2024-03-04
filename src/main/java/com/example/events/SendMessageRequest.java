package com.example.events;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.HashMap;
import java.util.Map;

public class SendMessageRequest implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("wysyłam wiadomość");
        RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
        Map<String, Object> processVariables =  execution.getVariables();
        processVariables.put("instanceId", execution.getProcessInstanceId());
        runtimeService.startProcessInstanceByMessage("DaneMessage", processVariables);
    }
}
