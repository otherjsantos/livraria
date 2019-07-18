package br.com.livraria.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LivrariaEMFactory {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("livraria");

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
