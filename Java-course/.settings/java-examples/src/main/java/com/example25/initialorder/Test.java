package com.example25.initialorder;

public class Test {

    public static void main(String[] args) {
        // A.getS();
        /**
         * A: static block
         * A: static method create()
         * A: static block 2
         * A: static method getS()
         * */
         // new A();
         /**
          * A: static block
          * A: static method create()
          * A: static block 2
          * A: constructor
          * */
        // new B();
        /**
         * A: static block
         * A: static method create()
         * A: static block 2
         * B: static block
         * A: constructor
         * B: Constructor
         * */
        // B.getB();
        // new C(new A());
        // new C();
        /**
         * C: static block
         * C: constructor
         * 只private A a = null; 没有new A(),故不加载A类
         */
    }

    /**
     * 调用1次A.get()方法
     * 调用2次A.get()方法
     * 类A，头尾添加static块
     * 类A，static块调整顺序
     *
     * 类A，追加构造函数，调用A.get()方法
     * 创建类A对象
     *
     * 创建类B对象
     * 调用B.getB()方法
     *
     * 创建类C对象
     * 类C中属性A，创建初始化对象
     */

}
