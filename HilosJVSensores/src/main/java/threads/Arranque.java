package threads;

import java.util.List;

import DAO.CamaraDAO;
import app.Menu;
import model.Camara;
import utilities.ConectionManager;

public class Arranque extends Thread{

	Menu m;
	public Arranque(Menu m) {
		// TODO Auto-generated constructor stub
		this.m=m;
	}

	public synchronized void run(CamaraDAO c){
		CamaraDAO aux;

		System.out.println("Valores de cámara número "+c.getId());
		waiths();
		System.out.println("Valor 1: "+c.getValor1()+". Valor 2: "+c.getValor2());
		System.out.println("Estado del motor: "+c.isMotor());
		System.out.println("Estado de la puesta: "+c.isDoor());
		waiths();
		System.out.println("Procesando información: ");

			if(!c.isDoor()){
				if(c.getValor1()>c.getTempmax() || c.getValor2()>c.getTempmax()){
					if(!c.isMotor()){
						System.out.println("Valores insuficientes, encendiendo motor.");
						c.setMotor(true);
						aux = new CamaraDAO(c);
						aux.update();
					}else{
						System.out.println("Motor ya encendido");
					}
				}else{
					if(c.isMotor()){
						System.out.println("Valores suficientes, apagando motor.");
						c.setMotor(false);
						aux = new CamaraDAO(c);
						aux.update();
					}else{
						System.out.println("Todo en orden.");
					}
				}
				waiths();
			}else{
				System.out.println("Puerta abierta, imposible encender motor.");
				c.setMotor(false);
				aux= new CamaraDAO(c);
				aux.update();
			}

			synchronized (m) {
				m.notify();
			}
	}

	public void waiths(){
		try {
			sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
