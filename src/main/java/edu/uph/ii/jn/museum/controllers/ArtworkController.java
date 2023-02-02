package edu.uph.ii.jn.museum.controllers;

import edu.uph.ii.jn.museum.models.Artwork;
import edu.uph.ii.jn.museum.services.ArtworkService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController //restcontroller = controller + ResponseBody
@RequestMapping("/api/artworks")
public class ArtworkController {
    private final ArtworkService artworkService;

    @Autowired
    public ArtworkController(ArtworkService artworkService) {
        this.artworkService = artworkService;
    }

    @GetMapping
    public List<Artwork> getAllArtworks() {
        return artworkService.findAllArtworks();
    }

    @GetMapping("/{id}")
    public Artwork getArtworkById(@PathVariable Long id) {
        return artworkService.findArtworkById(id);
    }

    @PostMapping
    public Artwork createArtwork(@RequestBody Artwork artwork) {
        return artworkService.saveArtwork(artwork);
    }

    @PutMapping("/{id}")
    public Artwork updateArtwork(@PathVariable int id, @RequestBody Artwork artwork) {
        artwork.setId(id);
        return artworkService.saveArtwork(artwork);
    }

//    @DeleteMapping("/{id}")
//    public void deleteArtwork(@PathVariable Long id) {
//        artworkService.deleteArtworkById(id);
//    }
}
