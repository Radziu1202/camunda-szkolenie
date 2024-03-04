package pl.mieszkanie;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;


public class AdministracjaCallback implements JavaDelegate {
    public void execute(DelegateExecution execution) throws Exception {
        RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
        runtimeService.createMessageCorrelation("AdministracjaMsg")
                .processInstanceId(execution.getVariable("parentBussinesKey").toString())
                .setVariable("potwierdzenieId", execution.getVariable("potwierdzenieId"))
                .setVariable("decyzja_czyOplacono", execution.getVariable("decyzja_czyOplacono"))
                .setVariable("aktId",execution.getVariable("aktId"))
                .correlateWithResult();
    }
}
