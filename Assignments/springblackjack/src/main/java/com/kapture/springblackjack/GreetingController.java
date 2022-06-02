package com.kapture.springblackjack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("game")
public class GreetingController {

    @GetMapping("/")
    public String greetingForm(Model m) {
        Game g = new Game();
        int condition = g.init();
        m.addAttribute("game", g);

        switch (condition) {
            case -1:
                m.addAttribute("result", "Dealer wins!");
                return "result";
            case 1:
                m.addAttribute("result", "You win!");
                return "result";
        }
        return "game";
    }

    @PostMapping("/player")
    public String playerStage(Model model, HttpSession session) {
        Game g = (Game) session.getAttribute("game");
        boolean playerWins = g.playerStage();
        model.addAttribute("game", g);

        if (!playerWins) {
            model.addAttribute("result", "Dealer Wins!");
            return "result";
        }
        return "game";
    }

    @PostMapping("/dealer")
    public String dealerStage(Model m, HttpSession session) {
        Game game = (Game) session.getAttribute("game");
        boolean dealerWins = game.dealerStage();

        if (!dealerWins) {
            m.addAttribute("result", "You win!");
            return "result";
        }

        int condition = game.getResult();
        switch (condition) {
            case -1:
                m.addAttribute("result", "Dealer wins!");
                break;
            case 0:
                m.addAttribute("result", "Draw, but the draw goes to Dealer. So dealer wins!");
                break;
            case 1:
                m.addAttribute("result", "You win!");
                break;
        }
        return "result";
    }

}