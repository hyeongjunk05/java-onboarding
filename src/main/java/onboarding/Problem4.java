package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Problem4 {
    public static String solution(String word) {
        String pattern = "^[a-zA-Z ]*$"; //소문자만 + 띄어쓰기도 저렇게 공란으로 해줬어야 함. ㄷㄷㄷㄷㄷ
        boolean onlyEnglish = Pattern.matches(pattern, word);

        if (word.length() >= 1 && word.length() <= 1000 && onlyEnglish) {
            return theAnswer(word);
        }else {
            return "Input Again";
        }
    }

    public static String theAnswer(String word) {
        // 이 함수에서 알파벳 대문자는 대문자로, 소문자는 소문자로 변환하기만 하면 됨

        String[] wordList = word.split("");

        String oreum = "AaBbCcDdEeFfGgHhIiJjKkLlMm nNoOpPqQrRsStTuUvVwWxXyYzZ";
        String[] oreumArray = oreum.split("");
        List<String> oreumList = Arrays.asList(oreumArray);

        StringBuilder finalString = new StringBuilder();

        for (String s : wordList) {
            for (int j = 0; j < oreumList.size(); j++) {
                if (s.equals(oreumList.get(j))) {
                    finalString.append(oreumList.get(oreumList.size() - 1 - j));
                }
            }

        }
        return finalString.toString();
    }
}

