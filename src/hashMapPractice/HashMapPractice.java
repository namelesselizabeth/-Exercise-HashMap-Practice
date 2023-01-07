package hashMapPractice;

import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class HashMapPractice {

  // Instantiate a new map : name and counter
  public static Map<String, Integer> pokerPlayer = new HashMap<>();

  public static void main(String[] args) throws IOException, FileNotFoundException {

    extractCSVData("src\\hashMapPractice\\PokerHands.csv");

    // Create an if statement: if the hand is flush then....

    // Print updated list to the console
    printToConsole(pokerPlayer);

    // Update key: "Rita Repulsa" to "Zordon"
    /*
     * When updating a key in a map,we will need to add in a new key, and copy the
     * old number of flushes
     * to the new key. Afterwards remove the old key
     */

    // Print updated list to the console
    System.out.println("\nUpdated List \n---------------");
    printToConsole(pokerPlayer);

    // Update value: increase He man's number of flushes by one
    /*
     * We did this earlier, using the key, get the old value and increase it by one.
     * Save the key and the new value in the map
     */

    // Print updated list to the console
    System.out.println("\nUpdated List \n---------------");
    printToConsole(pokerPlayer);

    // Remove He-Man from the map entirely

    // Print the updated list to the console
    System.out.println("\nUpdated List \n---------------");
    printToConsole(pokerPlayer);
  }

  // Note for later me: what if you make this an array and the map goes LATER,
  // dont use map for the csv
  // do what you did the last exercise and then the map works later! because we
  // need the array to work,
  // or do two maps, we somehow need the dumb hand column WITH the names column
  // hash set maybe???? or a separate player object that includes the hands
  // NO USE THE ARRAY FEATURE ["", "", ""]
  public static Map<String, Integer> extractCSVData(String fileName) throws FileNotFoundException, IOException {

    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new FileReader(fileName));
      String line = null;
      String[] lines = null;
      String headerLine = reader.readLine();

      while ((line = reader.readLine()) != null) {
        lines = line.split(",");
        pokerPlayer.put(lines[0], 0);
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