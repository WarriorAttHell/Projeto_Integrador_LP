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
@Table(name = "sensor_luminosidade")
public class SensorLuminosidade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer registro;

	@Column(name = "luminosidade", nullable = false)
	private Integer lux;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_hora", nullable = false)
	private Timestamp dataHora;

	public SensorLuminosidade() {
		super();
	}

	public SensorLuminosidade(Integer lux, Timestamp dataHora) {
		super();
		this.lux = lux;
		this.dataHora = dataHora;
	}

	public Integer getRegistro() {
		return registro;
	}

	public void setRegistro(Integer registro) {
		this.registro = registro;
	}

	public Integer getLux() {
		return lux;
	}

	public void setLux(Integer lux) {
		this.lux = lux;
	}

	public Timestamp getDataHora() {
		return dataHora;
	}

	public void setDataHora(Timestamp dataHora) {
		this.dataHora = dataHora;
	}

	@Override
	public String toString() {
		return "SensorLuminosidade [registro=" + registro + ", lux=" + lux + ", dataHora=" + dataHora + "]";
	}
	
	
}
