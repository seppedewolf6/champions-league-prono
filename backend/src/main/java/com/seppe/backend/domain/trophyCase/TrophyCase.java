package com.seppe.backend.domain.trophyCase;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "trophy_case", uniqueConstraints = {@UniqueConstraint(columnNames = {"position"})})
public class TrophyCase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private int position; // 1, 2 of 3

    @Column(nullable = false)
    private String photoUrl;

    @Column(nullable = false)
    private String name;

    public TrophyCase() {}

    public TrophyCase(UUID id, int position, String photoUrl, String name) {
        this.id = id;
        this.position = position;
        this.photoUrl = photoUrl;
        this.name = name;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public int getPosition() { return position; }
    public void setPosition(int position) { this.position = position; }
    public String getPhotoUrl() { return photoUrl; }
    public void setPhotoUrl(String photoUrl) { this.photoUrl = photoUrl; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}