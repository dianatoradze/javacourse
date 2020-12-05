package figures;

public class Square extends Rectangle
{
    public Square(int width, int height) {
        super(width, height);
    }
    public Square (int width){
        super(width, width);
    }
    // переопределение наследуемых параметров
public void setWidth(int width)
{
    this.width=width;
    height=width;
}

    public void setHeight(int height) {
       this.height=height;
       width=height;
    }
}
