package org.adligo.xml.parsers.template.jpa;

import org.adligo.i.storage.SelectRequest;
import org.adligo.models.params.client.I_TemplateParams;

public class ParamsSelectRequest extends SelectRequest {
	private I_TemplateParams params;

	public I_TemplateParams getParams() {
		return params;
	}

	public void setParams(I_TemplateParams params) {
		this.params = params;
	}
	
}
