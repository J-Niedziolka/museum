package edu.uph.ii.jn.museum.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "details")
public class ArtworkDetails {
    @Id
    private int id;
    private int price;
    private LocalDate returnDate;

    @OneToOne(mappedBy = "details")
    private Artwork artwork;

    public Artwork getArtwork() {
        return artwork;
    }

    public void setArtwork(Artwork artwork) {
        this.artwork = artwork;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
