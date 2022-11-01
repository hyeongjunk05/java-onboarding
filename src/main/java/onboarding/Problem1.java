package onboarding;

import java.util.List;

class Problem1 {
    static private boolean validation(List<Integer> pobi, List<Integer> crong){
        boolean result = true;

        if ( 1 != pobi.get(1) - pobi.get(0)) {
            return false;
        } else if ( 1 != crong.get(1) - crong.get(0)) {
            return false;
        } else {
            return result;
        }
    }
    static private int sum(List<Integer> value){
        int val_1 = 0;
        int val_2 = 0;

        String[] array1 = Integer.toString(value.get(0)).split("");
        for (String val : array1) {
            val_1 = val_1 + Integer.parseInt(val);
        }

        String[] array2 = Integer.toString(value.get(1)).split("");
        for (String val : array2) {
            val_2 = val_2 + Integer.valueOf(val);
        }
        return maxScore(val_1, val_2);
    }


    static private int mul(List<Integer> value) {

        int val_1 = 1;
        int val_2 = 1;

        String[] array1 = Integer.toString(value.get(0)).split("");
        for (String val : array1) {
            val_1 = val_1 * Integer.valueOf(val);
        }

        String[] array2 = Integer.toString(value.get(1)).split("");
        for (String val : array2) {
            val_2 = val_2 * Integer.valueOf(val);
        }

        return maxScore(val_1, val_2);
    }

    static private int maxScore(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        boolean page = validation(pobi, crong);
        if (!page) {
            return -1;
        }

        int pobi_sum_score = sum(pobi);
        int pobi_mul_score = mul(pobi);

        int pobi_max_score = maxScore(pobi_sum_score, pobi_mul_score);

        int crong_sum_score = sum(crong);
        int crong_mul_score = mul(crong);

        int crong_max_score = maxScore(crong_sum_score, crong_mul_score);

        if (pobi_max_score > crong_max_score) {
            return 1;
        } else if (pobi_max_score < crong_max_score) {
            return 2;
        } else if ( pobi_max_score == crong_max_score) {
            return 0;
        }else {
            return -1;
        }


    }
}







/*
package onboarding;

import java.util.List;

import java.util.ArrayList;
import java.util.Collections;


class Problem1 {
    static private boolean validation(List<Integer> pobi, List<Integer> crong){
        boolean result = true;

        if ( 1 != Math.abs(pobi.get(0) - pobi.get(1))) {
            return false;
        } else if ( 1 != Math.abs(crong.get(0) - crong.get(1))) {
            return false;
        } else {
            return result;
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        //pobi = new ArrayList<>();
        //crong = new ArrayList<>();

        boolean page = validation(pobi, crong);
        if (!page) {
            return -1;
        }


/*
        public static int output;(pobi, crong;){

        }

        Problem1 resultp = new Problem1();
        Problem1 resultc = new Problem1();
        int a = resultp.output();
        int b = resultc.output();

//////////////////////////////////////////////////////////////////////////
        int pobiPickNum = (int)(Math.random()*(398-3+1)) + 3;

        if (pobiPickNum % 2 == 1) {
            pobi.add(pobiPickNum);
            pobi.add(pobiPickNum+1);
        }else {
            pobi.add(1, pobiPickNum);
            pobi.add(0, pobiPickNum-1);
        }

        // pobi의 배열에서 덧셈, 곱셈 한 것 중 max 선택하여 저장.
        int pobiAddNum = 0;
        int pobiMulNum = 1;
        String to;
        int toNum = 0;
        ArrayList<Integer> wholeNumber = new ArrayList<>();


        for (int i = 0 ; i < pobi.size(); i++) {
            to = Integer.toString(pobi.get(i));

            //System.out.println(to.length()); // 문자열에서 .length 사용.
            for ( int j = 0 ; j < to.length(); j++) {
                toNum = Integer.parseInt(to.substring(j, j+1));
                pobiAddNum += toNum;
                pobiMulNum *= toNum;

                // 각각의 자릿수 들을 더해준 수와, 곱해준 수 작성.
            }
            wholeNumber.add(pobiAddNum);
            wholeNumber.add(pobiMulNum);
            pobiAddNum = 0;
            pobiMulNum = 1;
        }
        int max = Collections.max(wholeNumber);

/////////////////////////////////////////////////////////////////////////////////////

        int max2 = Collections.max(wholeNumber);

        if (max > max2) {
            answer = 1;
        }else if (max < max2){
            answer = 2;
        }else if (max == max2) {
            answer = 0;
        }else {
            answer = -1;
        }
        return answer;


    }
}
*/