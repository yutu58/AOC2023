package day1;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

import static java.lang.System.exit;

public class Day1b {
    public static void main(String[] args) {
        String day = "1";
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

    static HashMap<String, Integer> values = new HashMap<>() {{
        put("one", 1);
        put("two", 2);
        put("three", 3);
        put("four", 4);
        put("five", 5);
        put("six", 6);
        put("seven", 7);
        put("eight", 8);
        put("nine", 9);
        put("zero", 0);
    }};

    public static int solve(String input) {
        String[] list = input.split("\n");
        int total = 0;
        for (String s : list) {
            int firstInt = -1;
            int lastInt = -1;
            String sofar = "";
            for (int i = 0; i < s.length(); i++) {
                char a = s.charAt(i);
                //Not nice :(
                sofar += a;

                int intval = -1;

                for (String t : values.keySet()) {
                    if (sofar.endsWith(t)) {
                        intval = values.get(t);
                    }
                }

                if (Character.isDigit(a) && intval == -1) {
                    intval = parseInt(a);
                }

                if (intval != -1) {
                    if (firstInt == -1) firstInt = intval;
                    lastInt = intval;
                }
            }
            total += firstInt*10 + lastInt;
        }
        return total;
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