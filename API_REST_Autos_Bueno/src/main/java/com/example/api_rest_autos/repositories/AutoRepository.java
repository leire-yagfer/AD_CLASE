package com.example.api_rest_autos.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.api_rest_autos.models.Auto;

import java.util.List;
@Repository
public interface AutoRepository extends JpaRepository<Auto, Integer> {
    /*
    La interfaz JpaRepository ofrece diferentes métodos implementados pos Spring Data
    que nos ayuda a manejar nuestros datos de la base de datos que hereda también
    de la interfaz CrudRepository sin necesidad de tener que implementarlo nosotros mismos

    La interfaz JpaRepository acepta dos genéricos como parámetros el primero de ellos representa
    la clase entidad y el segundo representa el tipo de clase utilizado cómo identificador primario.
     */
    List<Auto> findByMarca(String marca);
    List<Auto> findByColor(String color);
}

