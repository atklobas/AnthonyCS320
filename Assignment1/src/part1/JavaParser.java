package part1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaParser {
	//definitions from https://docs.oracle.com/javase/specs/jls/se8/html/jls-3.html f
	//definitions for integer types
	private String decimal="(0|[1-9][0-9]*|[1-9]_*([0-9]|[0-9]_*[0-9])*)[lL]?";
	private String hex="0[xX]([0-9a-fA-F]|[0-9a-fA-F]_[0-9a-fA-F])*[lL]?";
	private String oct="0([0-7]|[0-7]_[0-7])*[lL]?";
	private String bin="0[bB]([01]|[01]_[01])*[lL]?";
	//definitions for floating point types
	
	//character definitions
	private String string="\"(\\[btnfr\"'\\u]|[^\\\"])* \"";
	//string definitions
	
	//boolean
	private String bool="(true|false)";
	//null
	private String NULL="null";
	
	
	
	private Pattern identifiers;
	//not allowed to use keywords
	//private Pattern keywords;
	private Pattern literals;
	private Pattern separators;
	private Pattern operators;
	public JavaParser() {
		
		Pattern tablePattern=Pattern.compile("<table[^>]*>(.*?)</table>");
		Matcher tableMatcher=tablePattern.matcher(null);
	}

}
