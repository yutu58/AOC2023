package day6;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.lang.System.exit;

public class Day6b {
    public static void main(String[] args) {
        String day = "6";
        String input = readFile("inputs/input" + day + ".txt").trim();

        print(solve(input));
    }

    public static String readFile(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Couldn't find path specified");
            exit(0);
            return "";
        }
    }

    public static long solve(String input) {
        String[] parts = input.strip().split("\n");
        parts[0] = parts[0].replace(" ", "");
        parts[1] = parts[1].replace(" ", "");
        String[] times = parts[0].strip().split(":");
        String[] records = parts[1].strip().split(":");

        long res = 1;

        for (int i = 1; i < times.length; i++) {
            long ways = 0;
            long time = Long.parseLong(times[i].strip());
            long record = Long.parseLong(records[i].strip());

            for (long j = 0; j <= time; j++) {
                long speed = j;
                long timeLeft = time-j;

                if ((timeLeft * speed) > record) ways++;
            }
            if (ways > 0) {
                res *= ways;
            }
        }
        return res;
    }

    public static void print(String x) {
        System.out.println(x);
    }

    public static void print(int x) {
        System.out.println(x);
    }

    public static void print(float x) {
        System.out.println(x);
    }

    public static void print(double x) {
        System.out.println(x);
    }

    public static void print(long x) {
        System.out.println(x);
    }

    public static void print(BigInteger x) {
        System.out.println(x);
    }

    public static int parseInt(char c) {
        return Character.getNumericValue(c);
    }

    public static int parseInt(String s) {
        return Integer.parseInt(s);
    }

    public static void putOnClipboard(String s) {
        StringSelection selection = new StringSelection(s);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }
}