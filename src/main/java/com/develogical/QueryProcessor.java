package com.develogical;

import java.util.Arrays;

public class QueryProcessor {

    public String process(String query) {
        if (query.contains("programming")) {
            return "Computer programming is the comprehensive process that leads from an original " 
                   + "formulation of a computing problem to executable programs.";
        }
        if(query.contains("which")){
            String[] parts = query.split(":");
            String numbers = parts[2].trim();
            String[] listNumber = numbers.split(",");
            Integer[] ListNumberInt = new Integer[listNumber.length];
            for(int i =0 ; i< listNumber.length;i++){
                ListNumberInt[i] = Integer.parseInt(listNumber[i].trim());
            }

            Arrays.sort(ListNumberInt);
            return ListNumberInt[ListNumberInt.length-1].toString();

        }
        if(query.contains("what")){
            String[] Parts = query.split(" ");
            Integer result = Integer.parseInt(Parts[3]) + Integer.parseInt(Parts[5]);
            return result.toString();
        }

        return "";
    }
}
