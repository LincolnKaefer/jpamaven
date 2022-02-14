package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {
	
	public static void main(String[] args) {
		
		
		//POVOANDO O BD
		/* 
		Pessoa p1 = new Pessoa(null, "Carlos da Silva","carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Jose da Silva","jose@gmail.com");
		Pessoa p3 = new Pessoa(null, "Maria da Silva","maria@gmail.com");
		*/
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		//JOGANDO OS OBJETOS PESSOA NO BD
		/*
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		*/
		
		Pessoa p = em.find(Pessoa.class, 2); //PESQUISANDO POR ID NO BD
		System.out.println(p);
		
		// EXCLUINDO NO BD - ALERTA!!! - SEMPRE QUE UMA OPERACAO NÃO SEJA UMA SIMPLES CONSULTA DEVE SE INICIAR UMA TRASACÃO
		/* Para excluir o objeto deve estar monitorado, ou seja que tenha uma sido trazido por uma consulta e o entitymanager
		 * não tenha sido fechado, caso contrario náo irá excluir
		 */
		em.getTransaction().begin();		
		em.remove(p);
		em.getTransaction().commit();
		
		System.out.println("Pronto");
		em.close();
		emf.close();
		
		
	
	}

}
