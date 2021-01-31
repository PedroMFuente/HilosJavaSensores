package app;

import org.h2.engine.SysProperties;

import DAO.CamaraDAO;
import threads.Arranque;
import threads.Lector;
import threads.NewCamara;
import threads.Saver;
import utilities.utilities;

public class Menu {

	public synchronized void principal() {
		int option = 0;
		utilities u = new utilities();
		Arranque a = new Arranque(this);
		Lector l = new Lector(this);
		NewCamara n = new NewCamara(this);
		Saver s= new Saver();
		s.start(); //manejador de log

		do {
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("1. Simular lectura de dos sensores de la misma cámara de manera simultánea.");
			System.out.println(
					"2. Simular la lectura de un sensor con valor superior a la temperatura máxima y una apertura de puerta simultánea.");
			System.out.println(
					"3. Ingreso de un nueva cámara frigorífica y lectura de los sensores de temperatura de las cámaras restantes.");
			System.out.println("4. Resumen del estado de las cámaras.");
			System.out.println("5. Salir.");

			option = u.readInt();

			switch (option) {
			case 1:
				//Seteo los nuevos valores a la segunda cámara
				CamaraDAO c1 = new CamaraDAO(2);
				c1.setValor1(-34);
				c1.setValor2(-36);
				c1.update();

				a.run(c1);
				break;
			case 2:
				//Seteo los nuevos valores a la primera cámara
				CamaraDAO c2 = new CamaraDAO(1);
				c2.setValor1(-27);
				c2.setValor2(-27);
				c2.setDoor(true);
				c2.update();

				a.run(c2);
				break;
			case 3:
				n.run();
				break;
			case 4:
				l.run();
				break;
			case 5:
				System.out.println("See ya");
				break;
			default:
				System.out.println("Opción inválida");
				break;
			}
		} while (option != 5);
	}
}
