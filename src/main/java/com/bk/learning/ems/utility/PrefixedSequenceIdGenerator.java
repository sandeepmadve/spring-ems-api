/**
 * 
 */
package com.bk.learning.ems.utility;

import java.io.Serializable;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

/**
 * @author Saideep
 *
 */
public class PrefixedSequenceIdGenerator extends SequenceStyleGenerator {
	
	public static final String PREFIX_VALUE_PARAMETER = "prefixValue";
	public static final String PREFIX_VALUE_DEFAULT = "";
	private String prefixValue;
	
	public static final String NUMBER_FORMAT_PARAMETER = "numberFormat";
	public static final String NUMBER_FORMAT_DEFAULT = "%d";
	private String numberFormat;
	
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		return prefixValue + String.format(numberFormat, super.generate(session, object));
	}
	
	@Override
	public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
		super.configure(type, params, serviceRegistry);
		prefixValue = ConfigurationHelper.getString(PREFIX_VALUE_PARAMETER, params, PREFIX_VALUE_DEFAULT);
		numberFormat = ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER, params, NUMBER_FORMAT_DEFAULT);
	}

}
