package Movement;

import java.util.ArrayList;

import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import Menu.*;

/**
 * The animal which the player controls
 */
public class Animal extends Actor {
	// The displayed appearance of the animal for every movement
	Image imgW1;
	Image imgA1;
	Image imgS1;
	Image imgD1;
	Image imgW2;
	Image imgA2;
	Image imgS2;
	Image imgD2;
	int imgSize = 40;

	// Actions of the frog
	KeyCode up;
	KeyCode left;
	KeyCode right;
	KeyCode down;

	// The player number
	int player;
	// Life remaining
	int life = 5;
	// Points for current game
	int points = 0;
	// The end number that the player has achieved currently
	int end = 0;
	// Indicator to check if the animal move continuously
	private boolean second = false;
	// Check whether player has movement for the animal
	boolean noMove = false;
	// Determine how much to move up or down
	double movement;
	// Determine how much to move left or right
	double movementX = 10.666666*2;

	// Check if the animal bumps into any obstacles
	boolean carDeath = false;
	// Check if the animal sinks
	boolean waterDeath = false;
	// Indicator if the game is stop temperary
	boolean stop = false;
	// Indicator if the score on the screen is changed
	boolean changeScore = false;
	// Indicator if the life on the screen is changed
	boolean changeLife = true;
	// Indicator of which controls the displayed appearance of each death
	int carD = 0;
	// The width of the scene
	double w = 800;
	// How many ends that player has achieved
	ArrayList<End> inter = new ArrayList<End>();

