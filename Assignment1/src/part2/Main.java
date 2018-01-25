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
	public static final boolean testing=false;
	public static void main(String[] args) throws IOException {
		Scanner console=new Scanner(System.in);
		System.out.print("Enter quarter: ");
		
		String quarter=testing?"Winter":console.nextLine();
		System.out.print("Enter Year: ");
		String year=testing?"2018":console.nextLine();
		System.out.print("Enter the initial for the program: ");
		String initial=testing?"C":console.nextLine().toUpperCase();

		URL url=new URL("https://www.bellevuecollege.edu/classes/"+quarter+year+"/");
		Scanner s=testing?null:new Scanner(new BufferedReader(new InputStreamReader(url.openStream())));
		String buffer="";
		while(!testing&&s.hasNextLine()) {
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
		
		System.out.println();
		System.out.print("Enter the program's name: ");
		String program=testing?"Computer Science":console.nextLine();
		System.out.print("Enter the course ID: ");
		String cid=testing?"CS 351": console.nextLine();
		
		String abb=cid.substring(0, cid.indexOf(' '));
		System.out.println();
		url=new URL("https://www.bellevuecollege.edu/classes/"+quarter+year+"/"+abb);
		s=new Scanner(new BufferedReader(new InputStreamReader(url.openStream())));
		buffer="";
		while(s.hasNextLine()) {
			buffer+=s.nextLine();
		}
		
		String regex="<span class=\\\"courseID\\\">([^<]*"+cid+"[^<]*)</span>[\\s\\S].*?<span class=\\\"courseTitle\\\">([^<]*)</span>[\\s\\S]*?<!-- SEARCHTERM:  -->([\\s\\S]*?)(<!-- classHeading -->|<!-- content -->)";
		
		Pattern items=Pattern.compile(regex);
		Matcher itemsm=items.matcher(buffer);
		System.out.println(program+" Courses in "+quarter+" "+year);
		System.out.println("==================================");
		if(itemsm.find()) {
			Pattern details=Pattern.compile("number: <\\/span>([0-9]*)[\\s\\S]*?<li class=\\\"instructor\\\">[\\s\\S]*?<a[^>]*>([\\sa-zA-Z]*)[\\s\\S]*?<ul class=\\\"meets\\\">([\\s\\S]*?)</ul>");
			
			Matcher detailsm=details.matcher(itemsm.group(3));

			while(detailsm.find()) {
				
				System.out.println("Code: "+cid);
				System.out.println("Item#: "+detailsm.group(1));
				System.out.println("Title: "+itemsm.group(2));
				System.out.println("Instructor: "+detailsm.group(2));
				String rawDays=detailsm.group(3);
				Pattern days=Pattern.compile("[\\s\\S]*?(title=\\\"([^\\\"]*)|(Online))");
				Matcher daysm=days.matcher(rawDays);
				while(daysm.find()) {
					System.out.println("Days: "+(daysm.group(2)==null?"Online":daysm.group(2)));
				}
				System.out.println("==================================");
			}
			
		}else {
			System.err.println("that course was not found!");
		}
		System.out.println();
	}

}
