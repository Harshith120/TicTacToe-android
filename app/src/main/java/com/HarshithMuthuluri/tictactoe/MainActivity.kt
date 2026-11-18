package com.HarshithMuthuluri.tictactoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicTacToeGame()
        }
    }
}

@Composable
fun TicTacToeGame() {
    var board by remember { mutableStateOf(List(3) { MutableList(3) { "" } }) }
    var isPlayerTurn by remember { mutableStateOf(true) }
    var winner by remember { mutableStateOf<String?>(null) }
    var movesLeft by remember { mutableStateOf(9) }

    LaunchedEffect(isPlayerTurn) {
        if (!isPlayerTurn && winner == null && movesLeft > 0) {
            delay(400) // Small delay so human can see their move before AI plays
            val (aiRow, aiCol) = bestMove(board)
            val newBoard = board.map { it.toMutableList() }
            newBoard[aiRow][aiCol] = "O"
            board = newBoard
            movesLeft--
            winner = checkWinner(board)
            isPlayerTurn = true
        }
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Tic Tac Toe", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        Spacer(modifier = Modifier.height(20.dp))

        for (i in 0..2) {
            Row {
                for (j in 0..2) {
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .background(Color.LightGray, RoundedCornerShape(8.dp))
                            .clickable {
                                if (isPlayerTurn && board[i][j].isEmpty() && winner == null) {
                                    val newBoard = board.map { it.toMutableList() }
                                    newBoard[i][j] = "X"
                                    board = newBoard
                                    movesLeft--
                                    winner = checkWinner(board)
                                    isPlayerTurn = false
                                }
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = board[i][j],
                            fontSize = 36.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (board[i][j] == "X") Color.Blue else Color.Red
                        )
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
        }

        Spacer(modifier = Modifier.height(20.dp))
        when {
            winner != null -> {
                Text(
                    text = "$winner Wins!",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (winner == "X") Color.Blue else Color.Red
                )
            }
            movesLeft == 0 -> {
                Text(
                    text = "It's a Draw!",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
            }
            !isPlayerTurn -> {
                Text(
                    text = "AI is thinking...",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.DarkGray
                )
            }
            else -> {
                Text(
                    text = "Your Turn (X)",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.DarkGray
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            board = List(3) { MutableList(3) { "" } }
            isPlayerTurn = true
            winner = null
            movesLeft = 9
        }) {
            Text("Restart")
        }
    }
}
