package br.edu.unoesc.jpa.dao;

import java.util.List;

import br.edu.unoesc.jpa.model.SensorLuminosidade;
import br.edu.unoesc.jpa.model.SensorSonar;
import br.edu.unoesc.jpa.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class DaoSensorLuminisodade {

	private EntityManager em;

	public DaoSensorLuminisodade() {
		em = JPAUtil.getEntityManager();
	}

	public void verificaLuminosidade(SensorLuminosidade luz) {
		if (luz.getLux() <= 60 && luz.getLux() >= 50) {
			System.out.println("Abaixa lona" + 
							  "\nDiminui a intensidade da luz interna\n");
		} else if (luz.getLux() <= 20 && luz.getLux() >= 1) {
			System.out.println("Levanta a lona" + 
							   "\nAumenta a intensidade da luz interna\n");
		} else {
			System.out.println("Intensidade da luz normal\n");
		}
	}

	private DaoSensorLuminisodade abrirTransacao() {
		em.getTransaction().begin();
		return this;
	}

	private DaoSensorLuminisodade fecharTransacao() {
		em.getTransaction().commit();
		return this;
	}

	private DaoSensorLuminisodade incluir(SensorLuminosidade sl) {
		em.persist(sl);
		return this;
	}

	public DaoSensorLuminisodade salvar(SensorLuminosidade sl) {
		return this.abrirTransacao()
				.incluir(sl)
				.fecharTransacao();
	}

	public List<SensorLuminosidade> obterTodos() {
		String jpql = "SELECT sl FROM SensorLuminosidade sl";
		return em.createQuery(jpql, SensorLuminosidade.class).getResultList();
	}

	public void fechar() {
		em.close();
	}

}
