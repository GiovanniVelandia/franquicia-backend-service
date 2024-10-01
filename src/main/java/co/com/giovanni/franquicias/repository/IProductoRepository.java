package co.com.giovanni.franquicias.repository;

import co.com.giovanni.franquicias.model.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * La interfaz IProductoRepository proporciona las operaciones CRUD para la entidad Producto.
 * @author GIOVANNI
 * @since 2024-09-30
 */
@Repository
public interface IProductoRepository extends CrudRepository<Producto, Long> {

    /**
     * Metodo en cargado de consultar los productos
     * @author GIOVANNI
     * @since 2024-09-30
     * @return List<Producto>
     */
    List<Producto> findAll();

    /**
     * Metodo en cargado de consultar los productos por una franquicia
     * @author GIOVANNI
     * @since 2024-09-30
     * @return List<Producto>
     */
    @Query("SELECT p FROM Producto p JOIN p.sucursal s WHERE s.franquicia.id = :idFranquicia")
    List<Producto> findByFranquicia(@Param("idFranquicia") Long idFranquicia);
}
