package org.openmrs.module.appframework.workflow;

import java.util.Iterator;
import java.util.Map;

public class IterativeActionProcessor implements ActionProcessor {

    @Override
    public Action process(Action currentAction, WorkflowDescriptor workflow, Map<String, Object[]> parameters) {

        if (currentAction == null) {
            return workflow.getActions().get(0);
        }

        Iterator<Action> i = workflow.getActions().iterator();

        while (i.hasNext()) {
            Action action = i.next();

            if (action.equals(currentAction)) {
                return i.next();
            }
        }

        throw new RuntimeException("invalid currentActionId");
    }
}
