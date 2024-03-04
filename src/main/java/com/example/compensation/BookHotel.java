package com.example.compensation;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.Arrays;
import java.util.logging.Logger;

public class BookHotel implements JavaDelegate{

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        execution.setVariable("hotel", "zarezerowany");
        System.out.println("Zarezerwowano hotel");

    }
}
