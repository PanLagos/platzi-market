package com.platzi.platzimarket.persistence;

import com.platzi.platzimarket.persistence.entity.Producto;
import com.platzi.platzimarket.persistence.crud.ProductoCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getbyCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save (Producto producto){
        return  productoCrudRepository.save(producto);
    }

    public void delete (int idProduto){
        productoCrudRepository.deleteById(idProduto);
    }
}
