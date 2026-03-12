package at.spengergasse.spring_thymeleaf.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Medikament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String hersteller;
    private LocalDate ablaufdatum;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    public LocalDate getAblaufdatum() {
        return ablaufdatum;
    }

    public void setAblaufdatum(LocalDate ablaufdatum) {
        this.ablaufdatum = ablaufdatum;
    }
}