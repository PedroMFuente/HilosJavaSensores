package threads;

import java.util.ArrayList;
import java.util.List;

import DAO.CamaraDAO;
import model.Camara;
import utilities.ConectionManager;
import utilities.LogManager;

public class Saver extends Thread{

	public synchronized void run(){
		LogManager l = new LogManager();
		while(true){

			List<Camara> aux = ConectionManager.getManager().createQuery("FROM Camara").getResultList();

			try{

				l.getloged(aux);
				System.out.println("Guardando estado...");
				sleep(30000);

			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
