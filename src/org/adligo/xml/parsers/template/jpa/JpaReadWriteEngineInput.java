package org.adligo.xml.parsers.template.jpa;

import org.adligo.i.db.I_ReadWriteConnection;
import org.adligo.xml.parsers.template.jdbc.InjectionSafeEngineInput;


public class JpaReadWriteEngineInput extends InjectionSafeEngineInput {
	private I_ReadWriteConnection entityModifier;
	
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


	public I_ReadWriteConnection getEntityModifier() {
		return entityModifier;
	}

	public void setEntityModifier(I_ReadWriteConnection entityModifier) {
		this.entityModifier = entityModifier;
	}
	
	public void clear() {
		entityModifier = null;
		super.clear();
	}
	
}
