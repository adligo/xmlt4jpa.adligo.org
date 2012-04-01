package org.adligo.xml.parsers.template.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.adligo.i.storage.I_EntityModifier;
import org.adligo.i.storage.I_EntityObtainer;
import org.adligo.i.storage.I_ParameterContainer;
import org.adligo.i.storage.I_ReadWriteQuery;
import org.adligo.i.storage.I_ReadWriteTypedQuery;
import org.adligo.i.storage.I_TypedQuery;
import org.adligo.i.storage.ReadOnlyQuery;
import org.adligo.i.storage.ReadWriteTypedQuery;
import org.adligo.xml.parsers.template.TemplateParserEngine;
import org.adligo.xml.parsers.template.jdbc.JdbcParamsDecorator;
import org.adligo.xml.parsers.template.jdbc.QueryParameterAggregator;

public class JpaTemplateParserEngine {

	/**
	 * note this api return the populated query (with filled in question marks)
	 * to parse things like native SQL
	 * @param in
	 * @return
	 */
	public static I_ParameterContainer parseNative(JpaReadOnlyEngineInput in, Class<?> entityClass) {
		 //does a null check for connection, params, and template
		  // allowed operators is a internally managed set (never null)
		  in.validate();
		  validateEntityClass(entityClass);
		  QueryParameterAggregator aggregator = new QueryParameterAggregator();
		  JpaParamsDecorator jdbcParams =	new JpaParamsDecorator(in.getParams(), 
				  in.getAllowedOperators(), aggregator);
		  
		 
		  String queryWithNamedAsNumbersParameters = TemplateParserEngine.parse(in.getTemplate(), jdbcParams);
		  I_ParameterContainer query = null;
		  I_EntityObtainer eo = in.getEntityObtainer();
		  query = eo.createNativeQuery(queryWithNamedAsNumbersParameters, entityClass);
		 
		  JpaPopulator.setParameters(aggregator, query);
		  return query;
	}

	/**
	 * note this api return the populated query (with filled in question marks)
	 * to parse things like native SQL
	 * @param in
	 * @return
	 */
	public static I_ReadWriteQuery parseNative(JpaReadWriteEngineInput in, Class<?> entityClass) {
		 //does a null check for connection, params, and template
		  // allowed operators is a internally managed set (never null)
		  in.validate();
		  validateEntityClass(entityClass);
		  QueryParameterAggregator aggregator = new QueryParameterAggregator();
		  JpaParamsDecorator jdbcParams =	new JpaParamsDecorator(in.getParams(), 
				  in.getAllowedOperators(), aggregator);
		  
		 
		  String queryWithNamedAsNumbersParameters = TemplateParserEngine.parse(in.getTemplate(), jdbcParams);
		  I_ReadWriteQuery query = null;
		  I_EntityModifier em = in.getEntityModifier();
		  query = em.createNativeQuery(queryWithNamedAsNumbersParameters, entityClass);
		 
		  JpaPopulator.setParameters(aggregator, query);
		  return query;
	}
	
	public static void validateEntityClass(Class<?> entityClass) {
		if (entityClass == null) {
				throw new NullPointerException("JpaTemplateParserEngine needs a  entityClass .");
		  }
	}
	
	/**
	 * note this api return the populated query (with filled in question marks)
	 * to parse things like native SQL
	 * @param in
	 * @return
	 */
	public static Query parseNative(JpaEngineInput in, Class<?> entityClass) {
		 //does a null check for connection, params, and template
		  // allowed operators is a internally managed set (never null)
		  in.validate();
		  validateEntityClass(entityClass);
		  QueryParameterAggregator aggregator = new QueryParameterAggregator();
		  JpaParamsDecorator jdbcParams =	new JpaParamsDecorator(in.getParams(), 
				  in.getAllowedOperators(), aggregator);
		  
		  String queryWithNamedAsNumbersParameters = TemplateParserEngine.parse(in.getTemplate(), jdbcParams);
		  
		  EntityManager em = in.getEntityManager();
		  Query query = em.createNativeQuery(queryWithNamedAsNumbersParameters, entityClass);
		  //pass in the wrapper
		  JpaPopulator.setParameters(aggregator, new ReadOnlyQuery(query));
		  return query;
	}
	
	/**
	 * note this api return the populated query (with filled in named parameters
	 * named like :1, :2, :3 exc)
	 * to parse things like JPQL
	 * @param in
	 * @return
	 */
	public static <X> I_TypedQuery<X> parseJPQL(JpaReadOnlyEngineInput in, Class<X> entityClass) {
		 //does a null check for connection, params, and template
		  // allowed operators is a internally managed set (never null)
		  in.validate();
		  QueryParameterAggregator aggregator = new QueryParameterAggregator();
		  JpaParamsDecorator jdbcParams =	new JpaParamsDecorator(in.getParams(), 
				  in.getAllowedOperators(), aggregator);
		  
		 
		  String queryWithNamedAsNumbersParameters = TemplateParserEngine.parse(in.getTemplate(), jdbcParams);
		  
		  I_EntityObtainer eo = in.getEntityObtainer();
		  I_TypedQuery<X> query =  eo.createQuery(queryWithNamedAsNumbersParameters, entityClass);
		  JpaPopulator.setParameters(aggregator, query);
		  return query;
	}
	
	
	/**
	 * note this api return the populated query (with filled in named parameters
	 * named like :1, :2, :3 exc)
	 * to parse things like JPQL
	 * @param in
	 * @return
	 */
	public static <X> I_ReadWriteTypedQuery<X> parseJPQL(JpaReadWriteEngineInput in, Class<X> entityClass) {
		 //does a null check for connection, params, and template
		  // allowed operators is a internally managed set (never null)
		  in.validate();
		  QueryParameterAggregator aggregator = new QueryParameterAggregator();
		  JpaParamsDecorator jdbcParams =	new JpaParamsDecorator(in.getParams(), 
				  in.getAllowedOperators(), aggregator);
		  
		 
		  String queryWithNamedAsNumbersParameters = TemplateParserEngine.parse(in.getTemplate(), jdbcParams);
		  
		  I_EntityModifier em = in.getEntityModifier();
		  I_ReadWriteTypedQuery<X> query =  em.createQuery(queryWithNamedAsNumbersParameters, entityClass);
		  JpaPopulator.setParameters(aggregator, query);
		  return query;
	}
	
	/**
	 * note this api return the populated query (with filled in named parameters
	 * named like :1, :2, :3 exc)
	 * to parse things like JPQL
	 * @param in
	 * @return
	 */
	public static <X> TypedQuery<X> parseJPQL(JpaEngineInput in, Class<X> entityClass) {
		 //does a null check for connection, params, and template
		  // allowed operators is a internally managed set (never null)
		in.validate();
		  QueryParameterAggregator aggregator = new QueryParameterAggregator();
		  JpaParamsDecorator jdbcParams =	new JpaParamsDecorator(in.getParams(), 
				  in.getAllowedOperators(), aggregator);
		  
		  String queryWithNamedAsNumbersParameters = TemplateParserEngine.parse(in.getTemplate(), jdbcParams);
		  
		  EntityManager em = in.getEntityManager();
		  TypedQuery<X> query =  em.createQuery(queryWithNamedAsNumbersParameters, entityClass);
		  JpaPopulator.setParameters(aggregator, new ReadWriteTypedQuery<X>(query));
		  return query;
	}
}
