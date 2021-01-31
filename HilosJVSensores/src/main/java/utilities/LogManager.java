package utilities;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import model.Camara;

public class LogManager {
	private String bbdd ="registro.log";

	public void getloged(List<Camara> c){

		BufferedWriter bw = null;
		FileWriter fw =null;
		File file= new File(bbdd);

		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try{
			bw = new BufferedWriter(new FileWriter(file,true));

			for(Camara cam:c){
				bw.newLine();
				bw.write("Número de cámara: "+cam.getId() + " --- Día: "+LocalDate.now()+" --- Hora: "+LocalTime.now());
				bw.newLine();
				bw.write("Temperatura máxima: "+cam.getTempmax());
				bw.newLine();
				bw.write("Valor sensor 1: "+cam.getValor1()+" --- Valor sensor 2: "+cam.getValor2());
				bw.newLine();
				if(cam.isDoor()){
					bw.write("Puerta abierta");
				}else{
					bw.write("Puerta cerrada");
				}
				bw.newLine();
				if(cam.isMotor()){
					bw.write("Motor encendido");
				}else{
					bw.write("Motor apagado");
				}
				bw.newLine();
				bw.write("--------------------------------------------");
			}
		}catch(Exception e){
			//error
		}finally{
			if(bw!=null){
				try{
					bw.close();
				}catch(Exception e){
					//error
				}
			}
		}

	}
}
