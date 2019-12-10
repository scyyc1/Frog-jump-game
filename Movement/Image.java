package Movement;

public class Image extends Actor
{
    @Override
    public void act(long now){}

    public Image(String imageLink, int size, int xpos, int ypos)
    {
        setImage(new javafx.scene.image.Image(imageLink, size,size, true, true));
        setX(xpos);
        setY(ypos);
    }
}
