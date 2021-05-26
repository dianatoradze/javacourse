package figures;

public class Rectangle extends figure{
     protected double width;
    private double height;
    public Rectangle(double width, double height)
    {
        this.height=height;
        this.width=width;
    }
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

public double getSquare()
{
    return width*height;
}

}
