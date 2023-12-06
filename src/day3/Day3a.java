package day3;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.lang.System.exit;

public class Day3a {
    public static void main(String[] args) {
        String day = "3";
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
        String[] arr = input.strip().split("\n");
        int height = arr.length;
        int width = arr[0].strip().length();

        long res = 0;

        for (int i = 0; i < height; i++) {
            int buff = 0;
            int first = -1;
            int last = -1;
            for (int j = 0; j < width; j++) {
                char k = arr[i].charAt(j);
                if (Character.isDigit(k)) {
                    buff = buff * 10 + parseInt(k);
                    if (first == -1) {
                        first = j;
                    }
                    last = j;
                }

                if (buff != 0 && (!Character.isDigit(k) || j == width-1)) {
                    boolean valid = false;
                    for (int y = first-1; y <=last+1; y++) {
                        for (int z = i-1; z <= i+1; z++) {
                            try {
                                if(arr[z].strip().charAt(y) != '.' && !Character.isDigit(arr[z].charAt(y))) valid = true;
                            } catch (Exception e) {
                                //Out of bounds
                            }
                        }
                    }
                    if (valid) res += buff;
                    if (valid) System.out.println(buff);
                    first = -1;
                    last = -1;
                    buff = 0;
                }
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