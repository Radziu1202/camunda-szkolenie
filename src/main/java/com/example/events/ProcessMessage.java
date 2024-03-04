package com.example.events;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ProcessMessage implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("przetwarzam wiadomosc");
        execution.setVariable("zwrot", "Szanowny Pan"+execution.getVariable("adresat"));
    }
}
