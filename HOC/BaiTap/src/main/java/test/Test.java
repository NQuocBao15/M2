package test;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[][] arr = {{},{}};
        System.out.println(containsDuplicate(arr));
    }
    public static boolean containsDuplicate(int[][] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }

    public int addDigits(int num) {
//        if(num == 0) return 0;
//        else if(num % 9 == 0) return 9;
//        else return num % 9;
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }

        return true;
    }
    public boolean isAnagram2(String s, String t) {
        // Base case: if the two strings are empty...
        if(s == null || t == null) {
            return false;
        }
        // In case of different length of those two string...
        if(s.length() != t.length()) {
            return false;
        }
        // To count freq we make an array of size 26...
        int[] counter = new int[26];
        // Traverse all elements through a loop...
        for(int idx = 0; idx < s.length(); idx++){
            counter[s.charAt(idx)-'a']++;
            counter[t.charAt(idx)-'a']--;
        }
        // Above iteration provides us with count array having all values to zero then we can say we found an anagram.
        // Every element of count has to be equal to 0.
        // If it is greater than 0 it means s has a character whose occurrence is greater than its occurrence in t.
        // And if it is less than 0 then, s has a character whose occurrence is smaller than its occurrence in t.
        for(int idx: counter){
            if(idx != 0)
                return false;
        }
        return true;
    }

    public double average(int[] salary) {
        int max =0;
        int min = 100000000;
        double avg=0;
        // getting max and min salary
        for(int i=0;i<salary.length;i++)
        {
            if(salary[i]>max)
                max=salary[i];
            if(salary[i]<min)
                min =salary[i];
        }

        // adding all the salaries

        for(int i=0;i<salary.length;i++)
        {
            avg+=salary[i];
        }
        avg = (avg-min-max)/(salary.length-2); // finding mean and excluding min and max values.
        return avg;
    }
}
