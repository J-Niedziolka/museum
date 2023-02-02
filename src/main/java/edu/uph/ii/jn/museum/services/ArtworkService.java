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
        //TODO ZMIENIC NULL NA TRY CATCH
        return artworkRepository.findById(id).orElse(null);
    }

    public Artwork saveArtwork(Artwork artwork){
        return artworkRepository.save(artwork);
    }

    //TODO sprawdzić czy dodawac też metodę deleteArtwork
}
