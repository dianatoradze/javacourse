import figures.Circle;
import figures.Square;
import figures.figure;

public class Main {
    public static void main(String[] args)
    {
        Square square = new Square(40);
        System.out.println(square.getSquare());
        figure figure = new Circle(45.5);
        figure.getSquare();
    }
}
