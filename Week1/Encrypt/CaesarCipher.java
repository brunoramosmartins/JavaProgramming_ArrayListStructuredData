
/**
 * Escreva a descrição da classe CaesarCipher aqui.
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
            int idx = alphabet.indexOf(currChar);
            // if currChar is in the alphabet
            if (idx != -1) {
                // Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet.charAt(idx);
                // Replace the ith character of encrypted with the newChar
                encrypted.setCharAt(i, newChar);
            }
            // Otherwise: do nothing
        }
        // Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    
    public void testCaesar() {
        int key = 17;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println(encrypted);
        String decrypted =  encrypt(encrypted, 26 - key);
        System.out.println(decrypted);        
    }
}
