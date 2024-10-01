package co.com.giovanni.franquicias.repository;

import co.com.giovanni.franquicias.model.Sucursal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * La interfaz ISucursalRepository proporciona las operaciones CRUD para la entidad Sucursal.
 * @author GIOVANNI
 * @since 2024-09-30
 */
@Repository
public interface ISucursalRepository extends CrudRepository<Sucursal, Integer> {
}
