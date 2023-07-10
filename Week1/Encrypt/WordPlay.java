
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
}
