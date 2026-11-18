package com.HarshithMuthuluri.tictactoe

import kotlin.math.max
import kotlin.math.min

fun checkWinner(board: List<List<String>>): String? {
    for (i in 0..2) {
        if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0].isNotEmpty()) return board[i][0]
        if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i].isNotEmpty()) return board[0][i]
    }
    if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0].isNotEmpty()) return board[0][0]
    if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2].isNotEmpty()) return board[0][2]
    return null
}

fun bestMove(board: List<List<String>>): Pair<Int, Int> {
    var bestScore = Int.MIN_VALUE
    var move = Pair(0, 0)
    for (i in 0..2) {
        for (j in 0..2) {
            if (board[i][j].isEmpty()) {
                val newBoard = board.map { it.toMutableList() }
                newBoard[i][j] = "O"
                val score = minimax(newBoard, false)
                if (score > bestScore) {
                    bestScore = score
                    move = Pair(i, j)
                }
            }
        }
    }
    return move
}

fun minimax(board: List<List<String>>, isMaximizing: Boolean): Int {
    val winner = checkWinner(board)
    when (winner) {
        "X" -> return -10
        "O" -> return 10
    }
    if (board.flatten().none { it.isEmpty() }) return 0

    if (isMaximizing) {
        var bestScore = Int.MIN_VALUE
        for (i in 0..2) {
            for (j in 0..2) {
                if (board[i][j].isEmpty()) {
                    val newBoard = board.map { it.toMutableList() }
                    newBoard[i][j] = "O"
                    val score = minimax(newBoard, false)
                    bestScore = max(score, bestScore)
                }
            }
        }
        return bestScore
    } else {
        var bestScore = Int.MAX_VALUE
        for (i in 0..2) {
            for (j in 0..2) {
                if (board[i][j].isEmpty()) {
                    val newBoard = board.map { it.toMutableList() }
                    newBoard[i][j] = "X"
                    val score = minimax(newBoard, true)
                    bestScore = min(score, bestScore)
                }
            }
        }
        return bestScore
    }
}
