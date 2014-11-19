package ee408.fall2014.finalproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class TextFileParser {

	//Set<String> wordSet = new HashSet<String>();
	
	public Set<String> parseTextFile(String inputFile){
		
		try{
			Set<String> wordSet = new HashSet<String>();
			BufferedReader inputReader = new BufferedReader(new FileReader(inputFile));
			String line = inputReader.readLine();
			
			while(line != null){
	            
	            String inputString = line;
	            StringTokenizer tok = new StringTokenizer(inputString, ";,\n\t-: ");
	          
	            while(tok.hasMoreTokens()){
	            	//PREPROCESS THE STRINGS TO BE ALL UPPERCASE
	                String word = tok.nextToken().toUpperCase();
	                wordSet.add(word);
	            
	            }
	           
	            line = inputReader.readLine();
			}
			//printSet(wordSet);
			return wordSet;
		}
		catch (IOException e){
			e.printStackTrace();
			return null;
		}
		
	}
	public void printSet(Set<String> s){
		Iterator<String> itr = s.iterator();
		while(itr.hasNext()){
			String temp = itr.next();
			System.out.println(temp);
		}
	}
	public static void main(String[] args){
		TextFileParser tfp = new TextFileParser();
		tfp.parseTextFile("C:/users/ninka_000/Desktop/fakeResume.txt");
		
	}
}
