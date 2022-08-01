package com.example.tourist.impl;

import com.example.tourist.Model.Tourist;
import com.example.tourist.Repository.TouristRepository;
import com.example.tourist.Service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TouristServiceImpl implements TouristService {

    @Autowired
    TouristRepository touristRepository;

    public List<Tourist> getAllTourists() {
        return touristRepository.findAll();
    }

    @Override
    public Tourist addTourist(Tourist tourist) {
        return touristRepository.save(tourist);
    }

    @Override
    public Tourist deleteTourist(Integer id) {
        Tourist tourist = touristRepository.findById(id).orElse(null);
        if (tourist != null) {
            touristRepository.delete(tourist);
            tourist.setId(null);
        }
        return tourist;
    }
}
