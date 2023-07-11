
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
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // Compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        
        // Count from 0 to < length of encrypted, (call it i)
        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            // Find the index of currChar in alphabet (call it idx)
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            // if currChar is in the alphabet
            if (idx != -1) {
                // Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet.charAt(idx);
                // Replace the ith character of encrypted with the newChar
                encrypted.setCharAt(i, newChar);
            }
            // Do nothing
        }
        // Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    
    public void encryptTwoKeys(String input, int key1, int key2) {
        
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
        else {
            System.out.println("All test pass!");
        }
    }
}
