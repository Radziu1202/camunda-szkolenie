package com.example.events;

import org.camunda.bpm.engine.delegate.*;
import org.camunda.bpm.engine.variable.VariableMap;

public class PrepareMessage implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("przygotowuje wiadomość");
        execution.setVariable("adresat", execution.getVariable("imie")+ " " +execution.getVariable("nazwisko"));
        if (Integer.parseInt(execution.getVariable("kwota").toString()) > 100){
            execution.setVariable("message", "Środki na koncie wystarczające");
        }else{
            execution.setVariable("message", "niewystarczające środki na koncie");
        }

    }
}
