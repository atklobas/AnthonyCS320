package part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner console=new Scanner(System.in);
		System.out.print("Enter quarter: ");
		String quarter=console.nextLine();
		System.out.print("Enter Year: ");
		String year= console.nextLine();
		System.out.print("Enter the initial for the program: ");
		String initial=console.nextLine();
		
		URL url=new URL("https://www.bellevuecollege.edu/classes/"+quarter+year+"/");
		Scanner s=new Scanner(new BufferedReader(new InputStreamReader(url.openStream())));
		String buffer="";
		//BufferedReader reader=new BufferedReader(new FileReader("table.html"));
		while(s.hasNextLine()) {
			buffer+=s.nextLine();
		}
		URLDecoder decoder=new URLDecoder();
		Pattern list=Pattern.compile("<li class=\\\"subject-name\\\">[\\s\\S]*?/"+initial+".*?\">(.*?)</a>[\\s\\S]*?\\(("+initial+".*?)\\)[\\s\\S]*?</li>");
		Matcher listm=list.matcher(buffer);
		
		System.out.println();
		System.out.println("Programs:");
		while(listm.find()) {
			String fullName=listm.group(1);
			
			String codes=listm.group(2).replaceAll("&amp;", "&");
			
			System.out.println(fullName+" ("+codes+")");
			
		}
		
		 
		System.out.print("Enter the program's name: ");
		String program=console.nextLine();
		System.out.print("Enter ID: ");
		String cid= console.nextLine();
		String abb=cid.substring(0, cid.indexOf(' '));
		System.out.println();
		
		
		
		
		
		url=new URL("https://www.bellevuecollege.edu/classes/"+quarter+year+"/"+abb);
		s=new Scanner(new BufferedReader(new InputStreamReader(url.openStream())));
		buffer="";
		//BufferedReader reader=new BufferedReader(new FileReader("table.html"));
		while(s.hasNextLine()) {
			buffer+=s.nextLine();
		}
		
		String regex="<li class=\\\"classDetailsLink\\\">[\\s]*<a [^>]*>.*?View "+cid+"[\\s\\S]*?<!-- SEARCHTERM:  -->([\\s\\S]*?)(<!-- classHeading -->|<!-- content -->)";
		Pattern items=Pattern.compile(regex);
		Matcher itemsm=items.matcher(buffer);
		if(itemsm.find()) {
			Pattern details=Pattern.compile("number: <\\/span>([0-9]*)[\\s\\S]*?<li class=\\\"instructor\\\">[\\s\\S]*?<a[^>]*>([\\sa-zA-Z]*)[\\s\\S]*?(<abbr[^>]*>([\\sa-zA-Z]*)<\\/abbr>|<span class=\\\"days online\\\">([\\sa-zA-Z]*))");
			Matcher detailsm=details.matcher(itemsm.group(1));

			while(detailsm.find()) {
				System.out.println(detailsm.group(1));
			}
			
			
			
			
		}else {
			System.err.println("that course was not found!");
		}
		
		
		
		
		System.out.println();
		
	}

}
