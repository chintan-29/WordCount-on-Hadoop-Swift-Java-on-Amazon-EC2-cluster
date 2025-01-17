package wc_mul;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class wc_mul {
  
private static ArrayList<String> list = new ArrayList<String>();
private static TreeMap<String, Integer> frc = new TreeMap<String, Integer>( );
	
public static void main(String args[]) {

    int threads1 = Integer.parseInt(args[0]);
    
    th[] threads = new th[threads1];
      
    long start1 = System.currentTimeMillis();
    System.out.println(start1);

    for(int i = 0 ; i < threads1 ; i++) 
         {
         threads[i] = new th();
         }
    try{
         for(int i = 0 ; i < threads1 ; i++) {
         threads[i].join();
         }
       printAllCounts(frc);
         }
    catch(Exception e)
       {
         System.out.println("this is not done!!!!");
        }
      
    long end = System.currentTimeMillis();
    System.out.println(end);

    long time = (end - start1)/1000;
    System.out.println("Running Time in seconds : " + time);
}
public static void printAllCounts(TreeMap<String, Integer> frc) throws IOException
 {
	
    FileWriter out = new FileWriter("out.txt");
	BufferedWriter ot = new BufferedWriter(out);
    for(String word : frc.keySet( ))
    {
      ot.write(word);
      System.out.print(word+" "); 
      ot.write(frc.get(word));
      System.out.println(frc.get(word));
    }

    
 }   
 public static void readfile(TreeMap<String, Integer> frc)
 {
	Scanner file = null;
	String word;
    int count;	
	
    try {
		file=new Scanner(new FileReader("/home/akash/wiki10gb"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 

    while (file.hasNext( ))
    {
          word = file.next( );
  // System.out.print(word);
          count = count(word, frc) + 1;
        frc.put(word, count);
    }
	 
 }
  
 public static int count(String word,TreeMap<String,Integer> frc)
 {
	 
	 if (frc.containsKey(word))
     {  
	   return frc.get(word); 
     }
     else
     { 
        return 0;
     }
	 
	 
	 
	 
 }	


class th extends Thread {
  
  public int i,j,k;
  th(){
    //this.i=i;
    start();
  }
  public void run() {  
    while(j<i)
    {
      readfile(frc);
    } 
  }
}}

