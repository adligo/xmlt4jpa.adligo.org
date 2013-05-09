package org.adligo.xml.parsers.template.jpa;

import org.adligo.i.adi.client.InvocationException;
import org.adligo.i.adig.client.BaseGInvoker;
import org.adligo.i.adig.client.I_GCheckedInvoker;
import org.adligo.i.db.I_ReadWriteConnection;

/**
 * updates (insert, update or delete statment) the database
 * with a native query or a jpa query 
 * can be wrapped in a transaction or
 * outside of a transaction with the i_storage StorageWrappers
 * @author scott
 *
 */
public class ModifyInvoker extends BaseGInvoker implements I_GCheckedInvoker<JpaModifyEntityRequest, Integer> {

	public ModifyInvoker() {
		super(JpaModifyEntityRequest.class, Integer.class);
	}

	@Override
	public Integer invoke(JpaModifyEntityRequest valueObject)
			throws InvocationException {
		
		I_ReadWriteConnection em = valueObject.getReadWriteConnection();
		JpaReadWriteEngineInput input = valueObject.getEngineInput();
		input.setEntityModifier(em);
		if (valueObject.isUseNativeQuery()) {
			return JpaTemplateParserEngine.executeNativeUpdate(input);
		} else {
			return JpaTemplateParserEngine.executeUpdate(input);
		}
	}
	
	
}
