
/**
 * The Caesar Cipher simulation program is designed to encrypt and decrypt
 * messages using the famous Caesar Cipher algorithm. The Caesar Cipher is 
 * a substitution cipher that involves shifting the letters of the alphabet 
 * by a fixed number of positions. In this program, the user can specify the 
 * number of positions to shift the letters.
 * 
 * @author Bruno Ramos Martins 
 * @version 09/07/2023
 */

import edu.duke.*;

public class CaesarCipher {
    public String encrypt(String input, int key) {
        // Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        // Write down the alphabet
        String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
        // Compute the shifted alphabet
        String shiftedAlphabetUpper = alphabetUpper.substring(key) + alphabetUpper.substring(0, key);
        String shiftedAlphabetLower = alphabetLower.substring(key) + alphabetLower.substring(0, key);
        
        // Count from 0 to < length of encrypted, (call it i)
        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            // Find the index of currChar in alphabet (call it idx)
            int idx = alphabetLower.indexOf(currChar);
            if (idx != -1) {
                // Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabetLower.charAt(idx);
                // Replace the ith character of encrypted with the newChar
                encrypted.setCharAt(i, newChar);                
            }
            idx = alphabetUpper.indexOf(currChar);
            // if currChar is in the alphabet UpperCase
            if (idx != -1) {
                // Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabetUpper.charAt(idx);
                // Replace the ith character of encrypted with the newChar
                encrypted.setCharAt(i, newChar);
            }
        }
        // Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    
    public String encryptTwoKeys(String input, int key1, int key2) {
        // Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        
        for (int i = 0; i < input.length(); i++) {
            char currChar = encrypted.charAt(i);
            String currString = String.valueOf(currChar);
            String cryptString;
            if (i % 2 == 0) {
                cryptString = encrypt(currString, key1);
            }
            else {
                cryptString = encrypt(currString, key2);               
            }
            
            encrypted.setCharAt(i, cryptString.charAt(0));
        }
                
        return encrypted.toString();
    }
    
    public void testCaesar() {
        int key = 17;
        // FileResource fr = new FileResource();
        // String message = fr.asString();
        // String encrypted = encrypt(message, key);
        // System.out.println(encrypted);
        // String decrypted =  encrypt(encrypted, 26 - key);
        // System.out.println(decrypted);
        
        if (!encrypt("FIRST LEGION ATTACK EAST FLANK!", 23).equals("CFOPQ IBDFLK XQQXZH BXPQ CIXKH!")) {
            System.out.println("encrypt(\"FIRST LEGION ATTACK EAST FLANK\", 23) failed!");
            System.out.println("  output: " + encrypt("FIRST LEGION ATTACK EAST FLANK", 23));
            System.out.println("expected: CFOPQ IBDFLK XQQXZH BXPQ CIXKH!");
        }
        else if (!encrypt("First Legion", 23).equals("Cfopq Ibdflk")) {
            System.out.println("encrypt(\"First Legion\", 23) failed!");
            System.out.println("  output: " + encrypt("First Legion", 23));
            System.out.println("expected: Cfopq Ibdflk");
        }
        else if (!encrypt("First Legion", 17).equals("Wzijk Cvxzfe")) {
            System.out.println("encrypt(\"First Legion\", 17) failed!");
            System.out.println("  output: " + encrypt("First Legion", 17));
            System.out.println("expected: Wzijk Cvxzfe");
        }
        else if (!encryptTwoKeys("First Legion", 23, 17).equals("Czojq Ivdzle")) {
            System.out.println("encryptTwoKeys(\"First Legion\", 23, 17) failed!");
            System.out.println("  output: " + encryptTwoKeys("First Legion", 23, 17));
            System.out.println("expected: Czojq Ivdzle");
        }
        else {
            System.out.println("All test pass!");
        }
    }
    
    public void answerCaesarCipher() {
        // Q5
        String text = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        System.out.println(encrypt(text,15));
        // Q6
        System.out.println(encryptTwoKeys(text, 8, 21));
    }
}
