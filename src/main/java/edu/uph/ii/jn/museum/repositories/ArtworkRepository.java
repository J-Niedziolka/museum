package edu.uph.ii.jn.museum.repositories;

import edu.uph.ii.jn.museum.models.Artwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ArtworkRepository extends JpaRepository<Artwork, Long> {
    //TODO dać wyszukiwanie - ostatnie zad z lab8
    List<Artwork> findByTitle(@Param("searchTitle") String searchTitle);

    List<Artwork> findByAuthorAndType(String author, String type);

    List<Artwork> findByDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
//  List<Person> findByEmailAddressAndLastname(EmailAddress emailAddress, String lastname);
}
