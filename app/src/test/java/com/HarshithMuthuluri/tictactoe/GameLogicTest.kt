package com.HarshithMuthuluri.tictactoe

import org.junit.Assert.*
import org.junit.Test

class GameLogicTest {

    @Test
    fun testCheckWinner_rowWin() {
        val boardX = listOf(
            mutableListOf("X", "X", "X"),
            mutableListOf("", "O", ""),
            mutableListOf("O", "", "")
        )
        assertEquals("X", checkWinner(boardX))

        val boardO = listOf(
            mutableListOf("X", "X", ""),
            mutableListOf("O", "O", "O"),
            mutableListOf("X", "", "")
        )
        assertEquals("O", checkWinner(boardO))
    }

    @Test
    fun testCheckWinner_columnWin() {
        val boardX = listOf(
            mutableListOf("X", "O", ""),
            mutableListOf("X", "O", ""),
            mutableListOf("X", "", "")
        )
        assertEquals("X", checkWinner(boardX))
    }

    @Test
    fun testCheckWinner_diagonalWin() {
        val boardO = listOf(
            mutableListOf("O", "X", ""),
            mutableListOf("X", "O", ""),
            mutableListOf("X", "", "O")
        )
        assertEquals("O", checkWinner(boardO))
    }

    @Test
    fun testCheckWinner_noWinner() {
        val board = listOf(
            mutableListOf("X", "O", ""),
            mutableListOf("", "X", ""),
            mutableListOf("", "", "O")
        )
        assertNull(checkWinner(board))
    }

    @Test
    fun testDrawCondition() {
        val drawBoard = listOf(
            mutableListOf("X", "O", "X"),
            mutableListOf("X", "O", "O"),
            mutableListOf("O", "X", "X")
        )
        assertNull(checkWinner(drawBoard))
        assertTrue(drawBoard.flatten().none { it.isEmpty() })
    }

    @Test
    fun testAiNeverLoses_blocksWinningMove() {
        // If X has two in a row, AI (O) must block at (0, 2)
        val board = listOf(
            mutableListOf("X", "X", ""),
            mutableListOf("O", "", ""),
            mutableListOf("", "", "")
        )
        val (row, col) = bestMove(board)
        assertEquals(Pair(0, 2), Pair(row, col))
    }

    @Test
    fun testAiNeverLoses_takesWinningMove() {
        // If O has two in a row, O should win at (0, 2)
        val board = listOf(
            mutableListOf("O", "O", ""),
            mutableListOf("X", "X", ""),
            mutableListOf("", "", "")
        )
        val (row, col) = bestMove(board)
        assertEquals(Pair(0, 2), Pair(row, col))
    }
}
