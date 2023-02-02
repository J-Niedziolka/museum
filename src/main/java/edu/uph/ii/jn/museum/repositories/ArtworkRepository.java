package edu.uph.ii.jn.museum.repositories;

import edu.uph.ii.jn.museum.models.Artwork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtworkRepository extends JpaRepository<Artwork, Long> {
    //TODO dać wyszukiwanie - ostatnie zad z lab8
}
