package com.platzi.platzimarket.persistence;

import com.platzi.platzimarket.persistence.entity.Producto;
import com.platzi.platzimarket.persistence.crud.ProductoCrudRepostory;

import java.util.List;
import java.util.Optional;

public class ProductoRepository {
    private ProductoCrudRepostory productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getbyCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }
}
