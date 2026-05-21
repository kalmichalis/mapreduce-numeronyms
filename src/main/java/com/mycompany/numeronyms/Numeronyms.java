package com.mycompany.numeronyms;


import java.io.*;       
import java.util.*;     

public class Numeronyms {

    public static void main(String[] args) throws IOException {


        String filename = "SherlockHolmes.txt"; // to txt pou tha exw os eisodo
        int k = 10; // elaxisto plithos sumfona me thn ekfonisi twn numeronyms

        
        //Δημιουργία HashMap για να μετράμε numeronyms
        // Κλειδί = numeronym (π.χ. "s5n")
        // Τιμή = πλήθος εμφανίσεων
        Map<String, Integer> countMap = new HashMap<>();

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {

            
            // Καθαρισμός γραμμής
            line = line.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();

            //διαχωρισμος λεξεων
            String[] words = line.split("\\s+");
            
            // επεξεργασια λεξης
            for (String word : words) {

                // Αγνοούμε λέξεις μικρότερες από 3 χαρακτήρες
                if (word.length() >= 3) {

                    // Πρώτος και τελευταίος χαρακτήρας της λέξης και πλήθος χαρακτήρων ανάμεσα στο πρώτο και τελευταίο
                    char first = word.charAt(0);
                    char last = word.charAt(word.length() - 1);

                    int middle = word.length() - 2;

                    // Δημιουργία numeronym
                    String numeronym = first + String.valueOf(middle) + last;

                    
                    // Προσθήκη στο HashMap (Reducer-style)

                    if (countMap.containsKey(numeronym)) {
                        // Υπάρχει ήδη το numeronym τότε αυξάνουμε κατά 1
                        int currentCount = countMap.get(numeronym); 
                        currentCount += 1;                          
                        countMap.put(numeronym, currentCount);    
                    } else {
                        // Δεν υπάρχει και το βρισκει για πρωτη φορα τότε  αρχικοποιούμε με 1
                        countMap.put(numeronym, 1);
                    }

                }
            }
        }


        br.close();

        
        // εκτύπωση αποτελεσμάτων
       
        System.out.println("Numeronyms with at least " + k + " appearances:");
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {

           
            if (entry.getValue() >= k) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
}