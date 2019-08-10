# Game of Life

To open and edit the project on your machine you can simply download IntelliJ IDEA https://www.jetbrains.com/idea/download/#section=windows
and then select open project choosing the Game-of-life-master root folder

If you simply want to run the application go to Game-of-life-master\runableprogramm and execute run_simulation.bat make sure to have Java installed else download from https://www.java.com/en/download/

First the user enters the dimension of the simulation world.

![](dimensions.png)

Simulation class creates a GUI which creates a world which consists of grasspanels, lions, tigers, sheep, rabbits

![](simulation.png)

On each round (Button press that is on GUI class) animals move, eat, and reproduce(not every turn so that the population can decrease).

![](stats.png)

The simulation ends when no carnivores or grasspanels are left.
