package sample;

public class ChildThread extends Thread {
    private boolean isWorking;
    private double num1;
    private double num2;
    private double result;

    public ChildThread( String _name, double _num1, double _num2) {

        super(_name);
        this.num1 = _num1;
        this.num2 = _num2;
        this.result = 0;
    }

    public void run() {

        this.result = num1 + num2;
    }

    public double getResult() {

        return this.result;

    }
}