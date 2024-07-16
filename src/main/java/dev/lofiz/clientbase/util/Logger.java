package dev.lofiz.clientbase.util;

public final class Logger {

    public static void INFO(Object msg) {
        System.out.println("[Client/INFO] " + msg);
    }

    public static void WARN(Object msg) {
        System.out.println("[Client/WARN] " + msg);
    }

    public static void ERROR(Object msg) {
        System.out.println("[Client/ERROR] " + msg);
    }
}
