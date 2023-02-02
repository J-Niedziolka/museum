package edu.uph.ii.jn.museum.services;

import edu.uph.ii.jn.museum.models.ArtworkDetails;
import edu.uph.ii.jn.museum.repositories.ArtworkDetailsRepository;
import edu.uph.ii.jn.museum.repositories.ArtworkRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ArtworkDetailsService {
    private final ArtworkDetailsRepository artworkDetailsRepository;

    @Autowired
    public ArtworkDetailsService(ArtworkDetailsRepository artworkDetailsRepository){
        this.artworkDetailsRepository = artworkDetailsRepository;
    }

    public List<ArtworkDetails> findAllArtworkDetails(){
        return artworkDetailsRepository.findAll();
    }

    public ArtworkDetails findArtworkDetailsById(Long id){
        //TODO zmienic null na try catch
        return artworkDetailsRepository.findById(id).orElse(null);
    }

    public ArtworkDetails saveArtworkDetails(ArtworkDetails artworkDetails){
        return artworkDetailsRepository.save(artworkDetails);
    }
}
