package figures;

public class Square extends Rectangle
{
    private double height;

    public Square(double width, double height) {
        super(width, height);
    }
    public Square (double width){
        super(width, width);
    }
    // переопределение наследуемых параметров
public void setWidth(double width, double height)
{
    this.width=width;
    height=width;
}

    public void setHeight(double height) {
       this.height=height;
       width=height;
    }
}
