package com.platzi.platzimarket.persistence.crud;

import com.platzi.platzimarket.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository <Producto, Integer>{

    //utilizando query nativa
    //@Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    //List<Producto> getByIdCategoria(int idCategoria);

    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
