# TicTacToeFinal

## What is our project?

Our project is a restful API made using Spring. It is a local 2 player tictactoe game, where players take turns trying to get 3 of their counters in a vertical, horizontal or diagonal sequence.
Our results are stored in a SQL Database, which records the individual Game Id, and the players associated with that game, along with the status of the game, and the winner if the status is "complete".
We used Postman to test run our code, to ensure our methods work,  most importantly to see if our API allows us to add players to a game, and create sequences that result in a winner if any of the winning combinations are satisfied.

## Why did we choose this project?

We chose this project because we wanted to explore how games would be made using an API, especially one that would take two different players that could play the same game.
Also, we wanted to make a game because it allowed us flexibility when deciding what goes into the game, i.e. Requirements for making the game set up, and making two players connect to a game.


## What are our game features?

Firstly, someone can start the game by entering their player name, in doing so, they are assigned Player ID, and a game ID is assigned. However, for a game to start, and for our Board Array to be generated,
a second player must enter their name, and the ID of the game they would like to join.

Now, they can play the game. They each take turns entering a position on our 1D Array List (which is our board), and the first to satisfy one of the winning combination conditions 
<img width="945" alt="Screenshot 2022-09-15 at 15 15 32" src="https://user-images.githubusercontent.com/109157608/190427278-cd2073fb-c6ac-4ea1-9ca0-b290841f55e5.png">

# Who made this project?

Ravi, Yingying, April, Khatija
