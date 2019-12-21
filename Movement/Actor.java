package Movement;

import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;

import java.util.ArrayList;

/**
 * Parent class that define the objects (animal and obstacles) in the game
 * Provide the method to check if two object crash
 * Provide interface of action for each sub class
 * {@link Animal}{@link javafx.scene.layout.Background}{@link Digit}{@link End}{@link Image}{@link Log}{@link Obstacle}{@link Turtle}{@link WetTurtle}
 */
public abstract class Actor extends ImageView{

    /**
     * Determine how object moves
     * @param dx movement of right
     * @param dy movement of down
     */
    public void move(double dx, double dy)
    {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    /**
     * Get the current pane of scene
     * @return the current pane of scene
     */
    public World getWorld() {
        return (World) getParent();
    }

    /**
     * Getter to get the width of object
     * @return the width of object
     */
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    /**
     * Getter to get the height of object
     * @return the height of object
     */
    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    /**
     * Check if one object bumps into other objects
     * @param cls The object that wants to check
     * @param <A> Genericity that defines which element to input
     * @return the list of object that had intersection with the input object
     */
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

    /**
     * Check if the input object bumps into another and return that
     * @param cls The input object that wants to check
     * @param <A> Genericity that defines which element to input
     * @return The object that has Intersection with input object
     */
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

    /**
     * Interface that define the detail movement of each sub object
     * @param now The gaming time
     */
    public abstract void act(long now);

}
