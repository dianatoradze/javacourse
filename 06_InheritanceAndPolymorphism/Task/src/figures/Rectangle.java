package figures;

public class Rectangle {
    public int width;
    public int height;
    public Rectangle(int width, int height)
    {
        this.height=height;
        this.width=width;
    }
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

public int getSquare()
{
    return width*height;
}

}
