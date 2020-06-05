package sample;

public class MainThread {

    private double[] vector1 = {3.6, 2.2, 1.5};
    private double[] vector2 = {1.2, -9, 4.7};
    private double resultSum = 0;
    private String resultVectorString = "null";



    public MainThread(double[] _vector1,double[] _vector2) {

        this.vector1 = _vector1;
        this.vector2 = _vector2;

    }

    public void calculateSum() {

        for (int i = 0; i < this.vector1.length; i++) {

            ChildThread calculate = new ChildThread("Child" + i, this.vector1[i], this.vector2[i]);
            calculate.start();

        }

        {
            resultSum = calculate.getResult();
            if(resultSum != 0) {
                if (resultVectorString == "null") {
                    resultVectorString = Double.toString(resultSum);
                } else {
                    resultVectorString += "; " + Double.toString(resultSum);
                }
            }
        }
    }


    public String getResultSum(){
        return resultVectorString;
    }

}