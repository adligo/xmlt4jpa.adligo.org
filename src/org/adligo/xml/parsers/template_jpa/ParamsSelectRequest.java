package org.adligo.xml.parsers.template_jpa;

import org.adligo.i.db.SelectRequest;
import org.adligo.models.params.shared.I_TemplateParams;

public class ParamsSelectRequest extends SelectRequest {
	/**
	 * note the params are used to obtain the actual rows
	 */
	private I_TemplateParams params;
	/**
	 * the count params should not have params like;
	 *  limit, offset, default, exc
	 */
	private I_TemplateParams countParams;
	
	public I_TemplateParams getParams() {
		return params;
	}

	public void setParams(I_TemplateParams params) {
		this.params = params;
	}

	public boolean isCountRows() {
		if (countParams != null) {
			return true;
		}
		return false;
	}

	public I_TemplateParams getCountParams() {
		return countParams;
	}

	public void setCountParams(I_TemplateParams countParams) {
		this.countParams = countParams;
	}
}
