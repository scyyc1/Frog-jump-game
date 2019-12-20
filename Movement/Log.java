package Movement;

import javafx.scene.image.Image;

/**
 * Log object to stand the frog
 */
public class Log extends Actor {

	private double speed;
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<-300 && speed<0)
			setX(700);
	}

	/**
	 * Set the position of the log
	 * @param imageLink appearance of the log
	 * @param size
	 * @param xpos
	 * @param ypos
	 * @param s speed of movement
	 */
	public Log(String imageLink, int size, int xpos, int ypos, double s)
	{
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

	/**
	 * Reverse the direction if the its speed less than 0
	 * @return True if the log is in left direction
	 */
	public boolean getLeft() {
		return speed < 0;
	}
}
