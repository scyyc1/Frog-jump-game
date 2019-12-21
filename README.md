# My report

Contents

a)	UI Desige
b)	Interesting Level
c)	MVC and Design pattern
d)	Junit Test and Javadoc


a)	UI design
1.	Add menu and other pages for more functions

    ![avatar](../src/Image/Readme/Menu.png)
    Figure 1 Main menu

    A safe exit is created

2.	Setting & INFO page

    ![avatar](../src/Image/Readme/set.png)
    Figure 2 Setting page

    Show the game operation and can adjust the life for each round
            
3.	Rank page

    ![avatar](../src/Image/Readme/rank.png)
    Figure 3 Rank page

    Show the rank in descending order. The related rank.txt files are stored in rank folder (If there is no such file, the software will create automatically)

b)	 Interesting level

1.	Three modes for choice

    ![avatar](../src/Image/Readme/mode.png)
    Figure 4 Mode choice

    ![avatar](../src/Image/Readme/normal.png)
    Figure 5 Normal mode 

    Changes: 
        i.	obstacles layout (8 layers obstacles for easy and 10 for normal and hard)
        ii.	speed of obstacles
        
2.	Add life system. Each death costs one life. When life become 0, game over. Corresponding page will diliver

    ![avatar](../src/Image/Readme/1P_game_win.png)    
    Figure 6 Game win 	

    ![avatar](../src/Image/Readme/1P_game_over.png)
    Figure 7 Game over

    The life can be set at the setting page with the range of 1 to 5
    It also provides button go back to menu to restart or end the game

3.	2 player mode
    2 player mode was integrated. The second player is controlled by “I K J L” representing UP DOWN LEFT RIGHT.

    Win condition: when one of player occupy 3 more ends or the rival runs out of life.
    Lose condition: when both of players run out of life.

    The life can also be set at the setting page.
    Player two is represented with a red frog and not counting the score 

    ![avatar](../src/Image/Readme/2P.png)
    Figure 8 Two player mode

c)	MVC and Design pattern

1.	Rearrange the files and separate the function of code.

    	package View stores all the viewing page of the game. Use the external CSS sheet to separate design and function.
    	package Menu stores all the controllers and the main function. The controller only contain the initialization of the corresponding page and the connection between pages
    	package Game stores the model of the game which controls the process of the game
    	Other package store the rank.txt, Javadoc, CSS sheet and the necessary video and audio files

2.	Singleton design pattern

    Apply singleton pattern to all the model of MVC to ensure every run of software only one game is running. 

    ![avatar](../src/Image/Readme/singleton.png)
    Figure 9 Singleton of process

3.	Split the large method into small pieces

    For example:
    i.	Improve the reusability of code by separating the reset-position function in Animal.act method as:

    ![avatar](../src/Image/Readme/setSituation.png)
    Figure 10 setSituation function

    ii.	Separate the digit-display function from process class to a individual static function to improve the encapsulation.

    ![avatar](../src/Image/Readme/setScore.png)
    Figure 11 setScore function

d)	Junit test and Javadoc

1.	Add Junit test to check the ranking system:

    1)	Whether it can rank the score in descending order:

    ![avatar](../src/Image/Readme/junit_test_1.png)
    Figure 12 Junit test for bubleSort

    ![avatar](../src/Image/Readme/junit_test_2.png)                  
    Figure 13 Junit test bubleSort

    2)	Whether only store 5 rank (improve the efficiency)

    ![avatar](../src/Image/Readme/junit_test_3.png)
    Figure 14 Junit test

2.	Javadoc
    Generate the Javadoc API file, example as follow:

    ![avatar](../src/Image/Readme/Javadoc.png)
    Figure 15 API file


			

