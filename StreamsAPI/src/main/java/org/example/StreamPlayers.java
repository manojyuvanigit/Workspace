package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class StreamPlayers {

    public void thirdRankPlayer(){
        HashMap<String,Integer> playerMap = new HashMap<String,Integer>();

        playerMap.put("Alpha",40);
        playerMap.put("Beta",50);
        playerMap.put("Gamma11",60);
        playerMap.put("Delta11",70);
        playerMap.put("Epsilon11",80);
        playerMap.put("Epsilon122",100);

        Optional<Map.Entry<String, Integer>> result = playerMap.entrySet().stream().filter(a -> a.getKey().length() > 5 && a.getValue() > 50).sorted(Map.Entry.comparingByValue())
                .skip(2).findFirst();

        System.out.println(result.get());
    }
}
