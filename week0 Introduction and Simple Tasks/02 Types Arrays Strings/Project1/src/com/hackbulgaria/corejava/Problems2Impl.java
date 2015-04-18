package com.hackbulgaria.corejava;

import java.awt.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Problems2Impl implements Problems2 {

    @Override
    public boolean isOdd(int number) {
        return Math.abs(number) % 2 == 1;
    }

    @Override
    public boolean isPrime(int number) {
        number = Math.abs(number);
        if (number < 2) {
            return false;
        } else if (number == 2) {
            return true;
        }
        for (int i = 2; i < Math.ceil(Math.sqrt(number)) + 1; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int min(int... array) {
        Arrays.sort(array);
        return array[0];
    }

    @Override
    public int kthMin(int k, int[] array) {
        Arrays.sort(array);
        return array[k-1];
    }
    
    /*// if there were duplicates in the array
     public int kthMin(int k, int[] array) {
        Arrays.sort(array);
        int counter = 0;
        k--;
        while (k > 0) {
            counter++;
            if (array[counter - 1] != array[counter]) {
                k--;
            }
        }
        return array[counter];
    }
    */

    @Override
    public float getAverage(int[] array) {
        int sum = 0;
        for (int number : array) {
            sum += number;
        }
        return (float) sum / array.length;
    }

    @Override
    public long getSmallestMultiple(int upperBound) {
        upperBound = Math.abs(upperBound);
        if (upperBound == 1) {
            return 1;
        }
        long smallestMultiple = 1;
        for (int prime = 2; prime <= upperBound; prime++) {
            if (isPrime(prime)) {
                int power = (int) (Math.log(upperBound) / Math.log(prime));
                smallestMultiple *= Math.pow(prime, power);
            }
        }
        return smallestMultiple;
    }

    @Override
    // better solution?
    public long getLargestPalindrome(long N) {
        String number = String.valueOf(N);
        String halfPalindrome = number.substring(0, (number.length() - 1) / 2 + 1);
        String tail;
        if (number.length() % 2 == 1) {
            tail = new StringBuffer(halfPalindrome).reverse().toString().substring(1);
        } else {
            tail = new StringBuffer(halfPalindrome).reverse().toString();
        }
        String palindrome = halfPalindrome.concat(tail);
        if (Integer.parseInt(palindrome) < N) {
            return Integer.parseInt(palindrome);
        } else {
            int middle = Integer.parseInt(halfPalindrome);
            halfPalindrome = String.valueOf(middle - 1);
            if ((number.length() % 2 == 1) && ((number.length() - 1) / 2 + 1 == halfPalindrome.length())) {
                tail = new StringBuffer(halfPalindrome).reverse().toString().substring(1);
            } else if ((number.length() % 2 == 0) && !((number.length() - 1) / 2 + 1 == halfPalindrome.length())) {
                tail = "9" + new StringBuffer(halfPalindrome).reverse().toString();
            } else {
                tail = new StringBuffer(halfPalindrome).reverse().toString();
            }
            palindrome = halfPalindrome.concat(tail);
            return Integer.parseInt(palindrome);
        }
    }

    @Override
    public int[] histogram(short[][] image) {
        int[] result = new int[256];
        for (int row = 0; row < image.length; row++)
            for (int col = 0; col < image[0].length; col++) {
                result[image[row][col]]++;
            }
        return result;
    }

    @Override
    public long doubleFac(int n) {
        return kthFac(2, n);
    }

    @Override
    public long kthFac(int k, int n) {
        int start = 1;
        int end = n;
        int result = 1;
        while (k > 0) {
            for (int i = start; i <= end; i++) {
                result *= i;
            }
            start = end + 1;
            end = result;
            k--;
        }
        return result;
    }

    @Override
    public int getOddOccurrence(int[] array) {
        Arrays.sort(array);
        int startIndex = 0;
        for (int index = 1; index < array.length; index++) {
            if (array[index - 1] != array[index]) {
                if ((index - startIndex) % 2 == 1) {
                    return array[index - 1];
                }
                startIndex = index;
            }
        }
        return array[array.length - 1];
    }

    @Override
    public long pow(int a, int b) {
        // think it over!!! O(log(b))
        return (long) Math.pow(a, b);
    }

    @Override
    public long maximalScalarSum(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int scalar = 0;
        for (int i = 0; i < a.length; i++) {
            scalar += a[i] * b[i];
        }
        return scalar;
    }

    @Override
    public int maxSpan(int[] array) {
        int maxSpan = 0;
        for (int i = 0; i < array.length - 1; i++)
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] == array[i] && maxSpan < j - i + 1) {
                    maxSpan = j - i + 1;
                }
            }           
        return maxSpan;
    }

    @Override
    public boolean canBalance(int[] array) {
        int sum = 0;
        for (int number: array) {
            sum += number;
        }
        if (sum % 2 == 1) {
            return false;
        } else {
            int half = 0;
            for (int i = 0; half < sum / 2; i++) {
                half += array[i];
            }
            return half == sum / 2;
        }
    }

    @Override
    public int[][] rescale(int[][] original, int newWidth, int newHeight) {
        // ????????
        return null;
    }

    @Override
    public String reverseMe(String argument) {
        return new StringBuffer(argument).reverse().toString();
    }

    @Override
    public String copyEveryChar(String input, int k) {
        // last test corrected from "Ww" -> "WW"
        String result = "";
        for (int i = 0; i < input.length(); i++)
            for (int count = 0; count < k; count++) {
                result += input.charAt(i);
            }        
        return result;
    }

    @Override
    public String reverseEveryWord(String arg) {
        String[] words = arg.split(" ");
        for (int i = 0; i < words.length; i++)
            words[i] = new StringBuffer(words[i]).reverse().toString();
        return String.join(" ", words);
    }

    @Override
    public boolean isPalindrome(String argument) {
        // why so... (serious?) == works sometimes?
        String half = argument.substring(0, (argument.length() - 1) / 2 + 1);
        String tail;
        if (argument.length() % 2 == 1) {
            tail = new StringBuffer(half).reverse().toString().substring(1);
        } else {
            tail = new StringBuffer(half).reverse().toString();
        }
        String result = half.concat(tail);
        return argument.compareTo(result) == 0;
    }

    @Override
    public boolean isPalindrome(int number) {
        return isPalindrome(String.valueOf(number));
    }

    @Override
    public int getPalindromeLength(String input) {
        String tail = input.substring((input.length() - 1)/ 2 + 1);
        String head = new StringBuffer(tail).reverse().toString();
        String result = head.concat("*").concat(tail);
        while (input.indexOf(result) == -1) {
            head = head.substring(1);
            tail = new StringBuffer(head).reverse().toString();
            result = head.concat("*").concat(tail);
        }
        return head.length();
    }

    @Override
    public int countOcurrences(String needle, String haystack) {
        // problem if needle is " ", rethink later; replace?
        return (haystack + " ").split(needle).length - 1;
    }

    @Override
    public String decodeURL(String input) {
        return input.replace("%20", "").replace("%3A", ":").replace("%3D", "?").replace("%2F", "/");
    }

    @Override
    public int sumOfNumbers(String input) {
        // refactor...
        int sum = 0;
        String[] l = input.replaceAll("-", " -").replaceAll("[^-, 0-9]+", " ").split(" ");
        for (int i = 0; i < l.length; i++) {
            if (l[i].length() > 0)
                sum += Integer.parseInt(l[i]);
        }
        return sum;
    }

    @Override
    public boolean areAnagrams(String A, String B) {
        // refactor...
        String[] lA = A.replace(" ", "").split("");
        String[] lB = B.replace(" ", "").split("");
        Arrays.sort(lA);
        Arrays.sort(lB);
        String lAA = String.join("", lA);
        String lBB = String.join("", lB);
        return lAA.compareTo(lBB) == 0;
    }

    @Override
    public boolean hasAnagramOf(String string, String string2) {
        boolean flag = false;
        for (int i = 0; i < string2.length(); i++) {
            int len = 1;
            while (len <= string2.length() - i) {
                if (areAnagrams(string, string2.substring(i, i + len))) {
                    flag = true;
                    break;
                }
                len++;
            }
            if (flag)
                break;
        }
        return flag;
    }

}
