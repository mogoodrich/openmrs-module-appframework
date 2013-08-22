package org.openmrs.module.appframework.domain;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;
import org.openmrs.module.appframework.domain.validators.ValidationErrorMessages;
import org.openmrs.module.appframework.workflow.WorkflowDescriptor;

import java.util.Map;

public class Extension implements Comparable<Extension> {
	
	@NotEmpty(message = ValidationErrorMessages.EXTENSION_ID_NOT_EMPTY_MESSAGE)
	@JsonProperty
	protected String id;
	
	@JsonProperty
	protected String appId;
	
	@JsonProperty
	protected String extensionPointId;

    @JsonProperty
    protected WorkflowDescriptor workflowDescriptor;
	
	@JsonProperty
	protected String type;
	
	@JsonProperty
	protected String label;
	
	@JsonProperty
	protected String url;
	
	@JsonProperty
	protected String icon;
	
	@JsonProperty
	protected int order;
	
	@JsonProperty
	protected String requiredPrivilege;

    @JsonProperty
    protected String featureToggle;

    @JsonProperty
    protected String require;
	
	@JsonProperty
	protected String script;
	
	@JsonProperty
	protected Map<String, Object> extensionParams;

    /**
     * Will be set by {@link org.openmrs.module.appframework.AppFrameworkActivator} if this extension is defined within
     * an app
     */
    @JsonIgnore
    transient private AppDescriptor belongsTo;

    public Extension() {
	}
	
	public Extension(String id, String appId, String extensionPointId, String type, String label, String url, int order) {
		this.id = id;
		this.appId = appId;
		this.extensionPointId = extensionPointId;
		this.type = type;
		this.label = label;
		this.url = url;
		this.order = order;
	}
	
	public Extension(String id, String appId, String extensionPointId, String type, String label, String url, int order,
	    String requiredPrivilege, Map<String, Object> extensionParams) {
		this.id = id;
		this.appId = appId;
		this.extensionPointId = extensionPointId;
		this.type = type;
		this.label = label;
		this.url = url;
		this.order = order;
		this.requiredPrivilege = requiredPrivilege;
		this.extensionParams = extensionParams;
	}
	
	public String getId() {
		return id;
	}
	
	public String getAppId() {
		return appId;
	}
	
	public String getExtensionPointId() {
		return extensionPointId;
	}
	
	public String getType() {
		return type;
	}
	
	public String getLabel() {
		return label;
	}
	
	public String getUrl() {
		return url;
	}
	
	public String getIcon() {
		return icon;
	}
	
	public int getOrder() {
		return order;
	}
	
	public String getRequiredPrivilege() {
		return requiredPrivilege;
	}
	
	public String getScript() {
		return script;
	}
	
	public Map<String, Object> getExtensionParams() {
		return extensionParams;
	}
	
	public void setExtensionParams(Map<String, Object> extensionParams) {
		this.extensionParams = extensionParams;
	}

    public String getFeatureToggle() {
        return featureToggle;
    }

    public void setFeatureToggle(String featureToggle) {
        this.featureToggle = featureToggle;
    }

    @Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Extension))
			return false;
		
		Extension extension = (Extension) o;
		
		if (id != null ? !id.equals(extension.id) : extension.id != null)
			return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}
	
	@Override
	public int compareTo(Extension o) {
		return new Integer(this.order).compareTo(o.order);
	}

    public void setBelongsTo(AppDescriptor belongsTo) {
        this.belongsTo = belongsTo;
    }

    @JsonIgnore
    public AppDescriptor getBelongsTo() {
        return belongsTo;
    }

    public String getRequire() {
        return require;
    }

    public void setRequire(String require) {
        this.require = require;
    }
}
