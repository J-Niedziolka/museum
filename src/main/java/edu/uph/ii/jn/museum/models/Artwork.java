package edu.uph.ii.jn.museum.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "artworks")
public class Artwork {
    @Id
    private int id;
    private LocalDate date;
    private String type;
    private String title;
    private String author;
    private String history;
    private Boolean ifExhibition;
    private Boolean ifRenovation;
    @OneToOne(cascade = CascadeType.ALL)  //TODO sprawdzić czy cascade = CascadeType.all
    @JoinColumn(name = "details_id", referencedColumnName = "id")
    private ArtworkDetails details;
    @ManyToOne
    @JoinColumn(name= "exhibitions_id")
    private Exhibition exhibition;

    public Artwork() {}

    public ArtworkDetails getDetails() {
        return details;
    }

    public void setDetails(ArtworkDetails details) {
        this.details = details;
    }

    public Exhibition getExhibition() {
        return exhibition;
    }

    public void setExhibition(Exhibition exhibition) {
        this.exhibition = exhibition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public Boolean getIfExhibition() {
        return ifExhibition;
    }

    public void setIfExhibition(Boolean ifExhibition) {
        this.ifExhibition = ifExhibition;
    }

    public Boolean getIfRenovation() {
        return ifRenovation;
    }

    public void setIfRenovation(Boolean ifRenovation) {
        this.ifRenovation = ifRenovation;
    }
}
