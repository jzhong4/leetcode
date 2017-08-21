/*
 Author:     Junjie
 Date:       July 29, 2017
 Problem:    Longest Substring Without Repeating Characters
 Difficulty: Medium
 Source:     https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 Given a string, find the length of the longest substring without repeating characters. 
 Examples:
 Given "abcabcbb", the answer is "abc", which the length is 3.
 Given "bbbbb", the answer is "b", with the length of 1.
 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring. 

 Solution1:O(n) runtime, O(1) space – Two iterations:
 
 When you have found a repeated character (let’s say at index j), it means that the current substring (excluding the repeated character of course) is a potential maximum, so update the maximum if necessary. It also means that the repeated character must have appeared before at an index i, where i is less than j. 

 Since you know that all substrings that start before or at index i would be less than your current maximum, you can safely start to look for the next substring with head which starts exactly at index i + 1. 

 Therefore, you would need two indices to record the head and the tail of the current substring. Since i and j both traverse at most n steps, the worst case would be 2n steps,
*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] exist = new boolean[256];
        int i = 0, maxLen = 0;
        for(int j = 0; j < s.length(); j++){
            while(exist[s.charAt(j)]){
                exist[s.charAt(i)] = false;
                i++;
            }
            exist[s.charAt(j)] = true;
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }
}

 Solution2: O(n) runtime, O(1) space – Single iteration
 public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] charMap = new int[256];
        Arrays.fill(charMap, - 1);
        int i = 0, maxLen = 0;
        for(int j = 0; j < s.length(); j++){
            if(charMap[s.charAt(j)] >= i){
                i = charMap[s.charAt(j)] + 1;
            }
            charMap[s.charAt(j)] = j; 
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }
}