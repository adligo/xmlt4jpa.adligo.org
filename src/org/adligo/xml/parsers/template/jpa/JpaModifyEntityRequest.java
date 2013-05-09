package org.adligo.xml.parsers.template.jpa;

import java.util.Set;

import org.adligo.i.db.ModifyRequest;
import org.adligo.models.params.client.I_Operators;
import org.adligo.models.params.client.I_TemplateParams;
import org.adligo.xml.parsers.template.Template;

public class JpaModifyEntityRequest extends ModifyRequest {
	private JpaReadWriteEngineInput engineInput = new JpaReadWriteEngineInput();
	private boolean useNativeQuery = true;
	
	public Template getTemplate() {
		return engineInput.getTemplate();
	}

	public void setTemplate(Template template) {
		engineInput.setTemplate(template);
	}

	public I_TemplateParams getParams() {
		return engineInput.getParams();
	}

	public void setParams(I_TemplateParams params) {
		engineInput.setParams(params);
	}

	public Set<I_Operators> getAllowedOperators() {
		return engineInput.getAllowedOperators();
	}

	public void setAllowedOperators(Set<I_Operators> p) {
		engineInput.setAllowedOperators(p);
	}

	public boolean isUseNativeQuery() {
		return useNativeQuery;
	}

	public void setUseNativeQuery(boolean useNativeQuery) {
		this.useNativeQuery = useNativeQuery;
	}

	public JpaReadWriteEngineInput getEngineInput() {
		return engineInput;
	}


}
