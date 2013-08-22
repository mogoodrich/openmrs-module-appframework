package org.openmrs.module.appframework.workflow;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class Action {

    @JsonProperty
    protected String id;

    @JsonProperty
    protected String workflowId;

    @JsonProperty
    protected String url;

    @JsonProperty
    protected List<ActionProcessor> postProcessors;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(String workflowId) {
        this.workflowId = workflowId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<ActionProcessor> getPostProcessors() {
        return postProcessors;
    }

    public void setPostProcessors(List<ActionProcessor> postProcessors) {
        this.postProcessors = postProcessors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Action))
            return false;

        Action that = (Action) o;

        if (id != null ? !id.equals(that.id) : that.id != null)
            return false;

        return true;
    }
}
