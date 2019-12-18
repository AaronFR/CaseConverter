import java.util.ArrayList;
 
public class CaseConverter {

       public static ArrayList<Character> stringToCharArrayList(String inputString) {
              ArrayList<Character> inputCharacters = new ArrayList<Character>();

              for (char c : inputString.toCharArray()) {
                     inputCharacters.add(c);
              }

              return inputCharacters;
       }
       
       public static String charArrayListToString(ArrayList<Character> list) {
              StringBuilder builder = new StringBuilder (list.size());
              for (Character c : list)
              {
                     builder.append(c);
              }
              return builder.toString();
       }

       public static ArrayList<Character> toSnakeCase(
              ArrayList<Character> originalArrayList
       ) {
              ArrayList<Character> snakedArrayList = new ArrayList<Character>(
                     originalArrayList
              );
              char replacementCharacter = '_';

              int index = 0;
              for(char ch: originalArrayList) {
                     if(Character.isUpperCase(ch)){
                            snakedArrayList.add(index, replacementCharacter);
                            index++;
                            snakedArrayList.remove(index);
                            snakedArrayList.add(index, Character.toLowerCase(ch));
                     }

                     index ++;
              }

              return snakedArrayList;
       }
        
       public static String camelCaseToSnakeCase(String text) {
              /* Simplist Solution
              return text.replaceAll("(.)(\\p{Upper})", "$1_$2").toLowerCase();

              (.) = 1st group matches any character
              (\\p{Upper}) = pattern match to {Upper case characters}
              $1, $2 = Group 1 and group 2 respectively
              */

              ArrayList<Character> textArray = stringToCharArrayList(text);
              return charArrayListToString(toSnakeCase(textArray));
       }
    
       public static void main(String[] args) {
              // Expected output:
              // this_is_some_text
              System.out.println(CaseConverter.camelCaseToSnakeCase("thisIsSomeText"));
              }
       }