package edu.uph.ii.jn.museum.repositories;

import edu.uph.ii.jn.museum.models.Exhibition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExhibitionRepository extends JpaRepository<Exhibition, Long> {
}
