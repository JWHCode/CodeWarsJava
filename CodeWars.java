/*
In this kata we want to convert a string into an integer. The strings simply represent the numbers in words.

Examples:

    "one" => 1
    "twenty" => 20
    "two hundred forty-six" => 246
    "seven hundred eighty-three thousand nine hundred and nineteen" => 783919

Additional Notes:

    The minimum number is "zero" (inclusively)
    The maximum number, which must be supported is 1 million (inclusively)
    The "and" in e.g. "one hundred and twenty-four" is optional, in some cases it's present and in others it's not
    All tested numbers are valid, you don't need to validate them


*/

public class Parser {
    
    public static int parseInt(String numStr) {
      String[] numberArray = numStr.split("-|\\s+");
      StringBuilder numberBuilder = new StringBuilder();
      int returnValue = 0;
      for (String word : numberArray) {
        int lastDigit;
        switch (word.toLowerCase()) {
            case "one":
              returnValue += 1;
              break;
            case "two" :
              returnValue += 2;
              break;
            case "three" :
              returnValue += 3;
              break;
            case "four" : 
              returnValue += 4;
              break;
            case "five" :
              returnValue += 5;
              break;
            case "six" :
              returnValue += 6;
              break;
            case "seven" :
              returnValue += 7;
              break;
            case "eight" :
              returnValue += 8;
              break;
            case "nine" :
              returnValue += 9;
              break;
            case "ten" :
              returnValue += 10;
              break;
            case "eleven" :
              returnValue += 11;
              break;
            case "twelve" :
              returnValue += 12;
              break;
            case "thirteen" :
              returnValue += 13;
              break;
            case "fourteen" :
              returnValue += 14;
              break;
            case "fifteen" :
              returnValue += 15;
              break;
            case "sixteen" :
              returnValue += 16;
              break;
            case "seventeen" :
              returnValue += 17;
              break;
            case "eighteen" :
              returnValue += 18;
              break;
            case "nineteen" :
              returnValue += 19;
              break;
            case "twenty" :
              returnValue += 20;
              break;
            case "thirty" :
              returnValue += 30;
              break;
            case "forty" :
              returnValue += 40;
              break;
            case "fifty" :
              returnValue += 50;
              break;
            case "sixty" :
              returnValue += 60;
              break;
            case "seventy" :
              returnValue += 70;
              break;
            case "eighty" :
              returnValue += 80;
              break;
            case "ninety" :
              returnValue += 90;
              break;
            case "hundred" :
              lastDigit = returnValue % 10;
              if (returnValue > 10 && lastDigit == 0)
                lastDigit = returnValue % 100;
            else {
                returnValue -= lastDigit;
                returnValue += (lastDigit * 100);
              }
              break;
            case "thousand" : 
              lastDigit = returnValue % 10;
            if (returnValue > 99 && lastDigit == 0) {
                lastDigit = returnValue % 1000;
                returnValue += (lastDigit * 1000);
                returnValue -= lastDigit;
              }
            else if (returnValue > 9 && lastDigit == 0) {
              lastDigit = returnValue % 100;
              returnValue -= lastDigit;
              returnValue += (lastDigit * 1000);
            }
            else {
              returnValue = returnValue * 1000;
              }
              break;
            case "million" :
              returnValue = 1000000;
            default :
              break;
        }
          
      }
      
      return returnValue;
    }
}

/*
Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.
*/
// This can be also done with regex and a replace all, like replaceAll("(\\w)(\\w*)", "$2$1ay" but the long way was more fun to think about for practice than
// doing it all under the hood

