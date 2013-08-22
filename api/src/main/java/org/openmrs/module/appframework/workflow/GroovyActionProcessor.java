package org.openmrs.module.appframework.workflow;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

import java.util.Iterator;
import java.util.Map;

public class GroovyActionProcessor implements ActionProcessor {

    private String code;

    @Override
    public Action process(Action currentAction, WorkflowDescriptor workflow, Map<String, Object[]> parameters) {

        Binding binding = new Binding();
        binding.setProperty("params", parameters);

        GroovyShell shell = new GroovyShell(binding);

        Object actionIdObj = shell.evaluate(code);

        if (actionIdObj != null) {
            String actionId = (String) actionIdObj;

            Iterator<Action> i = workflow.getActions().iterator();

            while (i.hasNext()) {
                Action action = i.next();
                if (actionId.equals(action.getId())) {
                    return action;
                }
            }
        }

        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
