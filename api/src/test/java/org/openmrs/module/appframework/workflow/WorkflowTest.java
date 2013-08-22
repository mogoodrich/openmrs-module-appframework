package org.openmrs.module.appframework.workflow;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WorkflowTest {


    @Test
    public void test_shouldIterateThroughActions() {

        WorkflowEngine workflowEngine = new WorkflowEngine();

        Action action1 = new Action();
        action1.setId("action1");
        ActionProcessor action1Processor = new IterativeActionProcessor();
        action1.setPostProcessors(Arrays.asList(action1Processor));

        Action action2 = new Action();
        action2.setId("action2");
        ActionProcessor action2Processor = new IterativeActionProcessor();
        action2.setPostProcessors(Arrays.asList(action2Processor));

        WorkflowDescriptor workflowDescriptor = new WorkflowDescriptor();
        workflowDescriptor.setActions(Arrays.asList(action1, action2));

        Action firstAction = workflowDescriptor.getActions().get(0);

        Action nextAction = workflowEngine.postProcessAction(firstAction, workflowDescriptor, null);
        assertThat(nextAction, is(action2));
    }


    @Test
    public void test_shouldProcessBasedOnGroovyScript() {

        WorkflowEngine workflowEngine = new WorkflowEngine();

        Action action1 = new Action();
        action1.setId("action1");
        GroovyActionProcessor action1Processor = new GroovyActionProcessor();
        action1Processor.setCode("return \'action3\';");
        List<ActionProcessor> actionProcessors = new ArrayList<ActionProcessor>();
        actionProcessors.add(action1Processor);
        action1.setPostProcessors(actionProcessors);

        Action action2 = new Action();
        action2.setId("action2");

        Action action3 = new Action();
        action3.setId("action3");

        WorkflowDescriptor workflowDescriptor = new WorkflowDescriptor();
        workflowDescriptor.setActions(Arrays.asList(action1, action2, action3));

        Action firstAction = workflowDescriptor.getActions().get(0);

        Action nextAction = workflowEngine.postProcessAction(firstAction, workflowDescriptor, null);
        assertThat(nextAction, is(action3));
    }
}
