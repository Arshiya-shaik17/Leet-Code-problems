/*Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

 

Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
Example 2:

Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".
Example 3:

Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".
 

Constraints:

1 <= s.length, t.length <= 200
s and t only contain lowercase letters and '#' characters.


Source code:
*/
class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack <Character> stack1=new Stack<>();
        Stack<Character> stack2=new Stack<>();
        StringBuilder s1=new StringBuilder();
        StringBuilder t1=new StringBuilder();
        for(char c:s.toCharArray()){
            if(c!='#'){
                stack1.push(c);
            }
            else if(!stack1.isEmpty()){
                stack1.pop();
            }
        }
        while(!stack1.isEmpty()){
            s1.append(stack1.pop());
        }
        for(char c:t.toCharArray()){
            if(c!='#'){
                stack2.push(c);
            }
            else if(!stack2.isEmpty()){
                stack2.pop();
            }
        }
        while(!stack2.isEmpty()){
            t1.append(stack2.pop());
        }
        return s1.reverse().toString().equals(t1.reverse().toString());


    }

}
