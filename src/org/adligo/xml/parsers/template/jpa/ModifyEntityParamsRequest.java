package org.adligo.xml.parsers.template.jpa;

import org.adligo.i.storage.ModifyEntityRequest;
import org.adligo.models.params.client.I_TemplateParams;

public class ModifyEntityParamsRequest extends ModifyEntityRequest {
	private I_TemplateParams params;

	public I_TemplateParams getParams() {
		return params;
	}

	public void setParams(I_TemplateParams params) {
		this.params = params;
	}
	
}
