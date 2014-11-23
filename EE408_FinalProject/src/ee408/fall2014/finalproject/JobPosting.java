package ee408.fall2014.finalproject;

import java.net.URI;
import java.util.*;

public class JobPosting {
	
	private String companyName;
	private String jobDescription;
	private boolean fullTime;
	private String jobType;//Health care, engineering, etc...
	private Set<String> keywords;
	private String jobURL;
	
	public JobPosting(String companyName, String jobDescription, boolean fullTime, String jobType, Set<String> keys,String URL){
		
		this.companyName = companyName;
		this.jobDescription = jobDescription;
		this.fullTime = fullTime;
		this.jobType = jobType;
		keywords = new HashSet<String>(keys);
		this.jobURL = URL;
	
	}
	public void addKeywords(Set<String> keys){
		this.keywords = keys;
	}
	public HashSet<String> getKeywords(){
		return (HashSet<String>) keywords;
	}
	public String getCompanyName(){
		return this.companyName;
	}
	public String getJobDescription(){
		return this.jobDescription;
	}
	public boolean getFullTime(){
		return this.fullTime;
	}
	public String getJobType(){
		return this.jobType;
	}
	public void setURL(String URL){
		this.jobURL = URL;
	}
	public String getURL(){
		return this.jobURL;
	}
	
	public static void main(String[] args){
		
		ArrayList<JobPosting> jobsList = new ArrayList<JobPosting>();
		String [] companyNames = {"IBM","Birnie Bus","Emerson's Landscaping"};
		String [] jobDescriptions = {"We work on computers","We give people rides","We cut grass"};
		boolean [] jobTimes = {true,true,false};
		String [] jobTypes = {"Engineering", "Business", "Manual Labor"};
		String [] jobURL = {"http://google.com","",""};
		//String []
		ArrayList<Set<String>> keywordList = new ArrayList<Set<String>>();
		
		HashSet<String> IBMKeys = new HashSet<String>();
		IBMKeys.add("computers");
		IBMKeys.add("mainframes");
		IBMKeys.add("coffee");
		HashSet<String> BirnieKeys = new HashSet<String>();
		BirnieKeys.add("busses");
		BirnieKeys.add("transportation");
		BirnieKeys.add("travel");
		HashSet<String> EmersonKeys = new HashSet<String>();
		EmersonKeys.add("trees");
		EmersonKeys.add("grass");
		EmersonKeys.add("lawnmowers");
				
		keywordList.add(IBMKeys);
		keywordList.add(BirnieKeys);
		keywordList.add(EmersonKeys);
		
		for(int i = 0; i<companyNames.length; i++){
			JobPosting jp = new JobPosting(companyNames[i],jobDescriptions[i], jobTimes[i], jobTypes[i], keywordList.get(i),jobURL[i]);
			jobsList.add(jp);
		}
		
		for(int j = 0; j<jobsList.size();j++){
			JobPosting temp = jobsList.get(j);
			System.out.println("**********");
			System.out.println(temp.getCompanyName());
			System.out.println(temp.getJobDescription());
			System.out.println(temp.getFullTime());
			System.out.println(temp.getJobType());
			System.out.print("Company Keywords: ");
			HashSet<String> tempKeys = temp.getKeywords();
			Iterator<String> itr = tempKeys.iterator();
			while(itr.hasNext()){
				System.out.print(itr.next()+" ");
			}
			System.out.println();
		}
	
		
	}
	
	
}
