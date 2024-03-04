package pl.mieszkanie;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.HashMap;
import java.util.Map;

public class AdministracjaRequest implements JavaDelegate {
    public void execute(DelegateExecution execution) throws Exception {
        RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
        Map<String, Object> processVariables = new HashMap<String, Object>();
        processVariables.put("parentBussinesKey", execution.getProcessInstanceId());
        processVariables.put("potwierdzenieId", execution.getVariable("potwierdzenieId"));
        processVariables.put("decyzja_czyOplacono", execution.getVariable("decyzja_czyOplacono"));

        runtimeService.startProcessInstanceByMessage("PotwierdzenieZakupuMsg", processVariables);
    }
}
