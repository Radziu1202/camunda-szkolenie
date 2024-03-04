package pl.mieszkanie;

import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.*;
import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.withVariables;
import static org.junit.Assert.assertEquals;

import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.ProcessEngineConfiguration;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.history.HistoricVariableInstance;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.camunda.bpm.engine.test.RequiredHistoryLevel;
import org.camunda.bpm.engine.test.mock.Mocks;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

@RequiredHistoryLevel(ProcessEngineConfiguration.HISTORY_ACTIVITY)

public class ZakupMieszkaniaTest {

    @Rule
    public ProcessEngineRule processEngineRule = new ProcessEngineRule();

    @Test
    @Deployment(resources = {"ZakupMieszkania.bpmn","dostepnoscMieszkania.dmn",})
    public void testZakupMieszkania() {
        RuntimeService runtimeService = processEngineRule.getRuntimeService();
        HistoryService historyService = processEngineRule.getHistoryService();


        VariableMap variablesIn = Variables.createVariables()
                .putValue("podanie_metraz", 20)
                .putValue("podanie_liczbaPokoi",2)
                .putValue("podanie_cenaZaMetr",7000)
                .putValue("podanie_czyStrzezone",true)
                .putValue("podanie_czyBalkon",false)
                .putValue("podanie_pietro",10);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("ZakupMieszkania", variablesIn);


        assertThat(processInstance).isWaitingAt("potencjalnaRezerwacjaId");
        complete(task(processInstance), withVariables("podanie_dokonajRezerwacji", false));
        assertThat(processInstance).isWaitingAt("odbiorStatusuId");
        complete(task(processInstance));
        assertThat(processInstance).isEnded();


        List<HistoricVariableInstance> statusVariableList = historyService.createHistoricVariableInstanceQuery().variableName("status").list();
        HistoricVariableInstance status = statusVariableList.get(statusVariableList.size()-1);
        assertEquals("Anulowane",status.getValue()) ;

    }
}
