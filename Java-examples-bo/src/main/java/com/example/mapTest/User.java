package com.example.mapTest;
import java.util.*;

public class User {
    private int id;
    private String name;
    private String city;
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    private static void toMap(Set<User> users) {
        Map<String, List<User>> map = new HashMap<>();
        for(User user : users){
            String city = user.getCity();
            /**
             * if(map.get(city) != null){
             *    map.get(city).add(user);
             * }
             * else{
             *     map.put(city, new ArrayList<User>(){{add(user);}});
             * }
             * */
            List<User> list = map.getOrDefault(city, new ArrayList<User>());
            list.add(user);
            map.put(city, list);
        }
        for(String key : map.keySet()){
            System.out.print(String.format("%s: ", key));
            for(User user : map.get(key)){
                System.out.print(String.format("%s ", user.getName()));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Set<User> users = new HashSet<>();
        users.add(new User(1, "Lby", "Beijing"));
        users.add(new User(2, "Lsy", "Harbin"));
        users.add(new User(3, "Yb", "Harbin"));
        users.add(new User(4, "Dyy", "Macao"));
        User.toMap(users);
    }
}


