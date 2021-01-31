package DAO;

import model.Camara;
import utilities.ConectionManager;

public class CamaraDAO extends Camara{

	public CamaraDAO(int id, int tempmax, int valor1, int valor2, boolean door, boolean motor) {
		super(id, tempmax, valor1, valor2, door, motor);
		// TODO Auto-generated constructor stub
	}

	public CamaraDAO(Camara c){
		this.setId(c.getId());
		this.setTempmax(c.getTempmax());
		this.setValor1(c.getValor1());
		this.setValor2(c.getValor2());
		this.setDoor(c.isDoor());
		this.setMotor(c.isMotor());
	}

	public CamaraDAO(int id){
		Camara c = null;
		ConectionManager.getManager().getTransaction().begin();
		try{
			c=ConectionManager.getManager().find(Camara.class, id);
		}catch(Exception e){
			//error
			System.out.println(e);
		}
		ConectionManager.getManager().getTransaction().commit();
		ConectionManager.CloseEntityManager();
		if(c!=null){
			this.setId(id);
			this.setTempmax(c.getTempmax());
			this.setValor1(c.getValor1());
			this.setValor2(c.getValor2());
			this.setDoor(c.isDoor());
			this.setMotor(c.isMotor());
		}
	}

	public int update(){
		int result=-1;

		Camara c = new Camara(this.getId(),this.getTempmax(),this.getValor1(),this.getValor2(),this.isDoor(),this.isMotor());
		ConectionManager.getManager().getTransaction().begin();
		if(c.getId()>0){
			try{
				ConectionManager.getManager().merge(c);
				result=1;
			}catch(Exception e){
				//error
			}
		}else{
			try{
				ConectionManager.getManager().persist(c);
				ConectionManager.getManager().flush();
				this.setId(c.getId());
				result=1;
			}catch (Exception e) {
				// TODO: handle exception
			}
		}

		ConectionManager.getManager().getTransaction().commit();
		ConectionManager.CloseEntityManager();
		return result;
	}

	public int delete(){
		int result=-1;

		Camara c = new Camara(this.getId(),this.getTempmax(),this.getValor1(),this.getValor2(),this.isDoor(),this.isMotor());
		if(c.getId()>0){
			ConectionManager.getManager().getTransaction().begin();
			try {
				ConectionManager.getManager().remove(ConectionManager.getManager().contains(c) ? c : ConectionManager.getManager().merge(c));
				result = 1;
			} catch (Exception e) {
				// TODO: handle exception
			}
			ConectionManager.getManager().getTransaction().commit();
			ConectionManager.CloseEntityManager();
		}

		return result;
	}
}
