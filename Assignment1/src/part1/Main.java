package part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner s=new Scanner(new File("test.java"));
		s.useDelimiter("\\s*[;]+\\s*");
		while(s.hasNextLine()) {
			String line =s.next("([\\w\\W]*)");
			parseLine(line);
		}
		s.close();
	}
	
	public static void parseLine(String line) {
		//if it has an equals, get the value, else use null
		int equals=line.lastIndexOf('=');
		String value="null";
		if(equals!=-1) {
			value=line.substring(equals+1).trim();
			line=line.substring(0, equals);
		}
		//scan the line for the last 2 tokens
		Scanner s=new Scanner(line);
		String prev=null;
		String current=null;
		while(s.hasNext()) {
			prev=current;
			current=s.next();
		}
		if(current==null) {
			return;//nothing here
		}else if(prev==null) {
			//this needs to know current scope, which means bracket matching,
			//needs pushdown automata/CFG
			
		}else {
			//if the tokens are identifiers, use 'em
			if(current.matches("[_a-zA-Z]\\w*")&&prev.matches("[_a-zA-Z]\\w*")) {
				System.out.println("Type: "+prev);
				System.out.println("Variable name: "+current);
				System.out.println("Value: "+value);
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			}
		}
		
	}
	
	
		/*
		
Integer i=new Integer(1);
		char a=65;
		k=10;
		double _= 0xA_bad.beep-0_0;
		System.out.println(i);
		
		
	}
*/
}
