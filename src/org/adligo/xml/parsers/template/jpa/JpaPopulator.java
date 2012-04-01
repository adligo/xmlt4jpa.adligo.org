package org.adligo.xml.parsers.template.jpa;

import java.util.Date;

import javax.persistence.PersistenceException;

import org.adligo.i.log.client.Log;
import org.adligo.i.log.client.LogFactory;
import org.adligo.i.storage.I_ParameterContainer;
import org.adligo.models.params.client.ValueTypes;
import org.adligo.xml.parsers.template.jdbc.QueryParameterAggregator;

public class JpaPopulator {
	private static final Log log = LogFactory.getLog(JpaPopulator.class);
	
	public static void setParameters(QueryParameterAggregator agg,I_ParameterContainer query) throws PersistenceException {
		for (int i = 0; i < agg.size(); i++) {
			Object value = agg.getValue(i);
			short type = (Short) agg.getType(i);
			try {
				//this switch is probably redundant as JPA queries have the same method name
				// with overloading based on the type, but keeping as is for now 
				// (from copy of xmlt4hibernat)
				switch (type) {
					case ValueTypes.STRING:
						query.setParameter("a" + i, (String) value); 
						break;
					case ValueTypes.INTEGER:
						query.setParameter("a" + i, (Integer) value); 
						break;
					case ValueTypes.DOUBLE:
						query.setParameter("a" + i, (Double) value); 
						break;
					case ValueTypes.LONG:
						query.setParameter("a" + i, (Long) value); 
						break;
					case ValueTypes.SHORT:
						query.setParameter("a" + i, (Short) value); 
						break;
					case ValueTypes.FLOAT:
						query.setParameter("a" + i, (Float) value); 
						break;
					case ValueTypes.DATE:
						query.setParameter("a" + i, new java.sql.Date(((Date) value).getTime())); 
						break;
					case ValueTypes.BOOLEAN:
						query.setParameter("a" + i, (Boolean) value); 
						break;
					default:
						throw new PersistenceException("Unknown type " + type +
								" for paramter " + i + " value = " + value);
				}
			} catch (PersistenceException ex) {
				log.error("SQLException setting paramter " + i + " a " +
						type + " with content " + value);
				throw ex;
			}
		}
	}
}
