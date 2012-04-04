package org.adligo.xml.parsers.template.jpa;

import org.adligo.i.adig.client.GRegistry;

public class Xmlt4JpaRegistry {
	private static boolean isSetupUp = false;
	
	public static synchronized void setup() {
		if (!isSetupUp) {
			isSetupUp = true;
			GRegistry.addCheckedInvoker(Xmlt4JpaInvokerNames.MODIFIER, new ModifyInvoker());
		}
	}
}
