package com.example.api_rest_autos.dtos;

/*
¿Qué es un Record en Java? Un record es esencialmente una clase
que define una estructura de datos con campos, pero a diferencia de una clase normal,
un record es inmutable (es decir, sus campos no pueden ser modificados una vez que se han inicializado).
 */
public record AutoDTO(int id, String marca, String color) {
}