package main.codetests;

import java.util.Arrays;
import java.util.Scanner;

public final class RaceQ1 {

    static Scanner scan = new Scanner(System.in);
    static int[] zebras = new int[1];
    static int[] horses = new int[1];
    static boolean repeat = true;
    static boolean exit = true;
    static String decision;
    static int raceOrScore;

    private RaceQ1() {
        throw new AssertionError("this private constructor is suppressed");
    }

    static void race(){
        System.out.println("Who many laps do you wanna go?");
        int horseOrZebra = scan.nextInt();
        scan.nextLine();

        int horse = 0;
        int zebra = 0;
        int position = 0;

        for (int i = 0; i < horseOrZebra; i++){
            int horses = (int) (Math.random() * 2 + 1);
            int zebras = (int) (Math.random() * 4 + 1);

            horse = horse + horses;
            zebra = zebra + zebras;

            System.out.println("The race is off");
            System.out.println();
        }

        System.out.println("The horse did: " + horse + " laps");
        System.out.println("The zebra id: " + zebra + " laps");

        if (horse > zebra) {
            System.out.println("Horse wins");
            horses[position] = horse;
            numZebraVictories();
        } else if (horse < zebra) {
            System.out.println("Zebra wins");
            zebras[position] = zebra;
            numZebraVictories();
        } else {
            System.out.println("Draw");
        }

        System.out.println();
        System.out.println("Continue (yes/no)");
        choice();
    }

    public static void numZebraVictories() {

        Arrays.sort(horses);
        Arrays.sort(zebras);

        System.out.println();
        System.out.println("Results for horse vs zebra");
        System.out.println("==========");

        for (int i = horses.length - 1; i >= 0; i--) {
            System.out.println("Horse: " + horses[i] + " laps");
        }

        for (int i = zebras.length - 1; i >= 0; i--) {
            System.out.println("Zebra: " + zebras[i] + " laps");
        }

    }
    static void menu() {
        System.out.println("\n======================================");
        System.out.println("              Main Menu             ");
        System.out.println("======================================");
        System.out.println("1. Horse VS Zebra");
        System.out.println("2. HighScore");
        System.out.println("0. Exit");

        System.out.println("\nMake your choice");
        raceOrScore = scan.nextInt();
        scan.nextLine();

        switch (raceOrScore) {

            case 0:
                System.out.println("Exit? (yes/no)");
                options();
                repeat = false;
                System.out.println("Exiting the game now...");
                break;

            case 1:
                System.out.println("Welcome to Horse vs Zebra Race");
                race();
                break;

            case 2:
                numZebraVictories();
                System.out.println();
                System.out.println("Press Enter to show menu");
                scan.nextLine();
                menu();
                break;

            default:
                System.out.println("Invalid Choice!");
        }
    }
    static void options() {

        while (exit) {
            decision = scan.nextLine();

            if (decision.equalsIgnoreCase("no")) {
                exit = false;
                menu();
            } else if (decision.equalsIgnoreCase("yes")) {
                exit = false;
            }
        }
    }

    static void choice() {

        boolean choice = true;

        while (choice) {
            decision = scan.nextLine().toLowerCase();

            switch (decision) {
                case "no":
                    choice = false;
                    menu();
                    break;
                case "yes":
                    if (raceOrScore == 1)
                        race();
                    break;
                default:
                    choice = false;
                    System.out.println("An error has occurred...");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        while(repeat){
            menu();
        }
    }
}