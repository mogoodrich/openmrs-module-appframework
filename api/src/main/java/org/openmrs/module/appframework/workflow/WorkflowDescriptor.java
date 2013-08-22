package org.openmrs.module.appframework.workflow;

import org.codehaus.jackson.annotate.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;
import org.openmrs.module.appframework.domain.validators.ValidationErrorMessages;

import java.util.List;

public class WorkflowDescriptor {

    @NotEmpty(message = ValidationErrorMessages.EXTENSION_ID_NOT_EMPTY_MESSAGE)
    @JsonProperty
    protected String id;

    @JsonProperty
    protected List<Action> actions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}
