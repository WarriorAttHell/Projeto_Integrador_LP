package br.edu.unoesc.jpa.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
	private static final String UNIDADE_PERSISTENCIA = "pi";
	private static final EntityManagerFactory EMF;
	
	static {
		try {
			EMF = Persistence.createEntityManagerFactory(UNIDADE_PERSISTENCIA);
		}catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	private JPAUtil() { }
	
	public static EntityManager getEntityManager() {
		return EMF.createEntityManager();
	}
	
	public static void closeEntityManagerFactory() {
		EMF.close();
	}
}
