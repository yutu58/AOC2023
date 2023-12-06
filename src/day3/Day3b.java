package day3;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.exit;

public class Day3b {
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
        HashMap<Integer, Long> res = new HashMap<>();

        String[] arr = input.strip().split("\n");
        int height = arr.length;
        int width = arr[0].strip().length();

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
                    for (int y = first-1; y <=last+1; y++) {
                        for (int z = i-1; z <= i+1; z++) {
                            try {
                                if(arr[z].strip().charAt(y) == '*') {
                                    int index = y*1000 + z;
                                    if (res.containsKey(index)) {
                                        if (res.get(index) < 0) {
                                            res.put(index, res.get(index) * -1);
                                        }
                                        res.put(index, res.get(index) * buff);
                                    } else {
                                        res.put(index, (long) buff * -1);
                                    }
                                }
                            } catch (Exception e) {
                                //Out of bounds
                            }
                        }
                    }
                    //Reset counters
                    first = -1;
                    last = -1;
                    buff = 0;
                }
            }
        }
        long result = 0;
        for (Map.Entry<Integer, Long> entry : res.entrySet()) {
            long c = entry.getValue();
            if (c > 0) result += c;
        }
        return result;
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