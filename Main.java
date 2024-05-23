package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] namesMons = {"wolf", "goblin", "ogr", "bear", "boar", "dark elf", "alien"};
        Scanner scanner = new Scanner(System.in);

        // Виведення меню з описом класів гладіаторів
        System.out.println("Види гладіаторів:");
        System.out.println("1. Gall - Має високу витривалість і силу, маленька харизма.");
        System.out.println("2. Dymakher - Має високу спритність і критичний шанс та велику харизму.");
        System.out.println("3. Thraex - Має більше хепе та середню силу, не має критичного щансу та повільниший.");

        System.out.print("Виберіть тип гладіатора: ");
        int choice = scanner.nextInt();

        Gladiator gladiator = null;
        switch (choice) {
            case 1:
                gladiator = new Gall(10, 9, 0, 7, 6, 1, 4, 6, 90, 1);
                break;
            case 2:
                gladiator = new Dymakher(8, 7, 0, 10, 7, 1, 7, 4, 60, 0);
                break;
            case 3:
                gladiator = new Thraex(8, 8, 0, 4, 7, 1, 7, 5, 110, 0);
                break;
            default:
                System.out.println("Некоректний вибір.");
                System.exit(0);
        }

        // Створення монстра
        Random rand = new Random();
        String monsterName = namesMons[rand.nextInt(namesMons.length)];
        Monster monster = new Monster(50, 10);

        System.out.println("Битва починається! Гладіатор " + gladiator.getClass().getSimpleName() + " проти " + monsterName + "!");

        while (gladiator.isAlive() && monster.isAlive()) {
            int gladiatorDamage = gladiator.attack();
            int monsterDamage = monster.attack();

            monster.defend(gladiatorDamage);
            if (monster.isAlive()) {
                gladiator.defend(monsterDamage);
            }
        }

        if (gladiator.isAlive()) {
            System.out.println("Гладіатор переміг!");
        } else {
            System.out.println("Монстр " + monsterName + " переміг!");
        }
    }
}