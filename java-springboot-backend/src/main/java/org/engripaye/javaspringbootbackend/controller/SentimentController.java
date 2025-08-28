package org.engripaye.javaspringbootbackend.controller;

import org.engripaye.javaspringbootbackend.model.SentimentResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/sentiment")
public class SentimentController {

    private final WebClient webClient = WebClient.create("http://localhost:8000");

    @GetMapping("/analyze")
    public SentimentResponse analyze(@RequestParam String text){
        return webClient.post()
                .uri("/analyze")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{\"text\": \"" + text + "\" }")
                .retrieve()
                .bodyToMono(SentimentResponse.class)
                .block();
    }
}
