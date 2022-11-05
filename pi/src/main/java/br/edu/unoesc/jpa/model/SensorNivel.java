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
@Table(name = "sensor_nivel")
public class SensorNivel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer registro;

	@Column(name = "nivel_reservatorio", nullable = false, precision = 12, scale = 2)
	private Integer nivelReservatorio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_hora", nullable = false)
	private Timestamp dataHora;


	public SensorNivel() {
		super();
	}

	public SensorNivel(Integer nivelReservatorio, Timestamp dataHora) {
		super();
		this.nivelReservatorio = nivelReservatorio;
		this.dataHora = dataHora;
	}
	
	public Integer getRegistro() {
		return registro;
	}

	public void setRegistro(Integer registro) {
		this.registro = registro;
	}

	public Integer getNivelReservatorio() {
		return nivelReservatorio;
	}

	public void setNivelReservatorio(Integer nivelReservatorio) {
		this.nivelReservatorio = nivelReservatorio;
	}

	public Timestamp getDataHora() {
		return dataHora;
	}

	public void setDataHora(Timestamp dataHora) {
		this.dataHora = dataHora;
	}


	@Override
	public String toString() {
		return "SensorNivel [registro=" + registro + ", nivelReservatorio=" + nivelReservatorio + ", dataHora="
				+ dataHora + "]";
	}
	
	

}
