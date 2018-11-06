package com.auto.sohu.yifanshi.targetClasses;

public class Person implements Teach,Sing {
    private int money = 0;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public Sing Sing() {
        System.out.println("Singing ");
        this.money+=100;
        return this;
    }

    @Override
    public void teaching() {
        System.out.println("Teaching algorithms");
    }
}
