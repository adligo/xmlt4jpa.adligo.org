package org.adligo.xml.parsers.template_jpa;

import javax.persistence.EntityManager;

import org.adligo.xml.parsers.template.jdbc.InjectionSafeEngineInput;


public class JpaEngineInput extends InjectionSafeEngineInput {
	private EntityManager entityManager;
	
	protected void validate(Class<?> clz) {
		super.validate(clz);
		if (entityManager == null) {
			throw new NullPointerException(clz.getName() + " needs a "+
					" entityManager, entityModifier or entityObtainer .");
		}
	}
	
	public boolean validate() {
		validate(getClass());
		return true;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager p) {
		entityManager = p;
	}
	
	public void clear() {
		entityManager = null;
		super.clear();
	}
}
