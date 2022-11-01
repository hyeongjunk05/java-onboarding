package onboarding;

public class Problem3 {
    public static int solution(int number) {

        if ( number >= 1 && number <= 10000) {
            return times(number);
        }else {
            System.out.println("다시 입력하세요");
            return 0;
        }
         // 손뼉 횟수 return
    }

    public static int times(int number) {
        int answer = 0;
        for (int i = 1 ; i<=number; i++){

            String[] array2 = Integer.toString(i).split("");
            int sizeOfArray2 = array2.length;

            for ( int j = 0 ; j <= sizeOfArray2-1 ; j++){
                if ( array2[j].equals("3") || array2[j].equals("6") || array2[j].equals("9")) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
