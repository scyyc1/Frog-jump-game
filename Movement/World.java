package Movement;


import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * Determine the background setting of the game
 * parent class of {@link MyStage}
 */
public abstract class World extends Pane {
    private AnimationTimer timer;

    public World() {

    	sceneProperty().addListener(new ChangeListener<Scene>() {

            /**
             * Change the scene after each movement
             * @param observable Object that need to be changed
             * @param oldValue Old scene that need to be updated
             * @param newValue New scene to show
             */
			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if (newValue != null) {
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>()
                    {
						@Override
						public void handle(KeyEvent event)
                        {
							if(getOnKeyReleased() != null)
								getOnKeyReleased().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors)
							{
								if (anActor.getOnKeyReleased() != null)
								{
									anActor.getOnKeyReleased().handle(event);
								}
							}
						}
					});

					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event)
                        {
							if(getOnKeyPressed() != null)
								getOnKeyPressed().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors)
							{
								if (anActor.getOnKeyPressed() != null)
								{
									anActor.getOnKeyPressed().handle(event);
								}
							}
						}

					});
				}

			}
		});
    }

    /**
     * Control the process of obstacles
     * And make them move according to time and their own moving method
     */
    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                act(now);
                List<Actor> actors = getObjects(Actor.class);

                for (Actor anActor: actors) {
                	anActor.act(now);
                }

            }
        };
    }

    /**
     * Start the process
     */
    public void start() {
    	createTimer();
        timer.start();
    }

    /**
     * Stop the process
     */
    public void stop() {
        timer.stop();
    }

    /**
     * Add object to the pane
     * @param actor
     */
    public void add(Actor actor) {
        getChildren().add(actor);
    }

    /**
     * Remove object in the pane
     * @param actor
     */
    public void remove(Actor actor) {
        getChildren().remove(actor);
    }

    /**
     * Get the actors in the pane
     * @param cls The object that wants to check
     * @param <A> Genericity that defines which element to input
     * @return The list of objects in the pane
     */
    public <A extends Actor> List<A> getObjects(Class<A> cls)
    {
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node n: getChildren())
        {
            if (cls.isInstance(n))
            {
                someArray.add((A)n);
            }
        }
        return someArray;
    }

    public abstract void act(long now);
}
