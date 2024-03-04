package com.example.events;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class SendMessageCallback implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("odebrałem wiadomość");
        RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();

        runtimeService.createMessageCorrelation("DaneMessage")
                .processInstanceId(execution.getVariable("parentBussinesKey").toString())
                .setVariables(execution.getVariables())
                .correlateWithResult();
    }

}
