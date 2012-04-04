package org.adligo.xml.parsers.template.jpa;


public class Xmlt4JpaInvokerNames {
	private static final String PACKAGE = "org.adligo.xml.parsers.template.jpa.";
	/**
	 * a I_GCheckedInvoker<ModifyEntityJpaRequest, Integer>
	 * used to update (insert, update or delete statements) 
	 * a database
	 */
	public static final String MODIFIER = PACKAGE + "modifier";
	/**
	 * same as MODIFIER in a Transaction wrapper
	 */
	public static final String MODIFIER_IN_TRANSACTION = PACKAGE + "modifier_in_transaction";
	private Xmlt4JpaInvokerNames() {}
}
