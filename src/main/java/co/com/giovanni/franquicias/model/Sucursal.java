package co.com.giovanni.franquicias.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * La clase Sucursal representa una entidad que mapea a la tabla "sucursal" en la base de datos.
 * @author GIOVANNI
 * @since 2024-09-30
 */
@Getter
@Setter
@Entity
@Table(name = "sucursal")
public class Sucursal {

    @Id
    @Column(name = "id_sucursal")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_franquicia")
    private Franquicia franquicia;
}
