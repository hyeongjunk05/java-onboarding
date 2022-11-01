package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Set<String> set = new HashSet<>();
        Set<String> alreadyFriend = new HashSet<>();

        ArrayList<ArrayList<String>> friendsCopy = new ArrayList<>();


        ArrayList<String> forms1 = new ArrayList<>();
        ArrayList<String> forms2 = new ArrayList<>();
        ArrayList<String> forms3 = new ArrayList<>();
        ArrayList<String> forms4 = new ArrayList<>();
        ArrayList<String> forms5 = new ArrayList<>();
        ArrayList<String> forms6 = new ArrayList<>();

        forms1.add("donut");
        forms1.add("andole");
        friendsCopy.add(forms1);

        forms2.add("donut");
        forms2.add("jun");
        friends.add(forms2);

        forms3.add("donut");
        forms3.add("mrko");
        friends.add(forms3);

        forms4.add("shakevan");
        forms4.add("andole");
        friends.add(forms4);

        forms5.add("shakevan");
        forms5.add("jun");
        friends.add(forms5);

        forms6.add("shakevan");
        forms6.add("mrko");
        friends.add(forms6);


        for (List<String> var : friends) {
            set.add(var.get(0));
            set.add(var.get(1));
            for (int i = 0; i < 2; i++) {
                if (user == var.get(i)) {
                    alreadyFriend.add(var.get(1 - i));
                    friendsCopy.remove(var); //
                }
            }
        }
        List<String> candidateList = new ArrayList<>();
        for (String var : alreadyFriend) {
            for (int j = 0; j < 2; j++) {
                for (List<String> strings : friendsCopy)
                    if (var == strings.get(j)) {
                        candidateList.add(strings.get(1 - j));
                    }
            }
        }
        set.remove(user);
        List<String> alreadyFriends = new ArrayList<>(alreadyFriend);
        set.remove(alreadyFriends.get(0)); // 이제 이 set의 대상들로만 점수 매기고,,,추천 점수 따라 내림차순 정렬,,, 추천점수 같으면, 이름 기반 오름차순 정렬해서 return
        set.remove(alreadyFriends.get(1));

        java.util.HashMap<String, Integer> map = new java.util.HashMap<>();
        for (String s : candidateList) {
            if (map.containsKey(s)) {
                int tempValue = map.get(s);
                map.put(s, tempValue + 10);
                continue;
            }
            map.put(s, 10);
        }

        List<String> visitorsTemp = new ArrayList<>(visitors);
        visitorsTemp.remove(alreadyFriends.get(0));
        visitorsTemp.remove(alreadyFriends.get(1));

        for (String visitor : visitorsTemp) {
            if (map.containsKey(visitor)) {
                int tempvalue2 = map.get(visitor);
                map.put(visitor, tempvalue2 + 1);
                continue;
            }
            map.put(visitor, 1);
        }
        ArrayList<String> keySetList = new ArrayList<>(map.keySet());
        keySetList.sort((o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

        return keySetList;//
    }
}
