package edu.uph.ii.jn.museum.services;

import edu.uph.ii.jn.museum.models.Artwork;
import edu.uph.ii.jn.museum.repositories.ArtworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtworkService {
    private final ArtworkRepository artworkRepository;

    @Autowired
    public ArtworkService(ArtworkRepository artworkRepository){
        this.artworkRepository = artworkRepository;
    }

    public List<Artwork> findAllArtworks(){
        return artworkRepository.findAll();
    }

    public Artwork findArtworkById(Long id){
        //TODO sprawdzic to
        return artworkRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Artwork saveArtwork(Artwork artwork){
        return artworkRepository.save(artwork);
    }

    public void deleteArtwork(Long id){
        this.artworkRepository.deleteById(id);
    }
}
