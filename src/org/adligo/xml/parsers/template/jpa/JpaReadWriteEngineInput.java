package org.adligo.xml.parsers.template.jpa;

import org.adligo.i.storage.I_EntityModifier;
import org.adligo.xml.parsers.template.jdbc.InjectionSafeEngineInput;


public class JpaReadWriteEngineInput extends InjectionSafeEngineInput {
	private I_EntityModifier entityModifier;
	
	protected void validate(Class<?> clz) {
		super.validate(clz);
		if (entityModifier == null) {
			throw new NullPointerException(clz.getName() + " needs a "+
					"  entityModifier .");
		}
	}
	
	public boolean validate() {
		validate(getClass());
		return true;
	}


	public I_EntityModifier getEntityModifier() {
		return entityModifier;
	}

	public void setEntityModifier(I_EntityModifier entityModifier) {
		this.entityModifier = entityModifier;
	}
	
}
