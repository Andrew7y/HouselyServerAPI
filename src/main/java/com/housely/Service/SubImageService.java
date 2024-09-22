package com.housely.Service;

import com.housely.Model.Room.SubImageInRoom;
import com.housely.Repository.SubImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubImageService {
    private final SubImageRepository subImageRepository;

    public SubImageService(SubImageRepository subImageRepository) {
        this.subImageRepository = subImageRepository;
    }

    public List<SubImageInRoom> findAll() {
        return subImageRepository.findAll();
    }

    public SubImageInRoom save(SubImageInRoom subImage) {
        return subImageRepository.save(subImage);
    }

    public SubImageInRoom findById(String id) {
        return subImageRepository.findById(id).orElseThrow(() -> new RuntimeException("SubImage not found"));
    }

    public void deleteById(String id) {
        subImageRepository.deleteById(id);
    }
}
