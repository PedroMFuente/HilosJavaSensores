package threads;

import java.util.List;

import DAO.CamaraDAO;
import app.Menu;
import model.Camara;
import utilities.ConectionManager;

public class Lector extends Thread{

	private Menu m;
	public Lector(Menu m) {
		// TODO Auto-generated constructor stub
		this.m=m;
	}

	public synchronized void run(){
		System.out.println("Lectura de las cámaras:");

		List<Camara> list = ConectionManager.getManager().createQuery("FROM Camara").getResultList();

		for (Camara c : list) {
			System.out.println(c.toString());
			try {
				sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("---Fin de lectura---");
		synchronized (m) {
			m.notify();
		}
	}
}
