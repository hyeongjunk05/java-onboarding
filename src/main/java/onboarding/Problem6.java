package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new java.util.ArrayList<>(java.util.Collections.emptyList());

        String email = "@email.com";

        if (!(forms.size() >= 1 && forms.size() <= 10000)){
           System.out.println("Incorrect Input!!"); // 실제로는 여기서 코드 진행 멈추고 재입력을 요구하면 됨.
        }

        for (List<String> form : forms) {
            String emailAddress = form.get(0);
            if (11 <= emailAddress.length() && emailAddress.length() < 20) {
                if (emailAddress.substring(emailAddress.length() - 10, emailAddress.length()).equals(email)) {
                } else {
                    System.out.println("Use \"@email.com\" Domain Only!!");
                }
            } else {
                System.out.println("Incorrect email length Input!!");
            }
        }

        for (int i = 0 ; i < forms.size(); i++) {
            if (i == forms.size()-1)
                break;
            String nick = forms.get(i).get(1); // word 1
            if (1 <= nick.length() && nick.length() < 20) {
                String onlyKorean = "^[가-힣]*$";
                boolean regex = java.util.regex.Pattern.matches(onlyKorean, nick);
                if (regex) {
                    for (int j = 1+i; j < forms.size(); j++) {
                        String secondNick = forms.get(j).get(1); // word 2
                        for (int k = 0; k < nick.length()-1; k++){ // 닉네임이 1글자일때는 카바 못침.
                            String duplicatedWords = nick.substring(k, k+2);
                            if (secondNick.contains(duplicatedWords)) {
                                answer.add(forms.get(i).get(0));
                                answer.add(forms.get(j).get(0));
                            }
                        }
                    }
                } else {
                    System.out.println("Use only Korean nickname!!");
                }
            } else {
                System.out.println("Incorrect nickname length Input!!");
            }
        }
        java.util.Set<String> set = new java.util.HashSet<>(answer);
        List<String> list = new java.util.ArrayList<>(set);
        java.util.Collections.sort(list);
        return list;
    }
}
