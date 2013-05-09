package org.adligo.xml.parsers.template.jpa;

import org.adligo.i.db.I_ReadOnlyConnection;
import org.adligo.xml.parsers.template.jdbc.InjectionSafeEngineInput;


public class JpaReadOnlyEngineInput extends InjectionSafeEngineInput {
	private I_ReadOnlyConnection entityObtainer;
	
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


	public I_ReadOnlyConnection getEntityObtainer() {
		return entityObtainer;
	}

	public void setEntityObtainer(I_ReadOnlyConnection entityObtainer) {
		this.entityObtainer = entityObtainer;
	}
	
	public void clear() {
		entityObtainer = null;
		super.clear();
	}
}
