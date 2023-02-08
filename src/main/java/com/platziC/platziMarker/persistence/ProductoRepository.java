package com.platziC.platziMarker.persistence;

import com.platziC.platziMarker.domain.repository.ProductRepository;
import com.platziC.platziMarker.persistence.crud.ProductoCrudRepository;
import com.platziC.platziMarker.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;



// @REpository nos indica que esta es la clase que interactua directamente con la base de datos
@Repository
public abstract class ProductoRepository implements ProductRepository {
    private ProductoCrudRepository productoCrudRepository;

    //1.Return all products
    public  List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll();
    }

    //2. Return a list of product to category in order asc
    public List<Producto> getByCategoria(int idCategoria) {
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    //3.Metodo para consultar productos escasos
    public Optional<List<Producto>> getEscasos(int cantidad) {
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    //4. Find a product record by its ID
    public Optional<Producto> getProducto(int idProducto) {
        return productoCrudRepository.findById(idProducto);
    }

    //5. Method save a product
    public Producto save(Producto producto) {
        return productoCrudRepository.save(producto);
    }

    //6. Delete a product
    public void delete(int idProducto) {
        productoCrudRepository.deleteById(idProducto);
    }
}
