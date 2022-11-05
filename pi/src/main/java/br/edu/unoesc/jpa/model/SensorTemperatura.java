package br.edu.unoesc.jpa.model;

import java.io.Serializable;	
import java.sql.Timestamp;
import java.util.List;

import br.edu.unoesc.jpa.util.JPAUtil;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "sensor_temperatura")
public class SensorTemperatura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer registro;

	@Column(nullable = false)
	private Integer temperatura;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_hora", nullable = false)
	private Timestamp dataHora;

	public SensorTemperatura() {
		super();
	}

	public SensorTemperatura(Integer temperatura, Timestamp dataHora) {
		super();
		this.temperatura = temperatura;
		this.dataHora = dataHora;
	}

	public Integer getRegistro() {
		return registro;
	}

	public void setRegistro(Integer registro) {
		this.registro = registro;
	}

	public Integer getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Integer temperatura) {
		this.temperatura = temperatura;
	}

	public Timestamp getDataHora() {
		return dataHora;
	}

	public void setDataHora(Timestamp dataHora) {
		this.dataHora = dataHora;
	}

	@Override
	public String toString() {
		return "SensorTemperatura [registro=" + registro + ", temperatura=" + temperatura + ", dataHora=" + dataHora
				+ "]";
	}

}
