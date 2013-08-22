package org.openmrs.module.appframework.workflow;

import java.util.Iterator;
import java.util.Map;

public class WorkflowEngine {

    public Action postProcessAction(Action currentAction, WorkflowDescriptor workflowDescriptor, Map<String, Object[]> parameters) {

        Iterator<ActionProcessor> i = currentAction.getPostProcessors().iterator();

        while (true) {
            Action nextAction = i.next().process(currentAction, workflowDescriptor, parameters);

            if (!i.hasNext()) {
                return nextAction;
            }

        }

    }

}
