package com.alibou.security.controller;


import com.alibou.security.service.RecommendationService;
import com.alibou.security.user.Recommendation;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @PostMapping("/api/recommendations" )
    public String addRecommendation(@RequestBody Recommendation recommendation) {
        if(recommendation.getSalary() < 1 || recommendation.getTitle().isEmpty() || recommendation.getDescription().isEmpty()) throw new IllegalArgumentException("все поля должны быть заполнены");
        recommendationService.save(recommendation);

        return "success-added";
    }

    @GetMapping("/api/recommendations")
    public List<Recommendation> getRecommendations() {
        return recommendationService.getRecommendations();
    }

    @PostMapping
    public String save(@ModelAttribute("recommendation") Recommendation recommendation) {
        recommendationService.save(recommendation);

        return "redirect:/recommendations/";
    }


    @PutMapping
    public String update(@ModelAttribute("recommendation") Recommendation recommendation) throws IOException {
        recommendationService.updateRecommendation(recommendation);

        return "redirect:/api/recommendations";
    }


    @DeleteMapping("/api/recommendations/{id}")
    public String delete(@PathVariable("id") int recommendation) {
        Recommendation recommendation1 = recommendationService.findById(recommendation);
        recommendationService.delete(recommendation1);

        return "OK";
    }

}
