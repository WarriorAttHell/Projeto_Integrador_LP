package br.edu.unoesc.jpa.model;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "sensor_sonar")
public class SensorSonar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer registro;

	@Column(name = "quantidade_racao", nullable = false)
	private Integer metragemRacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_hora", nullable = false)
	private Timestamp dataHora;

	public SensorSonar() {
		super();
	}

	public SensorSonar(Integer metragemRacao, Timestamp dataHora) {
		super();
		this.metragemRacao = metragemRacao;
		this.dataHora = dataHora;
	}

	public Integer getRegistro() {
		return registro;
	}

	public void setRegistro(Integer registro) {
		this.registro = registro;
	}

	public Integer getMetragemRacao() {
		return metragemRacao;
	}

	public void setMetragemRacao(Integer metragemRacao) {
		this.metragemRacao = metragemRacao;
	}

	public Timestamp getDataHora() {
		return dataHora;
	}

	public void setDataHora(Timestamp dataHora) {
		this.dataHora = dataHora;
	}

	@Override
	public String toString() {
		return "SensorSonar [registro=" + registro + ", metragemRacao=" + metragemRacao + ", dataHora=" + dataHora
				+ "]";
	}

}
