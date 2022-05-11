package com.tienda.tienda.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cliente implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @NotNull
    private String dni;

    @NotNull
    private String nombre;

    @NotNull
    private String apellido1;

    private String apellido2;

    private String telefono;

}
