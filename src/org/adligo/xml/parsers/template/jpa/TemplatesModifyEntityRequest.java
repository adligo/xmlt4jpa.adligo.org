package org.adligo.xml.parsers.template.jpa;

import org.adligo.i.storage.ModifyRequest;
import org.adligo.xml.parsers.template.Templates;

public class TemplatesModifyEntityRequest extends ModifyRequest {
	private Templates templates;

	public Templates getTemplates() {
		return templates;
	}

	public void setTemplates(Templates templates) {
		this.templates = templates;
	}
}
