package Movement;

import javafx.scene.image.Image;

/**
 * The digits that are showed on the screen
 */
public class Digit extends Actor{
	int dim;
	Image im1;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Detemined the position of the digits showed on the screen
	 * @param n digit number
	 * @param dim size
	 * @param x X position
	 * @param y Y position
	 */
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:src/Image/Numbers/initial/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
	
}
