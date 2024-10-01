package co.com.giovanni.franquicias.repository;

import co.com.giovanni.franquicias.model.Franquicia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * La interfaz IFranquiciaRepository proporciona las operaciones CRUD para la entidad Franquicia.
 * @author GIOVANNI
 * @since 2024-09-30
 */
@Repository
public interface IFranquiciaRepository extends CrudRepository<Franquicia, Long> {
}
