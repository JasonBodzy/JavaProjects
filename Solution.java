import java.io.*;
import java.util.*;

public class Solution {

    String convertString(String input){
        String rawInput = input;
        String inputString = rawInput.substring(4, rawInput.length());
        String output = "";
        int i = 0;

        if(rawInput.charAt(0) == 'S'){

            switch(rawInput.charAt(2)){
                case'V':
                    i = 0;
                    while(i < inputString.length()){
                        if( i < inputString.length() - 1 && Character.isUpperCase(inputString.charAt(i + 1))){
                            output += Character.toLowerCase(inputString.charAt(i));
                            output += " ";
                        } else {
                            output += Character.toLowerCase(inputString.charAt(i));
                        }
                        i++;
                    }
                    break;
                case 'C':
                    i = 0;
                    while(i < inputString.length()){
                        if(i != 0 && Character.isUpperCase(inputString.charAt(i))){
                            output += Character.toLowerCase(inputString.charAt(i));
                        } else if (i < inputString.length() - 1 && Character.isUpperCase(inputString.charAt(i + 1))){
                            output += Character.toLowerCase(inputString.charAt(i));
                            output += " ";
                        } else {
                            output += Character.toLowerCase((inputString.charAt(i)));
                        }
                        i++;
                    }
                    break;
                case 'M':
                    i = 0;
                    while(i < inputString.length()){
                        if(i != 0 && Character.isUpperCase(inputString.charAt(i))){
                            output += Character.toLowerCase(inputString.charAt(i));
                        } else if (i < inputString.length() - 1 && Character.isUpperCase(inputString.charAt(i + 1))){
                            output += Character.toLowerCase(inputString.charAt(i));
                            output += " ";
                        } else if (inputString.charAt(i) != '(' && inputString.charAt(i) != ')') {
                            output += Character.toLowerCase((inputString.charAt(i)));
                        }
                        i++;
                    }
                    break;
                default:
                    break;
            }
        }

        if(rawInput.charAt(0) == 'C'){
            switch(rawInput.charAt(2)){
                case'V':
                    i = 0;
                    while(i < inputString.length()){
                        if(inputString.charAt(i) == ' ' && i < inputString.length() - 1){
                            output += Character.toUpperCase(inputString.charAt(i + 1));
                            i++;
                        } else {
                            output += inputString.charAt(i);
                        }
                        i++;
                    }

                    break;

                case 'C':
                    i = 0;
                    while(i < inputString.length()){
                        if(i == 0){
                            output += Character.toUpperCase((inputString.charAt(i)));
                        } else if(inputString.charAt(i) == ' ' && i < inputString.length() - 1){
                            output += Character.toUpperCase(inputString.charAt(i + 1));
                            i++;
                        } else {
                            output += inputString.charAt(i);
                        }
                        i++;
                    }
                    break;

                case 'M':
                    i = 0;
                    while(i < inputString.length()){
                        if(inputString.charAt(i) == ' ' && i < inputString.length() - 3){
                            output += Character.toUpperCase(inputString.charAt(i + 1));
                            i++;
                        } else {
                            output += inputString.charAt(i);
                        }

                        output = output.replaceAll(" ", "");
                        i++;
                    }
                    output += "()";
                    break;
                default:
                    break;
            }
        }

        return output;
    }

    public static void main(String[] args) {

        ArrayList<String> combinedInput = new ArrayList<>();
        int i = -1;
        for(String s: args){
            if(s.contains(";")){
                combinedInput.add(s);
                i++;
            } else {
                combinedInput.set(i,  combinedInput.get(i) + " " + s);
            }
        }

        Solution solution = new Solution();

        for(String s: combinedInput){
            System.out.println(solution.convertString(s));
        }


    }

}
