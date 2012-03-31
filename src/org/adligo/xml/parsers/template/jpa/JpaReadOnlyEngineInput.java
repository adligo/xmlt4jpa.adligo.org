package org.adligo.xml.parsers.template.jpa;

import org.adligo.i.storage.I_EntityObtainer;
import org.adligo.xml.parsers.template.jdbc.InjectionSafeEngineInput;


public class JpaReadOnlyEngineInput extends InjectionSafeEngineInput {
	private I_EntityObtainer entityObtainer;
	
	protected void validate(Class<?> clz) {
		super.validate(clz);
		if (entityObtainer == null ) {
			throw new NullPointerException(clz.getName() + " needs a "+
					"  entityObtainer .");
		}
	}
	
	public boolean validate() {
		validate(getClass());
		return true;
	}


	public I_EntityObtainer getEntityObtainer() {
		return entityObtainer;
	}

	public void setEntityObtainer(I_EntityObtainer entityObtainer) {
		this.entityObtainer = entityObtainer;
	}
	
}
