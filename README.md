Contents

a)	UI Design	3
b)	Interesting Level	5 
c)	MVC and Design pattern	6
d)	Junit Test and Javadoc	9














a)	UI design
1.	Add menu and other pages for more functions
 
    Figure 1 Main menu
2.	Setting & INFO page
 
Figure 2 Setting page
		  Show the game operation and can adjust the life for each round 
		  
3.	Rank page
 
Figure 3 Rank page
		  Show the rank in descending order
b)	 Interesting level
1.	Three modes for choice
  
  Figure 4 Mode choice 			    Figure 5 Normal mode 
Changes: 
i.	obstacles layout (8 layers obstacles for easy and 10 for normal and hard)
ii.	speed of obstacles
	
2.	Add life system. Each death costs one life. When life become 0, game over. Corresponding page will diliver.

  
Figure 6 Game win 				  Figure 7 Game over
		  The life can be set at the setting page with the range of 1 to 5

3.	2 player mode
2 player mode was integrated. The second player is controlled by “I K J L” representing UP DOWN LEFT RIGHT.
Win condition: when one of player occupy 3 more ends or the rival runs out of life.
Lose condition: when both of players run out of life.
The life can also be set at the setting page.
Player two is represented with a red frog
 
Figure 8 Two player mode
c)	MVC and Design pattern
1.	Rearrange the files and separate the function of code.
	package View stores all the viewing page of the game
	package Menu stores all the controllers and the main function
	package Game stores the model of the game which controls the process of the game
	Other package store the rank.txt, Javadoc, CSS sheet and the necessary video and audio files

2.	Singleton design pattern
Apply singleton pattern to all the model of MVC to ensure every run of software only one game is running.
Contents

a)	UI Design	3
b)	Interesting Level	5 
c)	MVC and Design pattern	6
d)	Junit Test and Javadoc	9














a)	UI design
1.	Add menu and other pages for more functions
 
    Figure 1 Main menu
2.	Setting & INFO page
 
Figure 2 Setting page
		  Show the game operation and can adjust the life for each round 
		  
3.	Rank page
 
Figure 3 Rank page
		  Show the rank in descending order
b)	 Interesting level
1.	Three modes for choice
  
  Figure 4 Mode choice 			    Figure 5 Normal mode 
Changes: 
i.	obstacles layout (8 layers obstacles for easy and 10 for normal and hard)
ii.	speed of obstacles
	
2.	Add life system. Each death costs one life. When life become 0, game over. Corresponding page will diliver.

  
Figure 6 Game win 				  Figure 7 Game over
		  The life can be set at the setting page with the range of 1 to 5

3.	2 player mode
2 player mode was integrated. The second player is controlled by “I K J L” representing UP DOWN LEFT RIGHT.
Win condition: when one of player occupy 3 more ends or the rival runs out of life.
Lose condition: when both of players run out of life.
The life can also be set at the setting page.
Player two is represented with a red frog
 
Figure 8 Two player mode
c)	MVC and Design pattern
1.	Rearrange the files and separate the function of code.
	package View stores all the viewing page of the game
	package Menu stores all the controllers and the main function
	package Game stores the model of the game which controls the process of the game
	Other package store the rank.txt, Javadoc, CSS sheet and the necessary video and audio files

2.	Singleton design pattern
Apply singleton pattern to all the model of MVC to ensure every run of software only one game is running.
