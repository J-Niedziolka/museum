package edu.uph.ii.jn.museum.components;

import edu.uph.ii.jn.museum.models.Artwork;
import edu.uph.ii.jn.museum.repositories.ArtworkRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

@Configuration
public class InitializingArtwork {
    //private static final Logger LOG = Logger.getLogger(IntitiazingArtwork.class);
    private final ArtworkRepository artworkRepository;

    @Autowired
    public InitializingArtwork(ArtworkRepository artworkRepository){
        this.artworkRepository = artworkRepository;
    }

    @Bean
    InitializingBean init() {
        return () -> {
            if (artworkRepository.findAll().isEmpty()) {
                LocalDate date1 = LocalDate.of(2023, 2, 3);
                // create some Artwork objects and save them to the database using the repository
                Artwork artwork1 = new Artwork();
                artwork1.setId(1);
                artwork1.setTitle("obraz1");
                artwork1.setType("obraz");
                artwork1.setAuthor("Nowak");
                artwork1.setDate(date1);
                artwork1.setIfRenovation(true);
                artwork1.setExhibition(null);
                artwork1.setHistory("brak");
                artwork1.setIfExhibition(false);
                artwork1.setDetails(null);

                //Artwork artwork1 = new Artwork(1, date1, "obraz","pejzaż","nowak","brak",true,false,null,null);
//                Artwork artwork2 = new Artwork();
//                Artwork artwork3 = new Artwork();

                artworkRepository.save(artwork1);
//                artworkRepository.save(artwork2);
//                artworkRepository.save(artwork3);
            }
        };
    }
}
