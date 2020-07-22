package app.algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JMapTest {

    public static void main(String[] args) {
        Map<String,String> jm = new HashMap<>();
        jm.put("1","11");
        jm.put("2","22");
        jm.put("3","11");
        jm.put("4","44");
        jm.put("5","55");

        System.out.println(jm.containsValue("11"));
        Optional<String> ss =  jm.entrySet().stream().filter(e -> e.getValue().equals("11")).map(e -> e.getKey()).findFirst();

        System.out.println(ss.get());

    }
}
