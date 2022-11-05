package br.edu.unoesc.jpa.app;

import java.time.LocalDateTime;

import br.edu.unoesc.jpa.dao.DaoSensorLuminisodade;
import br.edu.unoesc.jpa.dao.DaoSensorNivel;
import br.edu.unoesc.jpa.dao.DaoSensorSonar;
import br.edu.unoesc.jpa.dao.DaoSensorTemperatura;
import br.edu.unoesc.jpa.model.SensorLuminosidade;
import br.edu.unoesc.jpa.model.SensorNivel;
import br.edu.unoesc.jpa.model.SensorSonar;
import br.edu.unoesc.jpa.model.SensorTemperatura;
import jakarta.persistence.EntityManager;

public class App {
	public static EntityManager em;
	public static SensorTemperatura regst1;
	public static SensorNivel regsn1;
	public static SensorSonar regss1;
	public static SensorLuminosidade regsl1;


	

	public static void main(final String[] args) {

		DaoSensorTemperatura d = new DaoSensorTemperatura();
		DaoSensorNivel e = new DaoSensorNivel();
		DaoSensorSonar f = new DaoSensorSonar();
		DaoSensorLuminisodade g = new DaoSensorLuminisodade();
		
		SensorTemperatura st1 = new SensorTemperatura(22, java.sql.Timestamp.valueOf(LocalDateTime.now()));
		SensorTemperatura st2 = new SensorTemperatura(30, java.sql.Timestamp.valueOf(LocalDateTime.now()));
		SensorTemperatura st3 = new SensorTemperatura(12, java.sql.Timestamp.valueOf(LocalDateTime.now()));
		
		System.out.println(d
				.salvar(st1)
				.salvar(st2)
				.salvar(st3)
				.obterTodos());
		
		for (SensorTemperatura sensor : d.obterTodos()) {
			System.out.println(sensor.getRegistro() + " - " + sensor.getDataHora() + " - " + sensor.getTemperatura());
		}
		d.verificaTempertatura(st1);
		d.verificaTempertatura(st2);
		d.verificaTempertatura(st3);
		
		System.out.println("\n");
		SensorNivel sn1  = new SensorNivel(10000, java.sql.Timestamp.valueOf(LocalDateTime.now()));
		SensorNivel sn2  = new SensorNivel(16000, java.sql.Timestamp.valueOf(LocalDateTime.now()));
		SensorNivel sn3  = new SensorNivel(8000, java.sql.Timestamp.valueOf(LocalDateTime.now()));
		
		System.out.println(e
				.salvar(sn1)
				.salvar(sn2)
				.salvar(sn3)
				.obterTodos());

		for(SensorNivel sensor : e.obterTodos()) {
			System.out.println(sensor.getRegistro() + " - " + sensor.getDataHora() + " - " + sensor.getNivelReservatorio());
		}
		e.verificaNivel(sn1);
		e.verificaNivel(sn2);
		e.verificaNivel(sn3);
		
		System.out.println("\n");
		SensorSonar ss1 = new SensorSonar(45, java.sql.Timestamp.valueOf(LocalDateTime.now()));
		SensorSonar ss2 = new SensorSonar(60, java.sql.Timestamp.valueOf(LocalDateTime.now()));
		SensorSonar ss3 = new SensorSonar(80, java.sql.Timestamp.valueOf(LocalDateTime.now()));
		
		System.out.println(f
				.salvar(ss1)
				.salvar(ss2)
				.salvar(ss3)
				.obterTodos());

		for(SensorSonar sensor : f.obterTodos()) {
			System.out.println(sensor.getRegistro() + " - " + sensor.getDataHora() + " - " + sensor.getMetragemRacao());
		}
		f.verificaRacao(ss1);
		f.verificaRacao(ss2);
		f.verificaRacao(ss3);
		
		System.out.println("\n");
		SensorLuminosidade sl1 = new SensorLuminosidade(25, java.sql.Timestamp.valueOf(LocalDateTime.now()));
		SensorLuminosidade sl2 = new SensorLuminosidade(15, java.sql.Timestamp.valueOf(LocalDateTime.now()));
		SensorLuminosidade sl3 = new SensorLuminosidade(55, java.sql.Timestamp.valueOf(LocalDateTime.now()));

		System.out.println(g
				.salvar(sl1)
				.salvar(sl2)
				.salvar(sl3)
				.obterTodos());
		
		for(SensorLuminosidade sensor : g.obterTodos()) {
			System.out.println(sensor.getRegistro() + " - " + sensor.getDataHora() + " - " + sensor.getLux());
		}
		g.verificaLuminosidade(sl1);
		g.verificaLuminosidade(sl2);
		g.verificaLuminosidade(sl3);

		

	}

}

