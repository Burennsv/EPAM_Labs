package sample;

import java.util.Random;

public class Worker {
    public String name;
    public double money;
    public Worker() {
        Random rand = new Random();
        money = rand.nextInt(1500);
        Factory.SetMessage("Рабочий  нанят");
    }
    public void Work() {
        Factory.result = Factory.result + "\nРабочий  работает";
    }
    public static void Smoke() {
        UseMatch();
        Factory.result = Factory.result + "\nРабочий  курит";

    }
    public static void UseMatch() {
        Match.LightUp();
    }
}
