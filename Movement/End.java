package Movement;

import javafx.scene.image.Image;

/**
 * The terminal that animals need to achieve if player wants to pass the game
 */
public class End extends Actor{
	boolean activated = false;
	@Override
	public void act(long now) {
		// TODO Auto-generated method st
	}

	/**
	 * Set the position of the end
	 * @param x
	 * @param y
	 */
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/Image/Ends/End.png", 60, 60, true, true));
	}

	/**
	 * Set the image of the ends
	 */
	public void setEnd()
    {
		setImage(new Image("file:src/Image/Ends/FrogEndchanged.png", 60, 60, true, true));
		activated = true;
	}

	/**
	 * Check if the end is occupied (has been achieved)
	 * @return
	 */
	public boolean isActivated() {
		return activated;
	}
	

}
