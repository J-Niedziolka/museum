package edu.uph.ii.jn.museum.controllers;

import edu.uph.ii.jn.museum.models.Artwork;
import edu.uph.ii.jn.museum.services.ArtworkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController //restcontroller = controller + ResponseBody
@RequestMapping("/artworks")
public class ArtworkController {
    private final ArtworkService artworkService;

    @Autowired
    public ArtworkController(ArtworkService artworkService) {
        this.artworkService = artworkService;
    }

    @GetMapping
    public List<Artwork> getArtworks() {
        return artworkService.findAllArtworks();
    }

    @GetMapping("/{id}")
    public Artwork getArtwork(@PathVariable Long id) {
        return artworkService.findArtworkById(id);
    }

    @PostMapping
    public ResponseEntity createArtwork(@RequestBody Artwork artwork) throws URISyntaxException{
        Artwork savedArtwork = artworkService.saveArtwork(artwork);
        return ResponseEntity.created(new URI("/artworks/" + savedArtwork.getId())).body(savedArtwork);
    }

//    @PostMapping
//    public Artwork createArtwork(@RequestBody Artwork artwork) {
//        return artworkService.saveArtwork(artwork);
//    }
//
//    @PutMapping("/{id}")
//    public Artwork updateArtwork(@PathVariable int id, @RequestBody Artwork artwork) {
//        artwork.setId(id);
//        return artworkService.saveArtwork(artwork);
//    }

    @PutMapping("/{id}")
    public ResponseEntity updateArtwork(@PathVariable Long id, @RequestBody Artwork artwork){
        Artwork currentArtwork = artworkService.findArtworkById(id);
        currentArtwork.setId(artwork.getId());
        currentArtwork.setTitle(artwork.getTitle());
        currentArtwork.setAuthor(artwork.getAuthor());
        currentArtwork.setDate(artwork.getDate());
        currentArtwork.setHistory(artwork.getHistory());
        currentArtwork.setType(artwork.getType());

        currentArtwork.setIfRenovation(artwork.getIfRenovation());
        currentArtwork.setIfExhibition(artwork.getIfExhibition());

        currentArtwork.setDetails(artwork.getDetails());
        currentArtwork.setExhibition(artwork.getExhibition());

        currentArtwork = artworkService.saveArtwork(artwork);

        return  ResponseEntity.ok(currentArtwork);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteArtwork(@PathVariable Long id){
        artworkService.deleteArtwork(id);
        return ResponseEntity.ok().build();
    }

//    @DeleteMapping("/{id}")
//    public void deleteArtwork(@PathVariable Long id) {
//        artworkService.deleteArtworkById(id);
//    }
}
