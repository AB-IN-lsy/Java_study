package com.example23.optional;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        // ifPresent(null);
        // map(null);
        // or(new USB("3.0"));
        // getVersion2(new Computer(new Soundcard(new USB("3.0"))));
        // filter(new USB("UNKNOWN"));
        orElse(new USB("UNKNOWN"));
    }

    /**
     *
     * @param com
     * @return
     */
    public static String getVersion0(Computer com) {
        String v = com.getSoundcard().getUsb().getVersion();
        return v == null ? "UNKNOWN" : v;
    }

    /**
     * 冗余代码
     *
     * @param com
     * @return
     */
    private static String getVersion1(Computer com) {
        String version = "UNKNOWN";
        if (com != null) {
            Soundcard soundcard = com.getSoundcard();
            if (soundcard != null) {
                USB usb = soundcard.getUsb();
                if (usb != null) {
                    version = usb.getVersion();
                }
            }
        }
        return version;
    }

    /**
     * 打印传入的usb版本。传入的usb对象可能为空
     * 仅不为空执行，执行时既然可能空引用
     * @param usb
     */
    private static void ifPresent(USB usb) {
        Optional<USB> usbOP = Optional.ofNullable(usb);
        usbOP.ifPresent(u -> System.out.println(u.getVersion()));
        //参数为函数, 容器里有的话执行

        Optional.ofNullable(usb)
                // 若USB不空，则执行
                .ifPresent(u -> System.out.println(u.getVersion()));
        System.out.println("dfsf");
        Optional.ofNullable(new Computer())
                .ifPresent(c -> System.out.println(c.getSoundcard().getUsb()));
        //还是会抛异常
    }


    /**
     * java9
     */
    private static void ifPresentOrElse(USB usb) {
        Optional.ofNullable(usb)
                .ifPresentOrElse(u -> System.out.println(u.getVersion()),
                        () -> System.out.println("CF"));
        /**当容器不为空时执行第一个函数；为空执行第二个函数(空变量函数)
         */
    }

    /**
     * 如果版本为3.0打印，否则不执行操作
     * 容器为空，返回空容器；容器不为空，执行过滤；
     * 符合条件，将对象置于新容器，不符合条件，返回空容器
     */
    private static void filter(USB usb) {
        Optional.ofNullable(usb)
                .filter(u -> "3.0".equals(u.getVersion()))
                .ifPresent(u -> System.out.println(u.getVersion()));
    }

    /**
     * 基于map映射usb版本，打印
     * 无论是否匹配，均返回一个容器，用于后续操作，和filter一样
     * @param usb
     */
    private static void map(USB usb) {
        Optional.ofNullable(usb)
                .map(USB::getVersion)
                //容器为空，返回相同类型的空容器
                .ifPresent(System.out::println);
    }

    /**
     * 打印版本
     * 为UNKNOWN，创建一个1.1版本usb
     * 不为UNKNOWN，直接打印
     */
    private static void or(USB usb) {
        Optional.of(usb)
                .filter(u -> !"UNKNOWN".equals(u.getVersion()))
                /**
                 * 过滤出不是UNKNOWN的
                */
                .or(() -> {
                    return Optional.of(new USB("1.1")); // 容器为空则执行，且必须返回一个，相同类型的容器，可以为空容器
                })
                .ifPresent(u -> System.out.println(u.getVersion()));

    }

    /**
     * 如果usb为空，创建usb 1.1
     * 获取版本
     *
     * @param usb
     */
    private static void orElse(USB usb) {
        String v1 = Optional.ofNullable(usb)
                .orElseGet(() -> {
                    return new USB("1.1"); // 参数为函数
                }).getVersion();
        System.out.println(v1);

        String v2 = Optional.ofNullable(usb)
                .orElse(new USB("1.1"))
                // 参数为对象，无论是否为空，均创建默认对象
                .getVersion();
        System.out.println(v2);

    }

    private static void Get(USB usb) {
        String v = Optional.ofNullable(usb)
                .or(() -> {
                    System.out.println("怎么会没有呢");
                    return Optional.of(new USB("1.1"));
                })
                .get()
                .getVersion();
    }

    /**
     * 获取Computer的usb版本
     * @param com
     */
    private static void getVersion2(Computer com) {
        String v = Optional.ofNullable(com)
                .map(Computer::getSoundcard)
                .map(Soundcard::getUsb)
                .map(USB::getVersion)
                .orElse("UNKNOWN");
        System.out.println(v);
    }

}
