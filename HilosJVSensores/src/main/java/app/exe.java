package app;

import java.util.ArrayList;
import java.util.List;

import DAO.CamaraDAO;
import model.Camara;
import threads.Arranque;
import threads.Saver;
import utilities.ConectionManager;

public class exe {

	public static void main(String[] args) {

		Camara c1 = new Camara(1, -30, -25, -26, false, true);
		Camara c2 = new Camara(2, -35, -40, -36, false, false);
		Camara c3 = new Camara(3, -15, 0, 1, true, false);

		ConectionManager.getConection();
		CamaraDAO n1= new CamaraDAO(c1);
		CamaraDAO n2= new CamaraDAO(c2);
		CamaraDAO n3= new CamaraDAO(c3);
		n1.update();
		n2.update();
		n3.update();

		Menu m = new Menu();
		m.principal();

		ConectionManager.CloseAllConection();
	}
}
