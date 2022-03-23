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
