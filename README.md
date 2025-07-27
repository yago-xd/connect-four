# Connect Four 

A full-featured, interactive, and replayable Connect Four game built in Java, where you challenge a computer opponent in the classic four-in-a-row battle.

![Java](https://img.shields.io/badge/Language-Java-blue.svg)
![Beginner Project](https://img.shields.io/badge/Level-Beginner-brightgreen)
![Console Game](https://img.shields.io/badge/Type-Console--App-lightgrey)

---

## ✨ Features

### 🧠 Intelligent Game Logic
\- Implements **perfect grid-checking logic** for all winning scenarios (horizontal, vertical, diagonal).  
\- Accurately identifies **draws** and declares them when the board is full without a winner.

### 🧍‍♂️ vs 🖥️ User vs Computer
\- Play against a computer that selects random but valid columns.  
\- Ensures no overwriting of filled columns, keeping gameplay error-free.

### 🎭 Symbol Selection
\- Choose whether you want to be **🟡 or 🔴**.  
\- The computer automatically takes the remaining symbol.  
\- Input validation ensures only valid choices are accepted.

### 🔄 First Move Randomizer
\- Fairly choose between the user and the computer to make the **first move**.  
\- Adds unpredictability and variation to every game.

### 🗺️ Visual Game Board
\- Displays a neatly formatted (**6x7 board**) with column headers.  
\- Updated after every move with clear visual structure and emoji symbols.

### 📈 Score Tracker
\- Tracks:  
    \- 🟢 Games Played  
    \- 🏆 Wins  
    \- ❌ Losses  
    \- 🤝 Draws  
\- Print out **cumulative results** after quitting the game.

### ♻️ Replay System
\- After each game, the user is asked if they want to **play again** (`y/n`).  
\- If yes, the game **fully resets** the board and randomly re-selects the first player.  
\- Smooth replay flow, no duplicated printing or stuck loops.

### ✅ Fully Validated Input
\- Handles invalid numeric inputs like letters or symbols with **graceful messages**.  
\- Prevents crashing by checking `Scanner` inputs carefully.  
\- Ensures all moves are within bounds and in empty columns.

### 💤 Realism with Delays
\- Adds **brief delays** before the computer moves, giving a more natural "thinking" effect.

---

## 🚀 Getting Started

### 📦 Requirements

\- Java 8 or above  
\- Any terminal or command line interface

### 🛠️ How to Run

Download the jar file from the releases section

```bash
java -jar connect-four.jar
```

Try it on [Replit](https://replit.com/@yago-xd/connect-four)

---

## 🕹️ How to Play
1. Choose your symbol (🟡 or 🔴).
2. See if you go first or let the computer start.
3. Enter the column number (1-7) to drop your disc.
4. Watch the game unfold as you try to connect four in a row!
5. After the game, decide if you want to play again.
6. Enjoy the challenge and improve your skills!
7. Check your score after quitting the game.
8. Have fun!

## 🧠 Future improvements:
- Add a minimax AI for unbeatable computer strategy.
- Convert into a GUI version using Swing or JavaFX.
- Add sound effects and animations for moves.
- Online multiplayer mode using sockets.
- Leaderboard that saves stats across sessions.

## 🔧 Tools Used
- Java 17 (or Java 8+)
- IntelliJ IDEA (recommended)
- Git + GitHub

# 🖥️ Sample Output
```console
Welcome to Connect Four!
The game is played on a 6x7 grid.
Players take turns dropping their colored discs into one of the columns.
The first player to connect four of their discs in a row (horizontally, vertically, or diagonally) wins.
If the grid is full and no player has connected four, the game ends in a draw.

Symbols: (1. 🔴)/(2. 🟡)
Enter your preferred symbol choice (1/2): 2
Symbol chosen by you: 🟡
Computer symbol: 🔴
Game Loaded

----------------
 1 2 3 4  5 6 7
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪

Round 1

The first move will be made by: Computer
Computer has made its move
Computer placed at Column 5
----------------
 1 2 3 4  5 6 7
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪🔴⚪⚪
Your move
To undo your last move, type 'undo' (without quotes)
Enter the column number to make a move: 4
You have made your move
You placed at Column 4
Time taken for this move: 3s
----------------
 1 2 3 4  5 6 7
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪🟡🔴⚪⚪
Computer's move
Computer has made its move
Computer placed at Column 4
----------------
 1 2 3 4  5 6 7
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪🔴⚪⚪⚪
⚪⚪⚪🟡🔴⚪⚪
Your move
To undo your last move, type 'undo' (without quotes)
Enter the column number to make a move: undo
Your last move has been undone.
----------------
 1 2 3 4  5 6 7
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪🔴⚪⚪⚪
⚪⚪⚪⚪🔴⚪⚪
To undo your last move, type 'undo' (without quotes)
Enter the column number to make a move: undo
Computer's last move has been undone.
----------------
 1 2 3 4  5 6 7
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪🔴⚪⚪
To undo your last move, type 'undo' (without quotes)
Enter the column number to make a move: 4
You have made your move
You placed at Column 4
Time taken for this move: 8s
----------------
 1 2 3 4  5 6 7
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪🟡🔴⚪⚪
Computer's move
Computer has made its move
Computer placed at Column 7
----------------
 1 2 3 4  5 6 7
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪🟡🔴⚪🔴
Your move
To undo your last move, type 'undo' (without quotes)
Enter the column number to make a move: 4
You have made your move
You placed at Column 4
Time taken for this move: 0s
----------------
 1 2 3 4  5 6 7
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪🟡⚪⚪⚪
⚪⚪⚪🟡🔴⚪🔴
Computer's move
Computer has made its move
Computer placed at Column 5
----------------
 1 2 3 4  5 6 7
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪🟡🔴⚪⚪
⚪⚪⚪🟡🔴⚪🔴
Your move
To undo your last move, type 'undo' (without quotes)
Enter the column number to make a move: 4
You have made your move
You placed at Column 4
Time taken for this move: 1s
----------------
 1 2 3 4  5 6 7
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪🟡⚪⚪⚪
⚪⚪⚪🟡🔴⚪⚪
⚪⚪⚪🟡🔴⚪🔴
Computer's move
Computer has made its move
Computer placed at Column 3
----------------
 1 2 3 4  5 6 7
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪🟡⚪⚪⚪
⚪⚪⚪🟡🔴⚪⚪
⚪⚪🔴🟡🔴⚪🔴
Your move
To undo your last move, type 'undo' (without quotes)
Enter the column number to make a move: 4
You have made your move
You placed at Column 4
Time taken for this move: 1s
----------------
 1 2 3 4  5 6 7
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪⚪⚪⚪⚪
⚪⚪⚪🟡⚪⚪⚪
⚪⚪⚪🟡⚪⚪⚪
⚪⚪⚪🟡🔴⚪⚪
⚪⚪🔴🟡🔴⚪🔴

***************
*   YOU WIN!  *
***************

Number of moves made in this round: 8
Score for this round: 196

------------------------------

Do you wish to see a log of all moves in this round (Y/N): y

Moves made in this round by User: 4
Moves made in this round by Computer: 4

Moves Log:
Move 1 at Column 5 by Computer(🔴)  [1s]
Move 2 at Column 4 by User(🟡)      [3s]
Move 3 at Column 4 by Computer(🔴)  [1s]
Move 2 at Column 4 by User(🟡)      [8s]
Move 3 at Column 7 by Computer(🔴)  [1s]
Move 4 at Column 4 by User(🟡)      [0s]
Move 5 at Column 5 by Computer(🔴)  [1s]
Move 6 at Column 4 by User(🟡)      [1s]
Move 7 at Column 3 by Computer(🔴)  [1s]
Move 8 at Column 4 by User(🟡)      [1s]

------------------------------

Do you wish to play again? (Y/N): n

Thanks for playing!

---------Statistics----------
Games Played: 1
Wins: 1 (100%)
Losses: 0 (0%)
Draws: 0 (0%)

Game History Log:
Round 1: Winner - YOU in 8 moves
------------------------------
```