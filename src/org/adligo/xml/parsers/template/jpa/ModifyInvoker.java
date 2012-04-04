package org.adligo.xml.parsers.template.jpa;

import org.adligo.i.adi.client.InvocationException;
import org.adligo.i.adig.client.BaseGInvoker;
import org.adligo.i.adig.client.I_GCheckedInvoker;
import org.adligo.i.storage.I_EntityModifier;

/**
 * updates (insert, update or delete statment) the database
 * with a native query or a jpa query 
 * can be wrapped in a transaction or
 * outside of a transaction with the i_storage StorageWrappers
 * @author scott
 *
 */
public class ModifyInvoker extends BaseGInvoker implements I_GCheckedInvoker<ModifyEntityJpaRequest, Integer> {

	public ModifyInvoker() {
		super(ModifyEntityJpaRequest.class, Integer.class);
	}

	@Override
	public Integer invoke(ModifyEntityJpaRequest valueObject)
			throws InvocationException {
		
		I_EntityModifier em = valueObject.getEntityModifier();
		JpaReadWriteEngineInput input = valueObject.getEngineInput();
		input.setEntityModifier(em);
		if (valueObject.isUseNativeQuery()) {
			return JpaTemplateParserEngine.executeNativeUpdate(input);
		} else {
			return JpaTemplateParserEngine.executeUpdate(input);
		}
	}
	
	
}
