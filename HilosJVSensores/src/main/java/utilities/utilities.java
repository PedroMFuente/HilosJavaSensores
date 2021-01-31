package utilities;

import java.util.Scanner;

public class utilities {

	public int readInt(){
		int n=0;
		Scanner sc = new Scanner(System.in);
		try{
			n=sc.nextInt();
		}catch(Exception e){
			//error
			sc= new Scanner(System.in);
		}

		return n;
	}

	public String readString(){
		Scanner sc= new Scanner(System.in);
		String n= sc.next();
		return n;
	}
}
