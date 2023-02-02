package edu.uph.ii.jn.museum.services;

import edu.uph.ii.jn.museum.models.Artwork;
import edu.uph.ii.jn.museum.models.Exhibition;
import edu.uph.ii.jn.museum.repositories.ArtworkRepository;
import edu.uph.ii.jn.museum.repositories.ExhibitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExhibitionService {
    private final ExhibitionRepository exhibitionRepository;

    @Autowired
    public ExhibitionService(ExhibitionRepository exhibitionRepository){
        this.exhibitionRepository = exhibitionRepository;
    }

    public List<Exhibition> findAllExhibitions() {
        return exhibitionRepository.findAll();
    }

    public Exhibition findExhibitionById(Long id){
        //TODO zamienic null na try catch
        return exhibitionRepository.findById(id).orElse(null);
    }
    public Exhibition saveExhibition(Exhibition exhibition){
        return exhibitionRepository.save(exhibition);
    }
}

