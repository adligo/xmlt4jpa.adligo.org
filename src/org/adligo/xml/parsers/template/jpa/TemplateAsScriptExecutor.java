package org.adligo.xml.parsers.template.jpa;

import java.util.Iterator;

import org.adligo.i.adi.client.InvocationException;
import org.adligo.i.adig.client.BaseGInvoker;
import org.adligo.i.adig.client.I_GCheckedInvoker;
import org.adligo.i.db.I_ReadWriteConnection;
import org.adligo.i.log.client.Log;
import org.adligo.i.log.client.LogFactory;
import org.adligo.models.params.client.Param;
import org.adligo.xml.parsers.template.Template;
import org.adligo.xml.parsers.template.Templates;

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
	private static final Log log = LogFactory.getLog(TemplateAsScriptExecutor.class);
	
	public TemplateAsScriptExecutor() {
		super(TemplatesModifyEntityRequest.class, Boolean.class);
	}

	@Override
	public Boolean invoke(TemplatesModifyEntityRequest valueObject)
			throws InvocationException {

		Templates templates = valueObject.getTemplates();
		I_ReadWriteConnection em = valueObject.getReadWriteConnection();
		
		if (log.isInfoEnabled()) {
			log.info("executing templates " + templates.getName());
		}
		Iterator<String> names = templates.getTemplateNames();
		while (names.hasNext()) {
			String templateName = names.next();
			if (log.isInfoEnabled()) {
				log.info("executing template " + templateName);
			}
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
