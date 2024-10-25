package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Program {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		Pessoa p = em.find(Pessoa.class, 2);
		System.out.println(p);
		
		em.getTransaction().begin();
		em.remove(p);
		
		
		Pessoa p2 = new Pessoa(null, "Beatriz", "Beatriz@gmail.com");
		em.persist(p2);
		em.getTransaction().commit();
		
		System.out.println("PRONTO");	
		
		em.close();
		emf.close();
	}

}
