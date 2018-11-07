package pl.maniaq;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) {
        // immutables keys
        User user1 = new User("Pablo");
        User user2 = new User("Ugot");

        Key key1 = new Key(1);
        Key key2 = new Key(2);

        Map<Key, User> users = new HashMap<>();
        users.put(key1, user1);
        users.put(key2, user2);

        System.out.println("Przed zmiana - klucz: " + key1 + ", user: " + users.get(key1));
        key1.setId(3);
        System.out.println("Po zmianie - klucz: " + key1 + ", user: " + users.get(key1));


        //Overide value by exist key

        Map<Long, String> names = new HashMap<>();
        names.put(1l, "Kamil");

        System.out.println("Mapa przed nadpisaniem: " + names);

        names.put(1l, "Pablo");
        System.out.println("Mapa po nadpisaniu: " + names);

        //Concurrent map
        Map<String, String> countries = new ConcurrentHashMap<>();
        countries.put("PL", "Poland");
        countries.put("FR", "France");
        countries.put("IT", "Italy");
        System.out.println("Concurrent map: " + countries);

        //Enum map
        Map<Color, String> colors = new HashMap<>();
        colors.put(Color.BLUE, "niebieski");

        Map<Color, String> enumColors = new EnumMap<>(Color.class);
        enumColors.put(Color.RED, "czerwony");

        System.out.println("Zwykła mapa kolorow: " + colors);
        System.out.println("Enum mapa kolorow: " + enumColors);

        // Map of lists
        List<String> mathStudents = new LinkedList<>(Arrays.asList("Pablo", "Escabo"));
        List<String> physStudents = new LinkedList<>(Arrays.asList("Horty", "Tero", "Pelo"));

        Map<String, List<String>> university = new HashMap<>();
        university.put("Matematyka", mathStudents);
        university.put("Fizyka", physStudents);

        // Iterate through map
        for(String key : countries.keySet()) {
            System.out.println("Key: " + key + ", value: " + countries.get(key));
        }

        for(Map.Entry<String, String> entry : countries.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", value: " + entry.getValue());
        }

        // No keep ordering of elements
        Map<User, Integer> orderMap = new HashMap<>();
        for(int i=0;i<20;i++) {
            orderMap.put(new User("Test" + String.valueOf(i)), i);
        }

        System.out.println("Order map: " + orderMap);




    }
}
