package org.adligo.xml.parsers.template.jpa;

import org.adligo.i.adig.client.GRegistry;
import org.adligo.i.db.DbMethodWrappers;

public class Xmlt4JpaRegistry {
	private static boolean isSetupUp = false;
	
	@SuppressWarnings("unchecked")
	public static synchronized void setup() {
		if (!isSetupUp) {
			isSetupUp = true;
			GRegistry.addCheckedInvoker(Xmlt4JpaInvokerNames.MODIFIER, new ModifyInvoker());
			GRegistry.addCheckedInvoker(Xmlt4JpaInvokerNames.MODIFIER_IN_TRANSACTION, 
					DbMethodWrappers.createTransactionWrapper(new ModifyInvoker()));
		}
	}
}
