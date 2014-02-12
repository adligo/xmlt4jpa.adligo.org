package org.adligo.xml.parsers.template.jpa;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.PersistenceException;

import org.adligo.i.db.I_ParameterContainer;
import org.adligo.i.log.shared.Log;
import org.adligo.i.log.shared.LogFactory;
import org.adligo.models.params.shared.ValueType;
import org.adligo.models.params.shared.ValueTypes;
import org.adligo.xml.parsers.template.jdbc.QueryParameterAggregator;

public class JpaPopulator {
	private static final Log log = LogFactory.getLog(JpaPopulator.class);
	
	public static void setParameters(QueryParameterAggregator agg,I_ParameterContainer query) throws PersistenceException {
		for (int i = 0; i < agg.size(); i++) {
			Object value = agg.getValue(i);
			ValueType vt = agg.getType(i);
			short type = vt.getId();
			try {
				//this switch is probably redundant as JPA queries have the same method name
				// with overloading based on the type, but keeping as is for now 
				// (from copy of xmlt4hibernat)
				switch (type) {
					case ValueTypes.STRING_ID:
						query.setParameter("a" + i, (String) value); 
						break;
					case ValueTypes.INTEGER_ID:
						query.setParameter("a" + i, (Integer) value); 
						break;
					case ValueTypes.DOUBLE_ID:
						query.setParameter("a" + i, (Double) value); 
						break;
					case ValueTypes.LONG_ID:
						query.setParameter("a" + i, (Long) value); 
						break;
					case ValueTypes.SHORT_ID:
						query.setParameter("a" + i, (Short) value); 
						break;
					case ValueTypes.FLOAT_ID:
						query.setParameter("a" + i, (Float) value); 
						break;
					case ValueTypes.DATE_ID:
						query.setParameter("a" + i, new java.sql.Date(((Date) value).getTime())); 
						break;
					case ValueTypes.BOOLEAN_ID:
						query.setParameter("a" + i, (Boolean) value); 
						break;
					case ValueTypes.BIG_DECIMAL_ID:
						query.setParameter("a" + i, new BigDecimal((String) value)); 
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
