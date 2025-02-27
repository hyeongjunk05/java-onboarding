package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new java.util.ArrayList<>(Collections.emptyList());
        int[] units = new int[9];
        int[] moneyUnit = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        if (!(money >= 1 && money <= 1000000)){
            System.out.println("Incorrect Input!!");
        }
        for ( int i = 0 ; i < 9 ;i++) {
            int standard = money / moneyUnit[i];
            if (standard >= 1) {
                money = money - standard*moneyUnit[i];
                units[i] = standard;
            }else {
                units[i] = 0;
            }
            answer.add(i, units[i]);
        }


        return answer;
    }
}
