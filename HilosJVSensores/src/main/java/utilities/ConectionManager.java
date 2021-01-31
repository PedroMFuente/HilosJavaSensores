package utilities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConectionManager {
	private static EntityManagerFactory emf=null;
	private static EntityManager manager=null;

	public static EntityManager getManager(){
		if(manager==null){
			getConection();
			try{
				manager=emf.createEntityManager();
			}catch (Exception e) {
				// TODO: handle exception
			}

		}
		return manager;
	}

	public static  void getConection(){
		if(emf==null){
			try{
				//emf=Persistence.createEntityManagerFactory("jdbc:h2:");
				emf=Persistence.createEntityManagerFactory("H2");
			}catch (Exception e) {
					System.out.println(e);
			}
		}
	}

	private static void CloseEntityManagerFactory(){
		if(emf!=null){
			emf.close();
			emf=null;
		}
	}

	public static void CloseEntityManager(){
		if(manager!=null){
			manager.close();
			manager=null;
		}
	}

	public static void CloseAllConection(){
		CloseEntityManagerFactory();
		CloseEntityManager();
	}
}
