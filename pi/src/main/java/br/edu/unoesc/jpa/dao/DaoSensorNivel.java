package br.edu.unoesc.jpa.dao;

import java.util.List;

import br.edu.unoesc.jpa.model.SensorNivel;
import br.edu.unoesc.jpa.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class DaoSensorNivel {
private EntityManager em;
	
	public DaoSensorNivel() {
		em = JPAUtil.getEntityManager();
	}
	
	public void verificaNivel(SensorNivel nivel) {
		if (nivel.getNivelReservatorio() <= 20000 && nivel.getNivelReservatorio() >= 16000) {
			System.out.println("Reservatório cheio!");
		} else if (nivel.getNivelReservatorio() <= 15000 && nivel.getNivelReservatorio() >= 10000) {
			System.out.println("Atenção nível do reservatório com capacidade média!");
		} else if(nivel.getNivelReservatorio() <= 9000 && nivel.getNivelReservatorio() >= 1000){
			System.out.println("Alerta reservatório vazio!");
		}
	}
	
	private DaoSensorNivel abrirTransacao() {
		em.getTransaction().begin();
		return this;
	}
	
	private DaoSensorNivel fecharTransacao() {
		em.getTransaction().commit();
		return this;
	}
	
	private DaoSensorNivel incluir(SensorNivel sn) {
		em.persist(sn);
		return this;
	}
	
	public DaoSensorNivel salvar(SensorNivel sn) {
		return this.abrirTransacao()
				.incluir(sn)
				.fecharTransacao();
	}
	
	public List<SensorNivel> obterTodos(){
		String jpql = "SELECT sn FROM SensorNivel sn";
		return em.createQuery(jpql, SensorNivel.class).getResultList();
	}
	
	public void fechar() {
		em.close();
	}

}
