package org.adligo.xml.parsers.template.jpa;

import org.adligo.i.adig.client.GRegistry;

public class Xmlt4JpaRegistry {

	public static void setup() {
		GRegistry.addCheckedInvoker(Xmlt4JpaInvokerNames.MODIFIER, new ModifyInvoker());
	}
}
