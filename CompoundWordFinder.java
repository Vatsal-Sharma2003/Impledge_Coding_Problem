// Impledge clg Problem Statement solution..
import java.io.*;
import java.util.*;  

public class CompoundWordFinder {


    // Part 1:- This is a Helper function to check if a word can be formed by concatenating shorter words or not.
    private static boolean isCompoundWordOrNot(String word, Set<String> dictionary, Map<String, Boolean> memo) {
        if (memo.containsKey(word)) {
            return memo.get(word);
        }

        // to check all possible prefixes.
        for (int i = 1; i < word.length(); i++) {  
            String prefix = word.substring(0, i);  //start --> current tak
            String suffix = word.substring(i);  // current --> end tak

            // Check if prefix is in dictionary and (suffix is either a word or a compound word)
            if (dictionary.contains(prefix) && (dictionary.contains(suffix) || isCompoundWordOrNot(suffix, dictionary, memo))) {
                memo.put(word, true);
                return true;
            }
        }

        memo.put(word, false);
        return false;
    }



    // Part 2- Now this is a Method to process words from a given file
    private static void processsWords(String filePath) throws IOException {
        long startTime = System.currentTimeMillis(); // calculate time by using a a speicial method currentTimeMillis() which calculate time in millis as stated in your problem

        List<String> words = new ArrayList<>();  // for storing the words
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;   //takes each line in the file
            while ((line = reader.readLine()) != null) { //read until end
                words.add(line.trim());  //add trimmed i.e. without spaces to the list created above
            }
        }

        Set<String> wordSet = new HashSet<>(words);    // Created a set from the list for fast lookups
        Map <String, Boolean > memo = new HashMap<>();    // and this map to store computed results
        String longest = "";   // set empty
        String secondLongest = ""; // also set this empty

        for (String word : words) {
            if (isCompoundWordOrNot(word, wordSet, memo )) { //in this we are updating longest and second longest
                if ( word.length() > longest.length() ) {
                    secondLongest = longest; //  ANS1
                    longest = word;
                } else if ( word.length() > secondLongest.length() ) {
                    secondLongest = word;    //ANS2
                }
            }
        }

        long endTime  =   System.currentTimeMillis();
        long duration =   endTime - startTime; // ANS3


        System.out.println("--------------------------------------------------------------");
        System.out.println(" Longest Compound Word: " + longest); //ANS1
        System.out.println(" Second Longest Compound Word: " + secondLongest); //ANS2
        System.out.println(" Time taken to process file " + filePath + ": " + duration + " Milliseconds"); //ANS3
        System.out.println("--------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------");
    }



    // Part 3-  Main Function 
    public static void main(String[] args) {
        
        String inputFilePath1 = "Input_01.txt"; 
        String inputFilePath2 = "Input_02.txt"; 
        String inputFilePath3 = "Input_03.txt";  // lets take example 
        try {
            System.out.println("Processing Input_01.txt..."); //GIVEN
            processsWords(inputFilePath1);

            System.out.println("\nProcessing Input_02.txt...");  //GIVEN
            processsWords(inputFilePath2);

            System.out.println("\nProcessing Input_03.txt...");
            processsWords(inputFilePath3);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }


}
//end