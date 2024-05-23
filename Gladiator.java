package org.example;
import java.util.Random;

public class Gladiator {
    protected int constitution;
    protected int strength;
    protected int xp;
    protected int dexterity;
    protected int intelligence;
    protected int level;
    protected int charisma;
    protected int basicAttack;
    protected int basicHP;
    protected int haveShield;

    public Gladiator(int constitution, int strength, int xp, int dexterity, int intelligence, int level, int charisma, int basicAttack, int basicHP, int haveShield) {
        this.constitution = constitution;
        this.strength = strength;
        this.xp = xp;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.level = level;
        this.charisma = charisma;
        this.basicAttack = basicAttack;
        this.basicHP = basicHP;
        this.haveShield = haveShield;
    }

    public int attack() {
        Random rand = new Random();
        int damage = rand.nextInt(strength) + basicAttack;
        return damage;
    }

    public void defend(int damage) {
        if (haveShield == 1) {
            damage = damage / 2; // Якщо гладіатор має щит, він отримує на 50% менше шкоди
        }
        basicHP -= damage;
        if (basicHP < 0) {
            basicHP = 0;
        }
    }

    public boolean isAlive() {
        return basicHP > 0;
    }

    // Додайте інші методи, які можуть бути корисними для гладіаторів
}