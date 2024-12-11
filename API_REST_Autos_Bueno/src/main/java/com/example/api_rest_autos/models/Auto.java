package com.example.api_rest_autos.models;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "autos")
public class Auto {
    @Schema(description = "Identificador del Auto", example = "3", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Schema(description = "Marca del Auto", example = "Ford", required = true)
    @Column(nullable = false, length = 50)
    private String marca;


    @Schema(description = "Color del Auto", example = "Rojo", required = true)
    @Column(nullable = false, length = 50)
    private String color;


    public Auto() {

    }
    public Auto(int id, String marca, String color) {
        this.id = id;
        this.marca = marca;
        this.color = color;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
