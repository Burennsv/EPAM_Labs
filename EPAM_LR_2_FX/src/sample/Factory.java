package sample;

import java.util.ArrayList;

public class Factory {
    public static ArrayList<Worker> workerArrayList = new ArrayList<Worker>();
    public static String result = new String();
    private ArrayList<Car> products = new ArrayList<Car>();
    private String productType;
    public Factory() {
        productType = "Cars";
    }
    public void HireWorker() {
        Worker newWorker = new Worker();
        workerArrayList.add(newWorker);
    }
    public void ProduceProduct() {
        for (Worker newWorker : workerArrayList) {
            newWorker.Work();
        }
        for (Worker newWorker : workerArrayList) {
            newWorker.Smoke();
        }
        Car newCar = new Car();
        Factory.result = Factory.result + "\nПроизведён товар";
        products.add(newCar);
    }
    public static void SetMessage(String msg) {
        result = msg;
    }
}
