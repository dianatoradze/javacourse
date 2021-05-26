package figures;

public class Circle extends figure{
    private double radius;
    public Circle(double radius) {
        this.radius=radius;
    }
    public double getSquare(){

        return Math.PI*Math.pow(radius,2);
    }
}
