package ee408.fall2014.finalproject;

//import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Scoring {

	public int produceScore( User u , JobPosting jp ){
		
		int totalScore = 0;
		
		if(u.getFullTime() == jp.getFullTime()) 
			totalScore++;
		if(u.getAreaOfInterest().equals(jp.getJobType()))
			totalScore++;
		Set<String> userSet = u.getUserKeywords();
		Set<String> jobSet = jp.getKeywords();
		
		
		    for(String userKey : userSet){
		        for(String jobKey : jobSet){
		        	
		        	//Pre-process the strings
		        	userKey = userKey.toUpperCase();
		        	jobKey = jobKey.toUpperCase();
		        	
		            if(userKey.equals(jobKey)){
		            	totalScore++;
		            	System.out.println("Keyword Match: " + userKey);
		            }
		        }
		    }
	
		
		return totalScore;
	}
	
//*****************************
	/**
	 * This method returns the job postings in order of best matching.  The first JobPosting in the list (at index zero), 
	 * is the best match, and the last in the list is the worst match
	 * @param u User object
	 * @param jobsList Array list of JobPosting objects
	 * @return sorted array list of matching jobs
	 */
	public ArrayList<JobPosting> findBestMatches(User u, ArrayList<JobPosting> jobsList){
		
		ArrayList<JobPosting> matchingFieldsList = new ArrayList<JobPosting>();//This stores the jobPostings that have the users desired job field
		
		//Picks out the job postings that are in the area of interest of the user
		System.out.println("Companies in the users desired field");
		for(int i = 0; i<jobsList.size(); i++){
			
			JobPosting tempJob = jobsList.get(i);
			String jobField = tempJob.getJobType().toUpperCase();
			String usrField = u.getAreaOfInterest().toUpperCase();
			
			if(jobField.equals(usrField)){
				matchingFieldsList.add(jobsList.get(i));
				System.out.println(jobsList.get(i).getCompanyName());
			}
		}
		
		int size = matchingFieldsList.size();
		int[] scoreArr = new int[size];
		System.out.println("Scoring: ");
		for(int i = 0; i<size; i++){
			int tempScore = produceScore( u , matchingFieldsList.get(i) );
			scoreArr[i] = tempScore;
			System.out.println(matchingFieldsList.get(i).getCompanyName() + ":  " + tempScore);
		}
		
		
		//Bubble sort
		 int j;
	     boolean flag = true;   // set flag to true to begin first pass
	     int temp;   //holding variable
	     
	     while ( flag )
	     {
	            flag= false;    //set flag to false awaiting a possible swap
	            for( j=0;  j < scoreArr.length -1;  j++ )
	            {
	                   if ( scoreArr[ j ] < scoreArr[j+1] )   // change to > for ascending sort
	                   {
	                           temp = scoreArr[ j ];                //swap element
	                           scoreArr[ j ] = scoreArr[ j+1 ];
	                           scoreArr[ j+1 ] = temp;
	                           
	                           Collections.swap(matchingFieldsList, j, j+1);
	                           
	                          flag = true;              //shows a swap occurred  
	                  } 
	            } 
	      }  
	    System.out.println("Final list of companies in sorted order: ");
		for(int i = 0; i<matchingFieldsList.size(); i++){
			System.out.println(matchingFieldsList.get(i).getCompanyName());
		}
	     
		return matchingFieldsList;
	}
	
	
}
