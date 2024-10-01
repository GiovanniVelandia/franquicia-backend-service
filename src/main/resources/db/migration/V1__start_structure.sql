
CREATE SEQUENCE franquicia_id_franquicia_seq;

CREATE TABLE franquicia (
                            id_franquicia BIGINT NOT NULL DEFAULT nextval('franquicia_id_franquicia_seq'),
                            nombre VARCHAR(50) NOT NULL,
                            CONSTRAINT id_franquicia PRIMARY KEY (id_franquicia)
);


ALTER SEQUENCE franquicia_id_franquicia_seq OWNED BY franquicia.id_franquicia;

CREATE SEQUENCE sucursal_id_sucursal_seq;

CREATE TABLE sucursal (
                          id_sucursal INTEGER NOT NULL DEFAULT nextval('sucursal_id_sucursal_seq'),
                          nombre VARCHAR(50) NOT NULL,
                          id_franquicia BIGINT NOT NULL,
                          CONSTRAINT id_sucursal PRIMARY KEY (id_sucursal)
);


ALTER SEQUENCE sucursal_id_sucursal_seq OWNED BY sucursal.id_sucursal;

CREATE SEQUENCE producto_id_producto_seq;

CREATE SEQUENCE producto_nombre_seq;

CREATE TABLE producto (
                          id_producto BIGINT NOT NULL DEFAULT nextval('producto_id_producto_seq'),
                          nombre VARCHAR(50) NOT NULL DEFAULT nextval('producto_nombre_seq'),
                          stock INTEGER NOT NULL,
                          id_sucursal INTEGER NOT NULL,
                          CONSTRAINT id_producto PRIMARY KEY (id_producto)
);


ALTER SEQUENCE producto_id_producto_seq OWNED BY producto.id_producto;

ALTER SEQUENCE producto_nombre_seq OWNED BY producto.nombre;

ALTER TABLE sucursal ADD CONSTRAINT franquicia_sucursal_fk
    FOREIGN KEY (id_franquicia)
        REFERENCES franquicia (id_franquicia)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE producto ADD CONSTRAINT sucursal_producto_fk
    FOREIGN KEY (id_sucursal)
        REFERENCES sucursal (id_sucursal)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;