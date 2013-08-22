package org.openmrs.module.appframework.workflow;

import java.util.Map;

public interface ActionProcessor {

    Action process(Action action, WorkflowDescriptor workflow, Map<String, Object[]> parameters);

}
