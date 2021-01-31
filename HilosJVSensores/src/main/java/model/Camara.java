package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="CAMARA")
public class Camara implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(name="TEMPMAX")
	int tempmax;
	@Column(name="VALORONE")
	int valor1;
	@Column(name="VALORTWO")
	int valor2;
	@Column(name="DOOR")
	boolean door; //false:cerrada - true:abierta
	@Column(name="MOTOR")
	boolean motor;//false:apagado - true:encendido

	public Camara(){
		this(-1,-1,-1,-1,false,false);
	}

	public Camara(int tempmax, int valor1, int valor2, boolean door, boolean motor){
		this.tempmax = tempmax;
		this.valor1 = valor1;
		this.valor2 = valor2;
		this.door = door;
		this.motor = motor;
	}

	public Camara(int id, int tempmax, int valor1, int valor2, boolean door, boolean motor) {
		this.id = id;
		this.tempmax = tempmax;
		this.valor1 = valor1;
		this.valor2 = valor2;
		this.door = door;
		this.motor = motor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTempmax() {
		return tempmax;
	}

	public void setTempmax(int tempmax) {
		this.tempmax = tempmax;
	}

	public int getValor1() {
		return valor1;
	}

	public void setValor1(int valor1) {
		this.valor1 = valor1;
	}

	public int getValor2() {
		return valor2;
	}

	public void setValor2(int valor2) {
		this.valor2 = valor2;
	}

	public boolean isDoor() {
		return door;
	}

	public void setDoor(boolean door) {
		this.door = door;
	}

	public boolean isMotor() {
		return motor;
	}

	public void setMotor(boolean motor) {
		this.motor = motor;
	}

	@Override
	public String toString() {
		return "Id de la cámara: " + id + "\n Temperatura máxima: " + tempmax + "\n Valor del sensor1: " + valor1 + ", Valor de sensor 2: " + valor2 + "\n Estado de puerta: "
				+ door + "\n Estado de motor: " + motor;
	}

}
