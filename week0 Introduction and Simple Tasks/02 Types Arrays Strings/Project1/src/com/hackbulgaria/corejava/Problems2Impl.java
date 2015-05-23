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
    // every element is unique in the array:
    public int kthMin(int k, int[] array) {
        Arrays.sort(array);
        return array[k - 1];
    }

    /*
     * // same task for array with duplicates: public int kthMin(int k, int[]
     * array) { Arrays.sort(array); int counter = 0; k--; while (k > 0) {
     * counter++; if (array[counter - 1] != array[counter]) { k--; } } return
     * array[counter]; }
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
    // the result can be divided by all Natural numbers between 1 and upperBound
    // maybe thats a slow solution...
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
    // gives the largest palindrome < N (or <= N?)
    // bonus: don't use Collections.sort
    public long getLargestPalindrome(long N) {
        if (N == 10 || N % 10 == N) {
            return N - 1;
        }
        String number = String.valueOf(N);
        int digits = number.length();
        int parity = digits % 2;
        String firstHalf = number.substring(0, (digits + 1) / 2);
        String secondHalf = new StringBuffer(firstHalf).reverse().toString().substring(parity);
        String palindrome = firstHalf.concat(secondHalf);
        if (Integer.parseInt(palindrome) < N) {
            return Integer.parseInt(palindrome);
        } else {
            int nextFirstHalf = Integer.parseInt(firstHalf) - 1;
            firstHalf = String.valueOf(nextFirstHalf);
            secondHalf = new StringBuffer(firstHalf).reverse().toString().substring(parity);
            if (nextFirstHalf % 10 == 9) {
                // the parity of the digits' count is changed so adapt the
                // middle digit
                firstHalf += "9";
            }
            palindrome = firstHalf.concat(secondHalf);
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
    // k is positive
    // bonus: without recursion and helper methods
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
    // rethink later
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
    } // Or would be better a help ArrayList with "turn on/off" element?

    @Override
    // solution for a >= 0, b >= 0
    // improve later
    public long pow(int a, int b) {
        if (b == 0) {
            return 1;
        } else if (b == 1) {
            return a;
        } else if (b % 2 == 0) {
            return pow(a * a, b / 2);
        } else {
            return a * pow(a * a, (b - 1) / 2);
        }
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
        for (int number : array) {
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
    // rethink: if the neighbours are at equal distance to a pixel
    //          shouldn't it get their average value; but the type is 'int' so it seems "no"...
    // looks like "top-left" pixels have priority according to google images:D
    // however search more for the algorithm later & refactor
    public int[][] rescale(int[][] original, int newWidth, int newHeight) {
        int width = original[0].length;
        int height = original.length;
        double widthRatio;
        double heightRatio;
        if (newWidth > width) {
            widthRatio = newWidth / width;
        } else {
            widthRatio = width / newWidth;
        }
        if (newHeight > height) {
            heightRatio = newHeight / height;
        } else {
            heightRatio = height / newHeight;
        }
        int[][] imageRescaled = new int[newHeight][newWidth];
        for (int row = 0; row < newHeight; row++)
            for (int column = 0; column < newWidth; column++) {
                imageRescaled[column][row] = original[(int)(column * widthRatio)][(int)(row * heightRatio)];
            }
        return imageRescaled;
    }

    @Override
    public String reverseMe(String argument) {
        return new StringBuffer(argument).reverse().toString();
    }

    @Override
    // last test adjusted from "Ww" to "WW"
    public String copyEveryChar(String input, int k) {
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
            words[i] = reverseMe(words[i]);
        return String.join(" ", words);
    }

    @Override
    public boolean isPalindrome(String argument) {
        int lengthParity = argument.length() % 2;
        String head = argument.substring(0, (argument.length() + 1) / 2);
        String tail = new StringBuffer(head).reverse().toString().substring(lengthParity);
        String result = head.concat(tail);
        return argument.compareTo(result) == 0;
    }

    @Override
    public boolean isPalindrome(int number) {
        return isPalindrome(String.valueOf(number));
    }

    @Override
    // accurate for only one star at random index in the string
    // otherwise => rethink; also refactor later
    public int getPalindromeLength(String input) {
        int starIndex = input.indexOf('*');
        String smallerPart;
        if (starIndex <= (input.length() + 1) / 2) {
            smallerPart = input.substring(0, starIndex);
            while (! input.contains(smallerPart + '*' + reverseMe(smallerPart))) {
                smallerPart = smallerPart.substring(1);
            }
        } else {
            smallerPart = input.substring(starIndex + 1);
            while (! input.contains(reverseMe(smallerPart) + '*' + smallerPart)) {
                smallerPart = smallerPart.substring(0, smallerPart.length() - 1);
            }
        }
        return smallerPart.length();
    }

    @Override
    public int countOcurrences(String needle, String haystack) {
        //System.out.println("dada".split("da").length);
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
