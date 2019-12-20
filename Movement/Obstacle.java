package Movement;

import javafx.scene.image.Image;

/**
 * Obstacle of the game
 */
public class Obstacle extends Actor {
	private int speed;

	/**
	 * Set the movement of obstacles
	 * @param now The gaming time
	 */
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}

	/**
	 * Initialize the obstacle
	 * @param imageLink appearance
	 * @param xpos
	 * @param ypos
	 * @param s speed
	 * @param w width
	 * @param h heigth
	 */
	public Obstacle(String imageLink, int xpos, int ypos, int s, int w, int h) {
		setImage(new Image(imageLink, w,h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

}