	/**
	 * Initialisation of the animal controlled by player
	 * @param movement How much to move vertically
	 * @param player The player number
	 */
	public Animal(double movement, int player)
	{
		// Basis setting
		setLife(SettingPageController.getLife());
		this.movement = movement;
		this.player = player;

		// Set the appearance of frog according to player type
		setImage(new Image("file:src/Image/Frogger/"+ player +"/froggerUp.png", imgSize, imgSize, true, true));
		imgW1 = new Image("file:src/Image/Frogger/"+ player +"/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:src/Image/Frogger/"+ player +"/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:src/Image/Frogger/"+ player +"/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:src/Image/Frogger/"+ player +"/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/Image/Frogger/"+ player +"/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:src/Image/Frogger/"+ player +"/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:src/Image/Frogger/"+ player +"/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:src/Image/Frogger/"+ player +"/froggerRightJump.png", imgSize, imgSize, true, true);

		// Set the controlling way for different player
		if(player == 1)
		{
			this.up = KeyCode.W;
			this.left = KeyCode.A;
			this.right = KeyCode.D;
			this.down = KeyCode.S;
			setSituation();
		}
		else if(player == 2)
		{
			this.up = KeyCode.I;
			this.left = KeyCode.J;
			this.right = KeyCode.L;
			this.down = KeyCode.K;
			setSituation();
		}

		/**
		 * Determine the movement detail interaction with keyboard
		 */
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event)
			{
				if (noMove) {}
				else {
					changeLife = false;
					if (second)
					{
						if (event.getCode() == up) {
							move(0, -movement);
							changeScore = false;
							setImage(imgW1);
							second = false;
						}
						else if (event.getCode() == left) {
							 move(-movementX, 0);
							 setImage(imgA1);
							 second = false;
						}
						else if (event.getCode() == down) {
							 move(0, movement);
							 setImage(imgS1);
							 second = false;
						}
						else if (event.getCode() == right) {
							 move(movementX, 0);
							 setImage(imgD1);
							 second = false;
						}
					}
					else if (event.getCode() == up) {
						move(0, -movement);
						setImage(imgW2);
						second = true;
					}
					else if (event.getCode() == left) {
						 move(-movementX, 0);
						 setImage(imgA2);
						 second = true;
					}
					else if (event.getCode() == down) {
						 move(0, movement);
						 setImage(imgS2);
						 second = true;
					}
					else if (event.getCode() == right) {
						 move(movementX, 0);
						 setImage(imgD2);
						 second = true;
					}
	        	}
			}
		});	
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (noMove) {}
				else {
					changeLife = false;
					if (event.getCode() == up)
					{
						if (getY() < w) {
							changeScore = true;
							w = getY();
							points+=10;
						}
						move(0, -movement);
						setImage(imgW1);
						second = false;
					}
					else if (event.getCode() == left) {
						 move(-movementX, 0);
						 setImage(imgA1);
						 second = false;
					}
					else if (event.getCode() == down) {
						 move(0, movement);
						 setImage(imgS1);
						 second = false;
					}
					else if (event.getCode() == right) {
						 move(movementX, 0);
						 setImage(imgD1);
						 second = false;
					}
				}
			}
			
		});
	}

	/**
	 * Determine the event of animal in various situations
	 * @param now The gaming time
	 */
	@Override
	public void act(long now) {
		int bounds = 0;
		if (getY()<0 || getY()>734) {
			setSituation();
		}
		if (getX()<0) {
			move(movement*2, 0);
		}
		if (carDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("file:src/Image/Deaths/Cardeaths/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (carD==2) {
				setImage(new Image("file:src/Image/Deaths/Cardeaths/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (carD==3) {
				setImage(new Image("file:src/Image/Deaths/Cardeaths/cardeath3.png", imgSize, imgSize, true, true));
			}
			if (carD == 4) {
				setSituation();
				life -= 1;
				changeLife = true;
				carDeath = false;
				//
				System.out.println(life);
				carD = 0;
				setImage(new Image("file:src/Image/Frogger/"+ player +"/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points>50)
				{
					points-=50;
					changeScore = true;
				}
			}
		}
		if (waterDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("file:src/Image/Deaths/Waterdeaths/waterdeath1.png", imgSize,imgSize , true, true));
			}
			if (carD==2) {
				setImage(new Image("file:src/Image/Deaths/Waterdeaths/waterdeath2.png", imgSize,imgSize , true, true));
			}
			if (carD==3) {
				setImage(new Image("file:src/Image/Deaths/Waterdeaths/waterdeath3.png", imgSize,imgSize , true, true));
			}
			if (carD == 4) {
				setImage(new Image("file:src/Image/Deaths/Waterdeaths/waterdeath4.png", imgSize,imgSize , true, true));
			}
			if (carD == 5) {
				setSituation();
				life -= 1;
				changeLife = true;
				waterDeath = false;
				System.out.println(life);
				carD = 0;
				setImage(new Image("file:src/Image/Frogger/"+ player +"/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points>50) {
					points-=50;
				}
			}
			
		}
		
		if (getX()>600) {
			move(-movement*2, 0);
		}
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
		if (getX() == 240 && getY() == 82) {
			stop = true;
		}
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove)
		{
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2,0);
			else
				move (.75,0);
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1,0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1)
		{
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(-1,0);
			}
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (getIntersectingObjects(End.class).get(0).isActivated())
			{
				end--;
				points-=50;
			}
			points+=50;
			changeScore = true;
			w=800;
			End temp = getIntersectingObjects(End.class).get(0);
			temp.setVisible(true);
			temp.setEnd(player);
			end++;

			setSituation();
		}
		else if (getY()<405){
			waterDeath = true;
		}
	}

	/**
	 * Function to signal whether to update the score on the screen
	 * @return True if the score need to be updated on the screen
	 */
	public boolean changeScore()
	{
		if (changeScore)
		{
			changeScore = false;
			return true;
		}
		return false;
	}

	/**
	 * Function to signal whether to update the life on the screen
	 * @return True if the life number need to be updated on the screen
	 */
	public boolean changeLife()
	{
		if(changeLife)
		{
			changeLife = false;
			return true;
		}
		return false;
	}

	/**
	 * Set the situation of animal after each death or achieving the end
	 */
	private void setSituation()
	{
		if(player == 1)
		{
			setX(250);
			setY(679.8+movement);
		}
		else if(player == 2)
		{
			setX(300);
			setY(679.8+movement);
		}
	}

	/**
	 * Determine the situation to end the game
	 * @return True if the game achieve a win or lose condition
	 */
	public boolean getStop() { return (end==5 || life==0); }

	/**
	 * Getter to get the points
	 * @return The current points of game
	 */
	public int getPoints() { return points; }

	/**
	 * Getter to get the lfie
	 * @return The current life of game
	 */
	public int getLife() { return life; }

	/**
	 * Getter to get the how many ends have been achieved
	 * @return How many ends have been achieved
	 */
	public int getEnd() { return end; }

	/**
	 * Setter to set the life of current round of game
	 * @param life The life to initialize in each round{@link SettingPageController}
	 */
	public void setLife(int life) { this.life = life; }
}
