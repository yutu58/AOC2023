package day4;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.lang.System.exit;

public class Day4a {
    public static void main(String[] args) {
        String day = "4";
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
        String[] parts = input.strip().split("\n");
        String[] times = parts[0].strip().split("\\s+");
        String[] records = parts[1].strip().split(" \\s+");

        int res = 1;

        for (int i = 1; i < times.length; i++) {
            int ways = 0;
            int time = parseInt(times[i].strip());
            int record = parseInt(records[i].strip());
            for (int j = 0; j <= time; j++) {
                int speed = j;
                int timeLeft = time-j;

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