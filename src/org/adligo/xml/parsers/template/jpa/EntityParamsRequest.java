package org.adligo.xml.parsers.template.jpa;

import org.adligo.i.storage.EntityRequest;
import org.adligo.models.params.client.I_TemplateParams;

public class EntityParamsRequest extends EntityRequest {
	private I_TemplateParams params;

	public I_TemplateParams getParams() {
		return params;
	}

	public void setParams(I_TemplateParams params) {
		this.params = params;
	}
	
}
