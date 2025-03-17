package com.pokemonreview.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity

public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String type;
//    public Pokemon(int id, String name, String type) {
//        this.id = id;
//        this.name = name;
//        this.type = type;
//    }

//    public Pokemon() {
//
//    }


    //Getters
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return (long) id;
    }

    public void setId(Long id) {
        this.id = Math.toIntExact(id);
    }
}
