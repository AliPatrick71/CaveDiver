Overview

Cave Diver is a Java-based GUI application where you simulate an underwater cave diving adventure. The objective of the game is to guide a diver through a randomly generated 10x10 cave grid from the top-left corner (0, 0) to the bottom-right corner (9, 9). The diver has limited air and can only pass through cave cells that are within the diver's depth rating. The goal is to find an escape route before the diver runs out of air.
Features

    Random Cave Generation: Each game generates a new cave grid with random depth values for each cell.
    Depth Rating: You can set a depth rating for the diver to determine how deep the diver can go.
    Recursive Pathfinding: The game uses a recursive algorithm to find a valid escape route.
    Visual Escape Route: If a successful escape route is found, it will be highlighted in red on the grid.

Gameplay Instructions
1. Set the Depth Rating

    Enter a depth rating in the text field. This rating determines how deep the diver can go. Each cell in the grid has a depth between 0 and 100, where 0 is the shallowest and 100 is the deepest.
    Recommended starting depth rating: 50.

2. Escape Attempt

    Press the "Escape" button to start the escape attempt.
    The program will recursively try to find a path from the starting point (0,0) to the exit point (9,9) within the allowed depth and air supply.
    Each move deducts 1 unit of air, and the diver starts with 20 units of air.

3. Outcome

    If a route is found, the escape path will be highlighted in red on the grid.
    If no route is found, a dialog box will pop up saying "No escape route found!".

4. Generate New Cave

    Press the "New Cave" button to generate a fresh cave layout. This resets the grid with new randomly assigned depth values.

5. Repeat the Process

    You can repeat the game with different depth ratings to test various scenarios. Try lower or higher depth ratings to see how they affect the diver’s ability to escape.

Project Structure

scss

CaveDiver/
│
│   ├── CaveCell.java         // Represents individual cells of the cave grid
│   ├── CaveGrid.java         // Manages the grid and drawing the cells
│   └── CaveDiverApp.java     // Main application with the GUI and game logic
├── README.md                 // This readme file

Installation and Setup
Prerequisites

    Java Development Kit (JDK) installed on your machine. Download JDK.
    A Java-compatible IDE such as IntelliJ IDEA, Eclipse, NetBeans, or a text editor with terminal support like VS Code.

Running the Application

    Clone or download the repository to your local machine.
    Navigate to the src directory where the Java files are located.
    Compile the Java files:

    bash

javac *.java

Run the application:

bash

    java CaveDiverApp

Alternatively, if you're using an IDE, you can simply import the project and run the CaveDiverApp class.
How It Works

    Cave Grid: The cave grid consists of 100 cells, each with a random depth between 0 and 100. The depth determines how "deep" the cave cell is, and cells are colored in shades of blue based on their depth.
    Depth Rating: The depth rating you enter in the text field is the maximum depth the diver can pass through. Cells that exceed the depth rating are considered impassable.
    Air Supply: The diver starts with 20 units of air. Each move (down or right) costs 1 unit of air.
    Recursive Pathfinding: The game uses a recursive algorithm to try moving the diver either right or down. If a valid path to the bottom-right corner is found, the cells in the escape route are highlighted in red.

Technologies Used

    Java Swing: Used for the graphical user interface (GUI).
    AWT (Abstract Window Toolkit): Used for low-level graphical operations (e.g., drawing the cave grid).
    Recursion: Used for the pathfinding algorithm that attempts to find an escape route for the diver.