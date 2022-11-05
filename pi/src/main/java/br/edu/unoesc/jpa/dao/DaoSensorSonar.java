package br.edu.unoesc.jpa.dao;

import java.util.List;

import br.edu.unoesc.jpa.model.SensorSonar;
import br.edu.unoesc.jpa.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class DaoSensorSonar {
private EntityManager em;
	
	public DaoSensorSonar() {
		em = JPAUtil.getEntityManager();
	}
	
	public void verificaRacao(SensorSonar sonar) {
		if (sonar.getMetragemRacao() >= 80) {
			System.out.println("Silo cheio!");
		} else if (sonar.getMetragemRacao() <= 69 && sonar.getMetragemRacao() >= 45) {
			System.out.println("Atenção Silo em capacidade média!");
		} else {
			System.out.println("Silo vazio!");
		}
	}
	
	private DaoSensorSonar abrirTransacao() {
		em.getTransaction().begin();
		return this;
	}
	
	private DaoSensorSonar fecharTransacao() {
		em.getTransaction().commit();
		return this;
	}
	
	private DaoSensorSonar incluir(SensorSonar ss) {
		em.persist(ss);
		return this;
	}
	
	public DaoSensorSonar salvar(SensorSonar ss) {
		return this.abrirTransacao()
				.incluir(ss)
				.fecharTransacao();
	}
	
	public List<SensorSonar> obterTodos(){
		String jpql = "SELECT ss FROM SensorSonar ss";
		return em.createQuery(jpql, SensorSonar.class).getResultList();
	}
	
	public void fechar() {
		em.close();
	}

}
