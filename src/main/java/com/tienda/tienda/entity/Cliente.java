package com.tienda.tienda.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;

@Data
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
