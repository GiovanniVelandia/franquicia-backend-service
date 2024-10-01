package co.com.giovanni.franquicias.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * La clase Producto representa una entidad que mapea a la tabla "producto" en la base de datos.
 * @author GIOVANNI
 * @since 2024-09-30
 */
@Getter
@Setter
@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @Column(name = "id_producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Integer stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;
}
