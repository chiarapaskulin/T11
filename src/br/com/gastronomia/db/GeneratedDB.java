package br.com.gastronomia.db;

import org.hibernate.Session;

public class GeneratedDB {
	public static Session factory;


	public GeneratedDB() {

	}

	public static void createConnection() {
		factory = HibernateUtil.getFactory();

	}

	public static void generatedDB() {
		createConnection();

		factory.getTransaction().begin();
		factory.getTransaction().commit();

		factory.close();

	}
}
