package com.alibou.security.service;


import com.alibou.security.user.Recommendation;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface RecommendationService {
    List<Recommendation> getRecommendations();

    Recommendation updateRecommendation(Recommendation recommendation) throws IOException;

    void save(Recommendation recommendation);

    void delete(Recommendation recommendation);

    Recommendation findById(int id);
}
