package org.adligo.xml.parsers.template.jpa;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;

import org.adligo.i.adi.client.InvocationException;
import org.adligo.i.adig.client.BaseGInvoker;
import org.adligo.i.adig.client.I_GCheckedInvoker;
import org.adligo.i.storage.I_EntityModifier;
import org.adligo.models.params.client.Param;
import org.adligo.xml.parsers.template.Template;
import org.adligo.xml.parsers.template.Templates;
import org.adligo.xml.parsers.template.jdbc.JdbcEngineInput;
import org.adligo.xml.parsers.template.jdbc.JdbcTemplateParserEngine;

/**
 * this class is a utility
 * to execute a bunch of sql statements from a 
 * templates file in the order of the file (like a script).
 * 
 * Note this is not actually bound to a connection, which would be 
 * done at runtime by the StorageWrappers.
 * 
 * @author scott
 *
 */
public class TemplateAsScriptExecutor extends BaseGInvoker implements I_GCheckedInvoker<TemplatesModifyEntityRequest, Boolean> {

	public TemplateAsScriptExecutor() {
		super(TemplatesModifyEntityRequest.class, Boolean.class);
	}

	@Override
	public Boolean invoke(TemplatesModifyEntityRequest valueObject)
			throws InvocationException {

		Templates templates = valueObject.getTemplates();
		I_EntityModifier em = valueObject.getEntityModifier();
		
		
		Iterator<String> names = templates.getTemplateNames();
		while (names.hasNext()) {
			String templateName = names.next();
			Template temp = templates.getTemplate(templateName);
			
			JpaReadWriteEngineInput values = new JpaReadWriteEngineInput();
			
			values.setParams(new Param());
			values.setEntityModifier(em);
			values.setTemplate(temp);
			JpaTemplateParserEngine.executeNativeUpdate(values);
		}
		return true;
	}
	
	
	

}
