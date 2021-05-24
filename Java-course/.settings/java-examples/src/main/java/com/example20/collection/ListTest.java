package com.example20.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListTest {
    private static final List<User> USERS = create();
    /**
     * 声明静态不变的集合
     * 静态：可以直接在类中引用，不用创建对象
     * 不变：使USERS的引用不变，即不能创建新的USERS
     * 集合放的是对象的引用
     * 对象依然在堆上
     *
     * 父类能待的地方子类一定能待
     * */
    private static List<User> create() {
        User u1 = new User("BO");
        User u2 = new User("SUN");
        User u3 = new User("SUN");
        List<User> users = new ArrayList<>();
        users.add(u1);
        users.add(u2);
        users.add(u3);
        return users;
    }

    public static void main(String[] args) {
        // getSize();
        // forByIndex();
        // updateElement();
        // addRepeatElement();
        // removeElement();
        // removeElementByIndex();
        // listToArray();
        // arrayToList();
        // iterator();
        // iteratorRemove();

        removeIf();
    }

    /**
     * 声明与添加元素
     */
    private static void addSubClass() {
        USERS.add(new Student());
    }

    /**
     * 基本方法
     */
    private static void getSize() {
        System.out.println(USERS.size());
        System.out.println(USERS.isEmpty());
    }

    /**
     * 基于索引的for循环
     */
    private static void forByIndex() {
        for (int i = 0; i < USERS.size(); i++) {
            System.out.println(USERS.get(i).getName());
        }
    }

    /**
     * 基于foreach循环语句
     */
    private static void forEach() {
        for (User u : USERS) {
            System.out.println(u.getName());
        }
    }

    /**
     * 更新元素
     */
    private static void updateElement() {
        User user = USERS.get(0);
        user.setName("ZHANG");
        for (User u : USERS) {
            System.out.println(u.getName());
        }
    }

    /**
     * 添加重复元素
     */
    private static void addRepeatElement() {
        User user = USERS.get(0);
        USERS.add(user);
        for (User u : USERS) {
            System.out.println(u.getName());
        }
        //重复元素地址相同
    }

    /**
     * 基于属性值，判断移除元素
     */
    private static void removeElement() {
        for (User u : USERS) {
            if ("BO".equals(u.getName())) {
                USERS.remove(u);
            }
        } //foreach情况下不允许改变集合长度，会异常

        for (User u : USERS) {
            System.out.println(u.getName());
        }
    }

    /**
     * 通过基本for循环。基于属性值，判断移除元素
     */
    private static void removeElementByIndex() {
        for (int i = 0; i < USERS.size(); i++) {
            if ("SUN".equals(USERS.get(i).getName())) {
                USERS.remove(i);
                //下标变了，故可能删不完
            }
        }
        for (User u : USERS) {
            System.out.println(u.getName());
        }
    }


    /**
     * 集合转数组
     */
    private static void listToArray() {
        User[] users = USERS.toArray(new User[0]);
        for (User u : users) {
            System.out.println(u.getName());
        }
    }

    /**
     * 数组转集合，有问题
     */
    private static void arrayToList() {
        User[] users = USERS.toArray(new User[0]);

        List<User> userList = Arrays.asList(users);
        userList.add(new User());
        for (User u : userList) {
            System.out.println(u.getName());
        }
    }

    /**
     * 迭代器
     */
    private static void iterator() {
        Iterator<User> iUsers = USERS.iterator();
        while (iUsers.hasNext()) {
            User u = iUsers.next();
            System.out.println(u.getName());
        }
    }

    /**
     * 迭代器移除
     */
    private static void iteratorRemove() {
        Iterator<User> iUsers = USERS.iterator(); //相当于一个游标
        while (iUsers.hasNext()) {
            User u = iUsers.next(); //返回游标对应的值
            if ("SUN".equals(u.getName())) {
                iUsers.remove();
            }
        }

        for (User u : USERS) {
            System.out.println(u.getName());
        }
    }

    private static void removeIf() {
        USERS.removeIf(u -> "SUN".equals(u.getName())); // "->" 相当于 "if"

        for (User u : USERS) {
            System.out.println(u.getName());
        }
    }

}
