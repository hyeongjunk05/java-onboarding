package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        String pattern = "^[a-z]*$"; //소문자만
        boolean regex = Pattern.matches(pattern, cryptogram);

        String[] tempArray = cryptogram.split("");
        List<String> tempList = Arrays.asList(tempArray);

        if ( cryptogram.length() > 1000 || cryptogram.length() == 0) {
            return "input again";
        } else if (!regex) {
            return "input again";
        } else {

            boolean check = true;
////////////////////////////////////////////////////////////////////////
            while (check) {
                check = false;
                List<String>  curList = new ArrayList<>();
                curList.addAll(tempList);

                for (int i = 0; i < tempList.size()-1; i++ ){ // 이 tempLength도 문자열에서 리스트 용인 .size()로 바꾸자
                    if (tempList.get(i).equals(tempList.get(i + 1))){
                        curList.remove(i+1);
                        curList.remove(i);
                        tempList = curList;
                        check = true;
                        break;
                    }
                }

            }
////////////////////////////////////////////////////////////////////////
            StringBuilder sb = new StringBuilder();
            for (String s: tempList){
                sb.append(s);
            }
            answer = sb.toString();
            return answer;
        }


    }
}