public class PigLatin {
    public static String pigIt(String str) {
      StringBuilder returnString = new StringBuilder();
      String[] splitString = str.split(" ");
      for (String word : splitString) {
        if ((word.matches("\\w+\\.?"))) {
          if (word.length() == 1) {  
            returnString.append(word);
            returnString.append("ay");
          }
          else {
            returnString.append(word.substring(1,word.length()));
            returnString.append(word.substring(0,1));
            returnString.append("ay");
          }
        }
        else {
          if (word.length() == 1) {
            returnString.append(word);  
          }    
          else {
            returnString.append(word.substring(1,word.length()));
            returnString.append(word.substring(0,1));
            returnString.append("ay");
            returnString.append(word.substring(word.length()));
          }
        }  
        returnString.append(" ");
    }
    return returnString.toString().trim(); 
  }

/*
You live in the city of Cartesia where all roads are laid out in a perfect grid. 
You arrived ten minutes too early to an appointment, so you decided to take the opportunity to go for a short walk. 
The city provides its citizens with a Walk Generating App on their phones -- everytime you press the button it sends you an array of one-letter strings representing directions to walk (eg. ['n', 's', 'w', 'e']). 
You always walk only a single block for each letter (direction) and you know it takes you one minute to traverse one city block, so create a function that will return true if the walk the app gives you will take you exactly ten minutes (you don't want to be early or late!) and will, of course, return you to your starting point. 
Return false otherwise.
*/

public class TenMinWalk {
  public static boolean isValid(char[] walk) {
    if (walk.length != 10) { // has to be exactly 10 in length due to specification
      return false;
    }
    int n = 0;
    int s = 0;
    int e = 0;
    int w = 0;
    for (char c : walk) {
      switch (Character.toLowerCase(c)) {
          case 'n': 
            n++;
            break;
          case 's':
            s++;
            break;
          case 'e':
            e++;
            break;
          case 'w':
            w++;
          break;  
      }
    }
    if (n - s == 0 && e - w == 0) {  // If we want to end up where we were, then the difference of opposites must = 0
      return true;
      }
    else {
      return false;
    }
  }

/*
Given two arrays a and b write a function comp(a, b) (orcompSame(a, b)) that checks whether the two arrays have the "same" elements, with the same multiplicities (the multiplicity of a member is the number of times it appears). "Same" means, here, that the elements in b are the elements in a squared, regardless of the order.
Examples
Valid arrays

a = [121, 144, 19, 161, 19, 144, 19, 11]  
b = [121, 14641, 20736, 361, 25921, 361, 20736, 361]

comp(a, b) returns true because in b 121 is the square of 11, 14641 is the square of 121, 20736 the square of 144, 361 the square of 19, 25921 the square of 161, and so on. It gets obvious if we write b's elements in terms of squares:

a = [121, 144, 19, 161, 19, 144, 19, 11] 
b = [11*11, 121*121, 144*144, 19*19, 161*161, 19*19, 144*144, 19*19]

Invalid arrays

If, for example, we change the first number to something else, comp is not returning true anymore:

a = [121, 144, 19, 161, 19, 144, 19, 11]  
b = [132, 14641, 20736, 361, 25921, 361, 20736, 361]

comp(a,b) returns false because in b 132 is not the square of any number of a.

a = [121, 144, 19, 161, 19, 144, 19, 11]  
b = [121, 14641, 20736, 36100, 25921, 361, 20736, 361]

comp(a,b) returns false because in b 36100 is not the square of any number of a.
Remarks

    a or b might be [] or {} (all languages except R, Shell).
    a or b might be nil or null or None or nothing (except in C++, COBOL, Crystal, D, Dart, Elixir, Fortran, F#, Haskell, Nim, OCaml, Pascal, Perl, PowerShell, Prolog, PureScript, R, Racket, Rust, Shell, Swift).

If a or b are nil (or null or None, depending on the language), the problem doesn't make sense so return false.
*/

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

public class AreSame {
	public static boolean comp(int[] a, int[] b) {
	    if (a == null || b == null || a.length != b.length) // lets remove the disqualifying conditions first
	      return false;
	    List<Integer> bList = Arrays.stream(b).boxed().collect(Collectors.toList());
	    for (int i = 0; i < a.length; i++) {// move sequentially through a and look for the matching a*a in b, if we don't find it we false return out
	      int square = a[i]*a[i]; // could math.pow a[i],2 don't think there's a difference
              if (!bList.contains(square)) {
	      	return false;
	      }//could be a binary search situation, but there's no promise that these arrays are sorted, so I think its equal  
	      else {
	    	  bList.remove(new Integer(square)); // to make sure the n count in both is equal, we've got to remove matches from the list
	       } 
	     }
	 return true;
	}
}


/*
Write a function that accepts an array of 10 integers (between 0 and 9), that returns a string of those numbers in the form of a phone number.
*/

public class Kata {
  public static String createPhoneNumber(int[] numbers) {
    if (numbers.length != 10) // no error handling was specified in the description, so
      return null;
    return String.format("(%d%d%d) %d%d%d-%d%d%d%d", 
                         numbers[0],numbers[1],numbers[2],numbers[3],numbers[4],numbers[5],numbers[6],numbers[7],numbers[8],numbers[9]);
    } // demonstrating string interpolation seemed the most straight forward approach since the size of the array is static.
  }

/*
Digital root is the recursive sum of all the digits in a number.
Given n, take the sum of the digits of n. If that value has more than one digit, continue reducing in this way until a single-digit number is produced. 
The input will be a non-negative integer.
 */
public class DigitalRoot {
	  public static int digital_root(int n) {
		  if (n > 0 && n < 10) 
			  return n;
		  int sum = 0;
		  while (n > 0) {
			  sum =  sum + (n % 10);
			  n = n / 10;
		  }
		  if (sum >= 10) {
			  return digital_root(sum);
		  }
		  else
			  return sum;
	  }
}

/* look for the number of unique duplicants in a string*/
import java.util.HashMap;

public class CountingDuplicates {
  public static int duplicateCount(String text) {
  HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		  int dupes = 0;
		  int value;
		  for (int i = 0; i < text.length(); i++) {
			  int testCase = (int)Character.toUpperCase(text.charAt(i));
        if (countMap.containsKey(testCase)) {
           value = countMap.get(testCase);
		   	  countMap.put(testCase, value+1);
           if (value+1 == 1) {
              dupes++;
		   	  }
		    }
		    else {
		   	  	countMap.put(testCase, 0);
              }
	   }		    
		  return dupes;
	  }
}

/* check to see if the submitted string is a pangram */
  public class PangramChecker {
  public boolean check(String sentence){
    if (sentence.length() < 26) 
      return false;
    for (char x = 'a'; x <= 'z'; x++) {
      if (sentence.indexOf(x) != -1 || sentence.indexOf(Character.toUpperCase(x)) != -1)
        ;
      else 
         return false;
    }
   return true;
  }
}

/* return a camel case of a string, respecting the case status of the first character */
import java.lang.StringBuilder;

public class Solution {
	static String toCamelCase(String s){
	//Nothing Submitted, nothing to do
    if (s.length() == 0) 
      return "";
    StringBuilder returnValue = new StringBuilder();
    returnValue.append(s.charAt(0)); // first character upper/lower case handled by just appending it and starting at slot 1 instead of 0
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) != '-' && s.charAt(i) != '_') 
        returnValue.append(s.charAt(i));
      else {
        returnValue.append(Character.toUpperCase(s.charAt(i+1)));
        i++;
      }
    }
    return returnValue.toString();
  }
}
