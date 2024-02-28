package com.example.TicTacToe.Service.Implementation;

import com.example.TicTacToe.Entity.GameEntity;
import com.example.TicTacToe.Entity.Matrix;
import com.example.TicTacToe.Service.Interface.TicTacToeInterface;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class TicTacToeImpl implements TicTacToeInterface {


        GameEntity gameEntity = new GameEntity("", "");

        Matrix matrix = new Matrix();

        int gamerFlag = 0;
        // 1 -> user one
        // 2 -> user Two


    @Override
    public void onBoardUser(String userOne, String userTwo) {
        gameEntity.setUserOne(userOne);
        gameEntity.setUserTwo(userTwo);
    }

    @Override
    public String inputGamerEntry(String gamer, int row, int column) {

        if (matrix.getMatrix()[row][column] != -1) {
            throw new RuntimeException("duplicate entry");
        }
         if (gamer.equals(gameEntity.getUserOne()) && gamerFlag == 1) {
             throw new RuntimeException(gameEntity.getUserTwo() + "turn");
         }
        if (gamer.equals(gameEntity.getUserTwo()) && gamerFlag == 2) {
            throw new RuntimeException(gameEntity.getUserOne() + "turn");
        }

        if (gamer.equals(gameEntity.getUserOne())) {
            matrix.setMatrix(row, column, 1);
            gamerFlag = 1;
        }
        else {
            matrix.setMatrix(row, column, 0);
            gamerFlag = 2;
        }

        Boolean win = checkWin(matrix.getMatrix(), row, column);
        if (win) return "Player" + gamer + "wins";
        return Arrays.deepToString(matrix.getMatrix());

    }

    public Boolean checkWin(int[][] matrix, int row, int column) {
           if( matrix[row][0] == matrix[row][1] && matrix[row][2] == matrix[row][1] ) return true;

           if(matrix[0][column] == matrix[1][column] && matrix[0][column] == matrix[2][column]) return true;

           if (row == column || (row == 0 && column == 2) || (row == 2 && column == 0)) {
               if (matrix[0][0] == matrix[1][1] &&  matrix[0][0] == matrix[2][2]) return true;
               return matrix[0][2] == matrix[1][1] && matrix[0][2] == matrix[2][0];
           }

           return false;
    }
}
