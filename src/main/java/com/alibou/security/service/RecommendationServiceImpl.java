package com.alibou.security.service;


import com.alibou.security.repository.RecommendationRepository;
import com.alibou.security.user.Recommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService{

    @Autowired
    private RecommendationRepository repository;

    @Override
    public List<Recommendation> getRecommendations() {
        return repository.findAll();
    }

    @Override
    public Recommendation updateRecommendation(Recommendation recommendation) throws IOException {
        return repository.save(recommendation);
    }

    @Override
    public void save(Recommendation recommendation) {
        repository.save(recommendation);
    }

    @Override
    public void delete(Recommendation recommendation) {
        repository.delete(recommendation);
    }

    @Override
    public Recommendation findById(int id) {
        return repository.findById(Long.valueOf(id)).get();
    }

}
