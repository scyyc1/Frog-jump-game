package Movement;

import java.util.ArrayList;

import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import Menu.*;


public class Animal extends Actor {
	// Actions of the frog
	Image imgW1;
	Image imgA1;
	Image imgS1;
	Image imgD1;
	Image imgW2;
	Image imgA2;
	Image imgS2;
	Image imgD2;

	KeyCode up;
	KeyCode left;
	KeyCode right;
	KeyCode down;

	// The remain life
	int player = 0;
	int life = 5;
	int points = 0;
	int end = 0;
	private boolean second = false;
	boolean noMove = false;
	double movement = 13.3333333*2;
	double movementX = 10.666666*2;
	int imgSize = 40;
	boolean carDeath = false;
	boolean waterDeath = false;
	boolean stop = false;
	boolean changeScore = false;
	int carD = 0;
	double w = 800;
	ArrayList<End> inter = new ArrayList<End>();
	public Animal(double movement, int player) {
		setLife(SettingPageController.getLife());
		this.movement = movement;
		this.player = player;

		setImage(new Image("file:src/Image/Frogger/"+ player +"/froggerUp.png", imgSize, imgSize, true, true));
		imgW1 = new Image("file:src/Image/Frogger/"+ player +"/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:src/Image/Frogger/"+ player +"/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:src/Image/Frogger/"+ player +"/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:src/Image/Frogger/"+ player +"/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/Image/Frogger/"+ player +"/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:src/Image/Frogger/"+ player +"/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:src/Image/Frogger/"+ player +"/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:src/Image/Frogger/"+ player +"/froggerRightJump.png", imgSize, imgSize, true, true);

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

		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				if (noMove) {
					
				}
				else {
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
				if (event.getCode() == up) {
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
	
	@Override
	public void act(long now) {
		int bounds = 0;
		if (getY()<0 || getY()>734) {
			setX(300);
			setY(679.8+movement);
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

				carDeath = false;
				//
				life -= 1;
				System.out.println(life);
				carD = 0;
				setImage(new Image("file:src/Image/Frogger/"+ player +"/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points>50) {
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
				//
				waterDeath = false;
				life -= 1;
				System.out.println(life);
				carD = 0;
				setImage(new Image("file:src/Image/Frogger/"+ player +"/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points>50) {
					points-=50;
					changeScore = true;
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
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				points-=50;
			}
			points+=50;
			changeScore = true;
			w=800;
			End temp = getIntersectingObjects(End.class).get(0);
			temp.setVisible(true);
			temp.setEnd();
			end++;
			setX(300);
			setY(679.8+movement);
		}
		else if (getY()<405){
			waterDeath = true;
			//setX(300);
			//setY(679.8+movement);
		}
	}
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


	public boolean getStop() { return (end==1 || life==0); }
	
	public int getPoints() {
		return points;
	}

	public int getLife() { return life; }

	public void setLife(int life) { this.life = life; }
	
	public boolean changeScore()
	{
		if (changeScore)
		{
			changeScore = false;
			return true;
		}
		return false;


		
	}

}
