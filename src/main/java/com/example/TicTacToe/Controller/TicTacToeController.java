package com.example.TicTacToe.Controller;


import com.example.TicTacToe.Service.Interface.TicTacToeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicTacToeController {

    @Autowired
    private TicTacToeInterface ticTacToeInterface;


    @PostMapping("/onboard-players")
    public void onBoardUser(@RequestParam String userOne, @RequestParam String userTwo) {
         ticTacToeInterface.onBoardUser(userOne, userTwo);
    }

    @PutMapping("/input-entry")
    public String inputGamerEntry(@RequestParam String gamer,@RequestParam  int row, @RequestParam int column) {
       return ticTacToeInterface.inputGamerEntry(gamer, row,  column);
    }
}
