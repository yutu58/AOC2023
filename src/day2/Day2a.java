package day2;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static java.lang.System.exit;

public class Day2a {
    public static void main(String[] args) {
        String day = "2";
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



    public static int solve(String input) {
        int res = 0;

        int totalRed = 12;
        int totalGreen = 13;
        int totalBlue = 14;

        String[] arr = input.split("\n");
        for (String s : arr) {
            String[] split1 = s.split(": ");
            int gameId = parseInt(split1[0].split(" ")[1]);
            String[] split2 = split1[1].split("; ");
            boolean possible = true;
            for (String q : split2) {
                q = q.trim();
                int red = 0;
                int blue = 0;
                int green = 0;
                String[] split3 = q.split(", ");
                for (String r : split3) {
                    String[] split4 = r.split(" ");
                    if (split4[1].equals("red")) red += parseInt(split4[0]);
                    if (split4[1].equals("blue")) blue += parseInt(split4[0]);
                    if (split4[1].equals("green")) green += parseInt(split4[0]);
                }


                if (red > totalRed) possible = false;
                if (blue > totalBlue) possible = false;
                if (green > totalGreen) possible = false;
            }
            if (possible) {
                res += gameId;
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