package org.example;
import java.util.Random;

public class Monster {
    private int health;
    private int attackDamage;

    public Monster(int health, int attackDamage) {
        this.health = health;
        this.attackDamage = attackDamage;
    }

    public int attack() {
        Random rand = new Random();
        int damage = rand.nextInt(attackDamage) + 1;
        return damage;
    }

    public void defend(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public boolean isAlive() {
        return health > 0;
    }
}