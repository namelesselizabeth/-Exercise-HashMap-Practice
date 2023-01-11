package hashMapPractice;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class HashMapPractice {

  // Instantiate a new map : name and counter
  public static Map<String, Integer> pokerPlayer = new HashMap<>();
  public static List<String[]> pokerList = new ArrayList<>();

  public static void main(String[] args) throws IOException, FileNotFoundException {

    extractCSVData("src\\hashMapPractice\\PokerHands.csv");

    // Create an if statement: if the hand is flush then....
   
    for (String[] poker : pokerList) {
    	
    	if(poker[1].equals("FLUSH")) {
    		 
    		
    		if (pokerPlayer.containsKey(poker[0])) {
    			
    			pokerPlayer.put(poker[0], pokerPlayer.get(poker[0]) + 1);
    		}
    		
    		else if(!pokerPlayer.containsKey(poker[0])) {
    			pokerPlayer.put(poker[0], 1);
    		}
    	}
    }
    

    // Print list to the console
    System.out.println("List of Players and # of flushes \n---------------");
    printToConsole(pokerPlayer);

    // Update key: "Rita Repulsa" to "Zordon"
   

    // Print updated list to the console
    System.out.println("\nUpdated List \n---------------");
    printToConsole(pokerPlayer);

    // Update value: increase He man's number of flushes by one
 
    
    // Print updated list to the console
    System.out.println("\nUpdated List \n---------------");
    printToConsole(pokerPlayer);

    // Remove He-Man from the map entirely

    // Print the updated list to the console
    System.out.println("\nUpdated List \n---------------");
    printToConsole(pokerPlayer);
  }



public static Map<String, Integer> extractCSVData(String fileName) throws FileNotFoundException, IOException {
  
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new FileReader(fileName));
      String line = null;
      String[] lines = null;
      String headerLine = reader.readLine();
     
      
      while ((line = reader.readLine()) != null) {
        lines = line.split(",");
        pokerList.add(lines);
      }
      
    } finally {
      reader.close();
    }
    return null;
  }

  public static void printToConsole(Map<String, Integer> pokerPlayer) {

    for (Map.Entry<String, Integer> entry : pokerPlayer.entrySet())
      System.out.println(entry.getKey() +
          "-> " + entry.getValue());
  }
  
}