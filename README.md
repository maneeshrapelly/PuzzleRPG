# PuzzleRPG
Simple Role Playing Game where player roams around galaxy and explore planets that come across in the journey, fight monsters in his path and collects points.
Game finishes when player collects 1000 points. Player and monster combat in face-to-face and the one loses who losts all points. Monsters are powerful that 
they get into life by resurrection after every 10 seconds. Player can save the game and it resumes from that point when the game starts again.

##### Commands:
1) Explore --  "Describes the planet star characteristics and monsters out there and adjecent planets player can travel"
2) Explore self -- "Describes about the player and hit points currently hold"
3) Move [direction] -- "Moves to another planet. Direction can be south, north, east or west. Player moves to different planet based on the direction taken"
4) Attack [monster-name] -- "Initiate combat with monster. Monster name can be Snoke, DarthMaul, DarthSidious and DarthTyrannus"
5) Save -- "Saves game current state"

##### How to run application:
1) Load the project into IDE and run GameEntry class main method or
2) Generate jar file with "mvn clean install",
run
java -jar target/PuzzleGame-1.0-SNAPSHOT.jar

##### Example runtime log (Bold lines are user inputs):

Welcome to the Star's world. What do we call you 

**Luke** 

Here comes Luke from planet Earth to conquer the galaxy

Master Yoda gives you 100 hp and 75 accuracy to start. May the force be with you!

Commands for Exploring: Explore(Explore surroundings) Explore Self(Self)

Commands for Moving: Move North, Move South, Move West, Move East

Command for Attack: Attack <soldier-name>

Command for Saving the game state: Save

**explore**

You are on a Star: 1, Planet Mustafar . Here are some details of it:

surface is a brownish-yellow color

It takes 687 days to revolve around

Adjecent stars you can travel:

South 2

North 3

Soldiers you have to fight:

DarthTyrannus(I’ve become more powerful than any Jedi.)

Weapons you hold:

Commands for Exploring: Explore(Explore surroundings) Explore Self(Self)

Commands for Moving: Move North, Move South, Move West, Move East

Command for Attack: Attack <soldier-name>

Command for Saving the game state: Save

**explore self**

Hit Points: 100

Accuracy is: 75

Commands for Exploring: Explore(Explore surroundings) Explore Self(Self)

Commands for Moving: Move North, Move South, Move West, Move East

Command for Attack: Attack <soldier-name>

Command for Saving the game state: Save

**attack DarthTyrannus**

Your points:

Hit Points: 145

Accuracy is: 75

Soldier points:

Name: Darth Tyrannus

Hit Points: -5

Accuracy is: 30

You Defeated soldier

You are on a Star: 2, Planet Wobani . Here are some details of it:

rotates in 84 years

size is 51,118 kilometers in diameter

Adjecent stars you can travel:

North 1

East 3

West 4

Soldiers you have to fight:

Snoke(There has been an awakening.)

Weapons you hold:

Commands for Exploring: Explore(Explore surroundings) Explore Self(Self)

Commands for Moving: Move North, Move South, Move West, Move East

Command for Attack: Attack <soldier-name>

Command for Saving the game state: Save

**move east**

You are on a Star: 3, Planet Geonosis . Here are some details of it:

size is 49,500 kilometers in diameter

Rocky Surface

Adjecent stars you can travel:

South 1

West 2

East 4

Soldiers you have to fight:

DarthSidious(The dark side is a pathway to many abilities some consider to be unnatural.)

Weapons you hold:

Commands for Exploring: Explore(Explore surroundings) Explore Self(Self)

Commands for Moving: Move North, Move South, Move West, Move East

Command for Attack: Attack <soldier-name>

Command for Saving the game state: Save

**attack DarthSidious**

Your points:

Hit Points: 151

Accuracy is: 75

Soldier points:

Name: Darth Sidious

Hit Points: 54

Accuracy is: 60

Run Away?(Yes/No)

**no**

Your points:

Hit Points: 156

Accuracy is: 75

Soldier points:

Name: Darth Sidious

Hit Points: 49

Accuracy is: 60

Run Away?(Yes/No)

**yes**

You are on a Star: 1, Planet Mustafar . Here are some details of it:

surface is a brownish-yellow color

It takes 687 days to revolve around

Adjecent stars you can travel:

South 2

North 3

Soldiers you have to fight:

DarthTyrannus(I’ve become more powerful than any Jedi.)

Weapons you hold:

Commands for Exploring: Explore(Explore surroundings) Explore Self(Self)

Commands for Moving: Move North, Move South, Move West, Move East

Command for Attack: Attack <soldier-name>

Command for Saving the game state: Save

**move south**

You are on a Star: 2, Planet Wobani . Here are some details of it:

rotates in 84 years

size is 51,118 kilometers in diameter

Adjecent stars you can travel:

North 1

East 3

West 4

Soldiers you have to fight:

Snoke(There has been an awakening.)

Weapons you hold:

Commands for Exploring: Explore(Explore surroundings) Explore Self(Self)

Commands for Moving: Move North, Move South, Move West, Move East

Command for Attack: Attack <soldier-name>

Command for Saving the game state: Save

**explore self**

Hit Points: 156

Accuracy is: 75

Commands for Exploring: Explore(Explore surroundings) Explore Self(Self)

Commands for Moving: Move North, Move South, Move West, Move East

Command for Attack: Attack <soldier-name>

Command for Saving the game state: Save

**save**

Game state is saved! will be resumed from here when started again
