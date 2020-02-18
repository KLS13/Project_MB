package com.project.mb.config;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBService {

	// Field
	private static SqlSessionFactory factory = null;
	
	// singleton
	static {
		try {
			String resource = "com/project/mb/config/sqlmap.xml";
			InputStream is = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Method
	public static SqlSessionFactory getFactory() {
		return factory;
	}
	
}