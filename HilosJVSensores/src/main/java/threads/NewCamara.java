package threads;

import DAO.CamaraDAO;
import app.Menu;

public class NewCamara extends Thread{

	Menu m;
	public NewCamara(Menu m) {
		// TODO Auto-generated constructor stub
		this.m=m;
	}
	public synchronized void run(){
		Arranque a = new Arranque(m);
		CamaraDAO nc = new CamaraDAO(4,-15,20,18,false,false);

		System.out.println("Instalación de la nueva cámara.");
		nc.update();
		waiths();
		System.out.println("Datos de la nueva cámara:\n"+nc.toString());

		//Modificar sensores camara 1
		System.out.println("--------");
		a.run(new CamaraDAO(1));
		System.out.println("--------");
		a.run(nc);

		synchronized (m) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
