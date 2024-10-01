package co.com.giovanni.franquicias.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * La clase Franquicia representa una entidad que mapea a la tabla "franquicia" en la base de datos.
 * @author GIOVANNI
 * @since 2024-09-30
 */
@Getter
@Setter
@Entity
@Table(name = "franquicia")
public class Franquicia {

    @Id
    @Column(name = "id_franquicia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
}
