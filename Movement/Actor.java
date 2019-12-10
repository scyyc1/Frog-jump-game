package Movement;

import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;

import java.util.ArrayList;


public abstract class Actor extends ImageView{

    public void move(double dx, double dy)
    {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    public World getWorld() {
        return (World) getParent();
    }

    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    // Input the instance of Actor
    public <A extends Actor> java.util.List<A> getIntersectingObjects(Class<A> cls)
    {
        ArrayList<A> someArray = new ArrayList<A>();
        // Get every "cls" object in the stage
        for (A actor: getWorld().getObjects(cls))
        {
            // Check if the current (Actor) object intersects with input (Actor) objects
            // If it is, add the input objects to the list
            if (actor != this && actor.intersects(this.getBoundsInLocal()))
            {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    
    public void manageInput(InputEvent e) {
        
    }

    public <A extends Actor> A getOneIntersectingObject(Class<A> cls)
    {
        ArrayList<A> someArray = new ArrayList<A>();
        // Get every "cls" object in the stage
        for (A actor: getWorld().getObjects(cls))
        {
            // Check if the current (Actor) object intersects with input (Actor) objects
            // If it is, add the input objects to the list
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
                break;
            }
        }
        return someArray.get(0);
    }

    public abstract void act(long now);

}
