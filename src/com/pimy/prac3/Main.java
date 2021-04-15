package com.pimy.prac3;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("First task");
        HashMap<String, Integer> firstTaskData = new HashMap<>();
        firstTaskData.put("Nice", 942208);
        firstTaskData.put("Abu Dhabi", 1482816);
        firstTaskData.put("Naples", 2186853);
        firstTaskData.put("Vatican City", 572);
        System.out.println(millionsRounding(firstTaskData));

        System.out.println("Second task");
        System.out.println(Arrays.toString(otherSides(1)));

        System.out.println("Third task");
        System.out.println(rps("rock", "paper"));
        System.out.println(rps("paper", "rock"));
        System.out.println(rps("paper", "scissors"));

        System.out.println("Fourth task");
        System.out.println(warOfNumbers(new int[]{2, 8, 7, 5}));
        System.out.println(warOfNumbers(new int[]{12, 90, 75}));
        System.out.println(warOfNumbers(new int[]{5, 9, 45, 6, 2, 7, 34, 8, 6, 90, 5, 243}));

        System.out.println("Fifth task");
        System.out.println(reverseCase("Happy Birthday"));

        System.out.println("Sixth task");
        System.out.println(inatorInator("Shrink"));
        System.out.println(inatorInator("Doom"));
        System.out.println(inatorInator("EvilClone"));

        System.out.println("Seventh task");
        System.out.println(doesBrickFit(1, 1, 1, 1, 1));
        System.out.println(doesBrickFit(1, 2, 1, 1, 1));
        System.out.println(doesBrickFit(1, 2, 2, 1, 1));

        System.out.println("Eighth task");
        System.out.println(totalDistance(70.0, 7.0, 0, false));
        System.out.println(totalDistance(36.1, 8.6, 3, true));
        System.out.println(totalDistance(55.5, 5.5, 5, false));

        System.out.println("Ninth task");
        System.out.println(mean(new int[]{1, 0, 4, 5, 2, 4, 1, 2, 3, 3, 3}));

        System.out.println("Tenth task");
        System.out.println(parityAnalysis(243));
    }

    public static HashMap<String, Integer> millionsRounding(HashMap<String, Integer> cities){
        for (HashMap.Entry<String, Integer> item : cities.entrySet()) {
            item.setValue(
                    (int) (Math.round(item.getValue() / 1000000.0) * 1000000)
            );
        }
        return cities;
    }

    public static double[] otherSides(int side){
        return new double[]{
                side * 2.0,
                Math.round(side * Math.sqrt(3) * 100) / 100.0
        };
    }

    public static String rps(String p1_word, String p2_word){
        ArrayList<String> input = new ArrayList<>();
        input.add(p1_word);
        input.add(p2_word);

        HashMap<HashSet<String>, String> rules = new HashMap<>();
        rules.put(new HashSet<>(Arrays.asList("paper", "rock")), "paper");
        rules.put(new HashSet<>(Arrays.asList("scissors", "paper")), "scissors");
        rules.put(new HashSet<>(Arrays.asList("rock", "scissors")), "rock");

        String winnerWord = rules.get(new HashSet<>(input));
        return "Player " + (input.indexOf(winnerWord) + 1) + " wins";
    }

    public static int warOfNumbers(int[] numbers){
        int evenNumbersSum = 0;
        int oddNumbersSum = 0;
        for (Integer number : numbers){
            if (number % 2 == 0) { evenNumbersSum += number; } else { oddNumbersSum += number; }
        }

        return Math.abs(evenNumbersSum - oddNumbersSum);
    }

    public static String reverseCase(String str){
        String result = "";
        for (Character chr : str.toCharArray()){
            if (chr == Character.toUpperCase(chr)) {
                result += Character.toLowerCase(chr);
            } else {
                result += Character.toUpperCase(chr);
            }
        }

        return result;
    }

    public static String inatorInator(String str){
        String cons = "bcdfghjklmnpqrstvwxyz";
        String prefix = "";
        if (!cons.contains(str.substring(str.length() - 1))){
            prefix = "-";
        }

        return str + prefix + "inator " + str.length() + "000";
    }

    public static boolean doesBrickFit(int a, int b, int c, int w, int h){
        return (a <= w && b <= h) || (a <= h && b <= w) || (a <= w && c <= h) || (c <= w && b <= h);
    }

    public static double totalDistance(double fuel, double cons, int passengers, boolean air){
        double result = fuel / (cons * (1 + ((passengers * 5) / 100.0)) * (air ? 1.1 : 1)) * 100;
        return Math.round(result * 100) / 100.0;
    }

    public static double mean(int[] numbers){
        double sum = 0;
        for (int i = 0; i < numbers.length; i++){
            sum += numbers[i];
        }
        return Math.round(sum / numbers.length * 100) / 100.0;
    }

    public static boolean parityAnalysis(int number){
        int sum = 0;
        int sourceNumber = number;
        while (number > 0){
            sum += number % 10;
            number = number / 10;
        }
        return (sum % 2 == sourceNumber % 2);
    }
}
