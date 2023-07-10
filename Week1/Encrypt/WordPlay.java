
/**
 * Escreva a descrição da classe WordPlay aqui.
 * 
 * @author Bruno Ramos Martins 
 * @version 10-07-2023
 */

public class WordPlay {
    
    public boolean isVowel(char ch) {
        String vowels = "aeiou";
        char lowercaseCh = Character.toLowerCase(ch);
        return vowels.contains(String.valueOf(lowercaseCh));
    }
    
    public String replaceVowels(String phrase, char ch) {
        StringBuilder newPhrase = new StringBuilder(phrase);
        
        for (int i = 0; i < phrase.length(); i++) {
            char currChar = newPhrase.charAt(i);
            if (isVowel(currChar)) {
                newPhrase.setCharAt(i, ch);
            }
        }
        
        return newPhrase.toString();
    }
    
    public String emphasize(String phrase, char ch) {
        StringBuilder newPhrase = new StringBuilder(phrase);
        
        for (int i = 0; i < phrase.length(); i++) {
            char currChar = newPhrase.charAt(i);
            if (isVowel(currChar)) {
                if (i % 2 != 0) {
                    newPhrase.setCharAt(i, '*');
                }
                else {
                    newPhrase.setCharAt(i, ch);
                }
            }
        }
        
        return newPhrase.toString();
    }
    
    // test isVowel(ch)
    public void testIsVowel() {
        
        if (!isVowel('a')) {
            System.out.println("isVowel('a') failed!");
        }
        else if (!isVowel('E')) {
            System.out.println("isVowel('E') failed!");
        }
        else if (isVowel('B')) {
            System.out.println("isVowel('B') failed!");
        }
        else if (isVowel('x')) {
            System.out.println("isVowel('x') failed!");
        }
        else {
            System.out.println("All test pass!");
        }
    }
    
    // test replaceVowels(phrase, ch)
    public void testReplaceVowels() {
        if (!replaceVowels("Hello World", '*').equals("H*ll* W*rld")) {
            System.out.println("replaceVowels(\"Hello World\", '*') failed!");
        }
        else if (!replaceVowels("AaBbCcDdEe", '#').equals("##BbCcDd##")) {
            System.out.println("replaceVowels(\"Hello World\", '*') failed!");
        }
        else {
            System.out.println("All test pass!");
        }
    }
}
