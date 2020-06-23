import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Username {

	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // user input with validation
        int num = 0;
        while(true) {
	        try {
	            System.out.print("Enter number: ");
	            num = sc.nextInt();
	        } catch (Exception e) {
	            System.out.println("ERROR: Enter numbers only.");
	        }
	
	        // read word lists adjectives.txt and nouns.txt
	        try {
	            ArrayList<String> array1 = new ArrayList<>();
	            BufferedReader adjectives = new BufferedReader(new FileReader("src\\adjectives.txt"));
	            String adjLine;
	            while ((adjLine = adjectives.readLine()) != null) {
	                array1.add(adjLine);
	            }
	
	            ArrayList<String> array2 = new ArrayList<>();
	            BufferedReader nouns = new BufferedReader(new FileReader("src\\nouns.txt"));
	            String nounLine;
	            while ((nounLine = nouns.readLine()) != null) {
	                array2.add(nounLine);
	            }
	
	            // generate usernames
	            for (int i = 1; i <= num; i++) {
	                // construct usernames
	                int word1 = rand.nextInt(array1.size());
	                int word2 = rand.nextInt(array2.size());
	
	                try {
	                    // make the first letter of each word uppercase
	                    char cap1 = array1.get(word1).toUpperCase().charAt(0);
	                    char cap2 = array2.get(word2).toUpperCase().charAt(0);
	                    System.out.println(i+". "+cap1 + array1.get(word1).substring(1) + cap2 + array2.get(word2).substring(1) + rand.nextInt(99));
	                } catch (Exception e) {
	                    System.out.println("ERROR: You have generated too many usernames.");
	                }
	                adjectives.close();
	                nouns.close();
	            }
	        } catch (IOException e){
	            e.printStackTrace();
	        }
	        System.out.println();
        }	
	}

}
