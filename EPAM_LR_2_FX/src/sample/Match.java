package sample;

public class Match {
    public double length;
    public Boolean canBeLightedUp;
    public String result;
    public Match() {
        length = 3.5;
        canBeLightedUp = true;
    }
    public static  void LightUp() {
        Factory.result = Factory.result + "\nСпичка зажигается";
    }
}
