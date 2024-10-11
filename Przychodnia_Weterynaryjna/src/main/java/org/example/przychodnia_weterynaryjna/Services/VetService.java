package org.example.przychodnia_weterynaryjna.Services;

import org.example.przychodnia_weterynaryjna.DTOs.VetArticleDto;
import org.example.przychodnia_weterynaryjna.Repositories.VetRepository;
import org.springframework.stereotype.Service;

@Service
public class VetService {

    private VetRepository vetRepository;

    public VetService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

//    public VetArticleDto getVetArticle(){
//        return vetRepository.find
//    }
}
