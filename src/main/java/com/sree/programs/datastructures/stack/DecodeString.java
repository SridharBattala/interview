package com.sree.leave.programs.datastructures.stack;


import java.util.Stack;


public class DecodeString {
    /**
     *  Returns decoded string for 'str'
     */
    static String decode(final String str) {
        Stack<Integer> intStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();
        String temp = "", result = "";

        // Traversing the string
        for (int i = 0; i < str.length(); i++) {
            System.out.println(intStack.toString());
            System.out.println(charStack.toString());
            System.out.println("**********");
            int count = 0;

            // If number, convert it into number
            // and push it into intStack.
            if (Character.isDigit(str.charAt(i))) {
                while (Character.isDigit(str.charAt(i))) {
                    count = count * 10 + str.charAt(i) - '0';
                    i++;
                }
                i--;
                intStack.push(count);
            }

            // If closing bracket ']', pop element until
            // '[' opening bracket is not found in the
            // character stack.
            else if (str.charAt(i) == ']') {
                temp = "";
                count = 0;

                if (!intStack.isEmpty()) {
                    count = intStack.peek();
                    intStack.pop();
                }

                while (!charStack.isEmpty() && charStack.peek() != '[') {
                    temp = charStack.peek() + temp;
                    charStack.pop();
                }

                if (!charStack.empty() && charStack.peek() == '[')
                    charStack.pop();

                // Repeating the popped string temp count
                // number of times.
                for (int j = 0; j < count; j++)
                    result = result + temp;

                // Push it in the character stack.
                for (int j = 0; j < result.length(); j++)
                    charStack.push(result.charAt(j));

                result = "";
            }
            // If '[' opening bracket, push it into character stack.
            else if (str.charAt(i) == '[') {
                if (Character.isDigit(str.charAt(i - 1))) {
                    charStack.push(str.charAt(i));
                } else {
                    charStack.push(str.charAt(i));
                    intStack.push(1);
                }
            }

            else {
                charStack.push(str.charAt(i));
            }
        }

        // Pop all the elements, make a string and return.
        while (!charStack.isEmpty()) {
            result = charStack.peek() + result;
            charStack.pop();
        }

        return result;
    }


    public static void main(final String args[]) {
        String str1 = "2[ab3[d]]";
        System.out.println(decode(str1));
        String str2 = "2[ab30[cd]1[ef]]4[g]";
        System.out.println(decode(str2));
    }
}
