# Tic-Tac-Toe Android 🎮

An Android Tic-Tac-Toe game built with **Kotlin and Jetpack Compose**, featuring an AI opponent powered by the Minimax algorithm.

## Overview

This project demonstrates Android application development, interactive UI design, game-state management, and artificial intelligence through a classic Tic-Tac-Toe experience.

Players compete against an AI opponent that evaluates possible moves and selects an optimal strategy.

## Features

- Interactive 3×3 Tic-Tac-Toe board
- Human versus AI gameplay
- AI opponent powered by Minimax
- Win, loss, and draw detection
- Game restart functionality
- Jetpack Compose user interface

## Technologies

- Kotlin
- Android SDK
- Jetpack Compose
- Minimax Algorithm
- JUnit

## How the AI Works

The AI uses the Minimax algorithm to evaluate possible future moves.

1. It examines all available positions on the board.
2. It simulates potential moves for both players.
3. It assigns scores to outcomes: AI win, human win, or draw.
4. It selects the move with the best possible outcome.

The AI is designed to play optimally, meaning it should never lose against a player who starts from a valid game state.

## Screenshots

<img width="273" height="548" alt="Screenshot 2026-11-17 221557" src="https://github.com/user-attachments/assets/04b8a1a4-4ff7-4778-8dc4-2bd79049d247" />


<img width="245" height="530" alt="Tic tac toe" src="https://github.com/user-attachments/assets/b9f589c4-b78e-4bed-84c2-4c2a5265a852" />


<img width="279" height="552" alt="Screenshot 2026-11-17 221656" src="https://github.com/user-attachments/assets/f30be9a0-4163-475d-8b2a-2b7c5f27fb15" />




## How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/Harshith120/tictactoe-android.git
   ```

2. Open the project in Android Studio.
3. Allow Gradle to sync.
4. Start an Android emulator or connect an Android device.
5. Click **Run** to build and launch the application.

## Running Tests

Run the unit tests from Android Studio or execute:

```bash
./gradlew test
```

On Windows:

```bash
gradlew.bat test
```

## Project Structure

```text
TicTacToe-android/
├── app/
│   ├── build.gradle.kts
│   ├── src/
│   │   ├── main/
│   │   │   ├── AndroidManifest.xml
│   │   │   └── java/com/HarshithMuthuluri/tictactoe/
│   │   │       ├── MainActivity.kt        # [Compose UI & Game State]
│   │   │       └── GameLogic.kt           # [Minimax Algorithm & Win/Draw Detection]
│   │   └── test/
│   │       └── java/com/HarshithMuthuluri/tictactoe/
│   │           └── GameLogicTest.kt       # [JUnit Unit Tests for AI & Rules]
├── build.gradle.kts
├── settings.gradle.kts
└── gradle/
    └── libs.versions.toml
```

## Author

**Harshith Muthuluri**

