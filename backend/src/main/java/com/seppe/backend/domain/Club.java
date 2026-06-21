package com.seppe.backend.domain;

import java.util.UUID;

public class Club {
    private UUID id;
    private String name;
    private int pot;
    private double coefficient;

    public Club(UUID id, String name, int pot, double coefficient) {
        this.id = id;
        this.name = name;
        this.pot = pot;
        this.coefficient = coefficient;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPot() {
        return pot;
    }

    public void setPot(int pot) {
        this.pot = pot;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }
}
