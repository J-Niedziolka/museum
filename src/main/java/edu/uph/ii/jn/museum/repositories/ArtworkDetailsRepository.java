package edu.uph.ii.jn.museum.repositories;

import edu.uph.ii.jn.museum.models.ArtworkDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtworkDetailsRepository extends JpaRepository<ArtworkDetails, Long> {
}
