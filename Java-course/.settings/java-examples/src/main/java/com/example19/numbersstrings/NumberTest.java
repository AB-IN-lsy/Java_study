package com.example19.numbersstrings;

public class NumberTest {
    public static void main(String[] args) {
        System.out.println("-------Integer--------");
        getInteger();
        System.out.println("-------Math--------");
        getMath();
        System.out.println("-------Random--------");
        getMathRandom();
        System.out.println("-------Performance Testing--------");
        // testPerformance();

    }

    private static void getInteger() {
        Integer num =  Integer.valueOf(102);
        /**
         * 整形的包装类的对象
         */
        Integer num2 = Integer.valueOf("102");
        /**
         * Integer.valueof()为静态方法，此为将string转换为int,并装箱,装箱操作
         */
        double d = num.doubleValue();
        /**
         * 这个为将int转换为double
         * 类似的还有int n = num.intValue() 相当于拆箱操作，即int转int
         */
        Integer i = 102; //自动装箱
        int num1 = i; //自动拆箱
        int n = num.intValue();
        int num3 = Integer.parseInt("102");
        /**
         * 将String转为int基本类型
         */
        System.out.println(Integer.max(10, 15));
    }

    private static void getMath() {
        double x = 10D;
        double y = 15D;
        double result = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        System.out.println(result);

        double d1 = 10.1;
        double d2 = 10.9;
        System.out.println(Math.ceil(d1) + "/" + Math.ceil(d2));
        System.out.println(Math.floor(d1) + "/" + Math.floor(d2));
        System.out.println(Math.round(d1) + "/"  + Math.round(d2));
    }

    private static void testPerformance() {
        // 拆装箱测试
        long s1 = System.nanoTime();
        Integer i1 = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            i1 = i1 +1;
        }
        long e1 = System.nanoTime();
        System.out.println(e1 - s1);
        // 基本类型测试
        long s2 = System.nanoTime();
        int i2 = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            i2 = i2 +1;
        }
        long e2 = System.nanoTime();
        System.out.println(e2 - s2);
    }

    private static void getMathRandom() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Math.random() * 10);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println((int)(Math.random() * 10));
        }
    }
}
