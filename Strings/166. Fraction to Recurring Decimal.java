/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

If multiple answers are possible, return any of them.

It is guaranteed that the length of the answer string is less than 104 for all the given inputs.

 

Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"
Example 2:

Input: numerator = 2, denominator = 1
Output: "2"
Example 3:

Input: numerator = 4, denominator = 333
Output: "0.(012)"
 */

//SOURCE CODE:

import java.util.*;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        
        StringBuilder result = new StringBuilder();
        
        // Handle sign
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }
        
        // Convert to long to avoid overflow (like -2147483648 case)
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        // Integer part
        result.append(num / den);
        long remainder = num % den;
        
        if (remainder == 0) return result.toString();
        
        // Fractional part
        result.append(".");
        Map<Long, Integer> map = new HashMap<>(); // remainder -> index in result
        
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                // Insert '(' at index where this remainder first appeared
                result.insert(map.get(remainder), "(");
                result.append(")");
                break;
            }
            
            // Store index of remainder before appending digit
            map.put(remainder, result.length());
            
            remainder *= 10;
            result.append(remainder / den);
            remainder %= den;
        }
        
        return result.toString();
    }
}
