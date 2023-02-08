package com.platziC.platziMarker.persistence.crud;
import com.platziC.platziMarker.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;



public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    //hecer el query de manera nativa
    //  @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true

    //Query  methods
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    //cantidad de stock menor y que esten activos
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
