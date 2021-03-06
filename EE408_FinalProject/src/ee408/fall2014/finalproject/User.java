package ee408.fall2014.finalproject;

import java.util.HashSet;
import java.util.Set;

public class User {

	private String fullName;
	private String areaOfInterest;
	private boolean wantFullTime;
	private Set<String> keywords;
	private String levelOfEducation;
	
	public User() {
		this.fullName = null;
		this.areaOfInterest = null;
		this.wantFullTime = false;
		this.levelOfEducation = null;
		keywords = new HashSet<String>();
	}
	public String getFullName(){
		return fullName;
	}
	public void setFullName(String fn){
		fullName = fn;
	}
	public String getAreaOfInterest(){
		return areaOfInterest;
	}
	public void setAreaOfInterest(String aoi){
		areaOfInterest = aoi;
	}
	public boolean getFullTime(){
		return wantFullTime;
	}
	public void setFullTime(boolean ft){
		wantFullTime = ft;
	}
	public void setLevelOfEducation(String level){
		levelOfEducation = level;
	}
	public String getLevelOfEducation(){
		return levelOfEducation;
	}
	public Set<String> getUserKeywords(){
		return keywords;
	}
	public void setUserKeywords( Set<String> s){
		keywords = s;
	}
	public void addUserKeyword(String w){
		this.keywords.add(w);
	}
	public void printUserInfo(){
		System.out.println();
		System.out.println("**************************USER OBJECT INFORMATION*********************");
		System.out.println("Name: " + fullName);
		System.out.println("AOI: " + areaOfInterest);
		System.out.println("LOE: "  + levelOfEducation);
		System.out.println("ft/pt: " + wantFullTime);
		TextFileParser tfp = new  TextFileParser();
		tfp.printSet(keywords);
		System.out.println("**************************END USER OBJECT INFORMATION******************");
	}
	

}
