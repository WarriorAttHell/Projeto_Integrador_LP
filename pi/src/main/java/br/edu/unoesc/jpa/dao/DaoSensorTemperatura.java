package br.edu.unoesc.jpa.dao;

import java.util.List;

import br.edu.unoesc.jpa.model.SensorTemperatura;
import br.edu.unoesc.jpa.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class DaoSensorTemperatura {
	private EntityManager em;
	
	public DaoSensorTemperatura() {
		em = JPAUtil.getEntityManager();
	}
	
	public void verificaTempertatura(SensorTemperatura temp) {
		if (temp.getTemperatura() < 19) {
			System.out.println("Ligando aquecedores!");
		} else if (temp.getTemperatura() > 23) {
			System.out.println("Desliganado aquecedores!");
		} else {
			System.out.println("Temperatura normal!");
		}
	}
	
	private DaoSensorTemperatura abrirTransacao() {
		em.getTransaction().begin();
		return this;
	}
	
	private DaoSensorTemperatura fecharTransacao() {
		em.getTransaction().commit();
		return this;
	}
	
	private DaoSensorTemperatura incluir(SensorTemperatura st) {
		em.persist(st);
		return this;
	}
	
	public DaoSensorTemperatura salvar(SensorTemperatura st) {
		return this.abrirTransacao()
				.incluir(st)
				.fecharTransacao();
	}
	
	public List<SensorTemperatura> obterTodos(){
		String jpql = "SELECT st FROM SensorTemperatura st";
		return em.createQuery(jpql, SensorTemperatura.class).getResultList();
	}
	
	public void fechar() {
		em.close();
	}

}
