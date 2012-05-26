package org.adligo.xml.parsers.template.jpa;

import org.adligo.i.storage.SelectRequest;
import org.adligo.models.params.client.I_TemplateParams;

public class ParamsSelectRequest extends SelectRequest {
	private I_TemplateParams params;
	/**
	 * if true this should actually cause two queries 
	 * one to count the rows the other to get the rows
	 */
	private boolean countRows = false;
	
	public I_TemplateParams getParams() {
		return params;
	}

	public void setParams(I_TemplateParams params) {
		this.params = params;
	}

	public boolean isCountRows() {
		return countRows;
	}

	public void setCountRows(boolean countRows) {
		this.countRows = countRows;
	}
	
}
