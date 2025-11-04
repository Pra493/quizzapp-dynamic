package com.example.quizapp;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Welcome to Real-Time Quiz App!");
        return "index";
    }

    @MessageMapping("/sendQuestion")
    @SendTo("/topic/quiz")
    public String sendQuestion(String question) {
        return question;
    }
}