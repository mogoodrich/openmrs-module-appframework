package org.openmrs.module.appframework.page.controller.workflow;

import org.openmrs.Encounter;
import org.openmrs.api.EncounterService;
import org.openmrs.module.appframework.workflow.Action;
import org.openmrs.module.appframework.workflow.WorkflowDescriptor;
import org.openmrs.module.appframework.workflow.WorkflowEngine;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WorkflowEngineController {

    // TODO: this needs to be a service--WorkflowService
    WorkflowEngine workflowEngine = new WorkflowEngine();

    public void postProcessActionController(@RequestParam("workflowAndAction") String workflowAndAction,
                                            EncounterService encounterService,
                                            HttpServletRequest request) {

        // TODO: this would really fetch the workflow and action from a service;

        Action action = workflowEngine.postProcessAction(new Action(), new WorkflowDescriptor(), convertRequestParams(request, encounterService));

        // TODO: if action == null, return the, otherwise call the new action, appending the proper return Url
        // TODO: convert the parameters and send them back to the form
        // TODO: also need to be able to pass in patient and visit?
    }

    // TODO: move these conversions into the service layer in some way? want to avoid having to pass all the services around
    private Map<String,Object[]> convertRequestParams(HttpServletRequest request, EncounterService encounterService) {

        Map<String, Object[]> workflowParams = new HashMap<String, Object[]>();

        Iterator<Map.Entry<String,String[]>> i = request.getParameterMap().entrySet().iterator();

        while (i.hasNext()) {

            Map.Entry<String, String[]> requestParam = i.next();

           // TODO: make something generic that works for all OpenMRS object type?  pass uuid?
           if (requestParam.getKey().equals("encounterId")) {
                List<Encounter> encounters = new ArrayList<Encounter>();
                for (String encounterId : requestParam.getValue()) {
                    encounters.add(encounterService.getEncounter(Integer.valueOf(encounterId)));
                }
                workflowParams.put("encounter", encounters.toArray());
            }
            else {
                workflowParams.put(requestParam.getKey(), requestParam.getValue());
            }

        }

        return workflowParams;

    }



}
