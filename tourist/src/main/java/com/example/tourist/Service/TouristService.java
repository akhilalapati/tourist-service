package com.example.tourist.Service;

import com.example.tourist.Model.Tourist;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TouristService {

    List<Tourist> getAllTourists();

    Tourist addTourist(Tourist tourist);

    Tourist deleteTourist(Integer id);
}
