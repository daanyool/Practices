import java.util.Scanner;
import java.text.*;
public class CharacterCounterWithFileInput {
  public static void main(String[] args) {
    int consonant = 0, vowel = 0, puncChar = 0, space = 0, num = 0;
    DecimalFormat numForm = new DecimalFormat("0.00");
    Scanner obj = new Scanner(System.in);
    
    System.out.println("Enter a String: ");
    String stringLine = obj.nextLine();
    
    int max = stringLine.length();
    String allLower = stringLine.toLowerCase();
    
    for(int charNum = 0; charNum<max; charNum++) {
      char chr = allLower.charAt(charNum);
      switch(chr) {
        case 'a': case 'e': case 'i': case 'o': case 'u':
          vowel++; break;
        case 'b': case 'c': case 'd': case 'f': case 'g':
        case 'h': case 'j': case 'k': case 'l': case 'm':
        case 'n': case 'p': case 'q': case 'r': case 's':
        case 't': case 'v': case 'w': case 'x': case 'y': case 'z':
          consonant++; break;
        case '0': case '1': case '2': case '3': case '4':
        case '5': case '6': case '7': case '8': case '9':
          num++; break;
        case ' ':
          space++; break;
        default:
          puncChar++;
     }  
   } 
    System.out.println("Number of consonants: " + consonant);
    System.out.println("Number of vowels: " + vowel);
    System.out.println("Number of spaces: " + space);
    System.out.println("Number of punctuation characters: " + puncChar);
    
    System.out.println("\nPercentages: ");    //calculating what percent of the length is the consonants, vowels, spaces, and punctuations
    System.out.println("\tconsonants: " + numForm.format((float)consonant / max * 100.0) + "%");
    System.out.println("\tvowels: " + numForm.format((float)vowel / max * 100.0) + "%");
    System.out.println("\tspaces: " + numForm.format((float)space / max * 100.0) + "%");
    System.out.println("\tpunctuation characters: " + numForm.format((float)puncChar / max * 100.0) + "%");
    }
 }