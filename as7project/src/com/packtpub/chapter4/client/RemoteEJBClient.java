package com.packtpub.chapter4.client;

import javax.naming.*;
import java.security.Security;
import java.util.*;

import org.jboss.sasl.JBossSaslProvider;

import com.packtpub.chapter4.ejb.SingletonBeanRemote;
import com.packtpub.chapter4.ejb.SingletonBeanRemoteImpl;
import com.packtpub.chapter4.entity.Property;

public class RemoteEJBClient {
	static {
		Security.addProvider(new JBossSaslProvider());
	}

	public static void main(String[] args) throws Exception {
		testRemoteEJB();

	}

	private static void testRemoteEJB() throws NamingException {

		final SingletonBeanRemote ejb = lookupEJB();
		ejb.put("entry", "value");
		List<Property> list = ejb.getCache();
		System.out.println(list);
	}

	private static SingletonBeanRemote lookupEJB()
			throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.URL_PKG_PREFIXES,
				"org.jboss.ejb.client.naming");
		final Context context = new InitialContext(jndiProperties);
		final String appName = "";
		final String moduleName = "as7project";
		final String distinctName = "";

		final String beanName = SingletonBeanRemoteImpl.class.getSimpleName();

		final String viewClassName = SingletonBeanRemote.class.getName();

		return (SingletonBeanRemote) context.lookup("ejb:" + appName + "/"
				+ moduleName + "/" + distinctName + "/" + beanName + "!"
				+ viewClassName);
	}
}
