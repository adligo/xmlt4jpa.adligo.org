package org.adligo.xml.parsers.template.jpa;

import org.adligo.i.storage.ModifyEntityRequest;
import org.adligo.xml.parsers.template.Templates;

public class TemplatesModifyEntityRequest extends ModifyEntityRequest {
	private Templates templates;

	public Templates getTemplates() {
		return templates;
	}

	public void setTemplates(Templates templates) {
		this.templates = templates;
	}
}
