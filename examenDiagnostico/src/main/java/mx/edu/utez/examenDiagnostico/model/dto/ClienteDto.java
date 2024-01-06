package mx.edu.utez.examenDiagnostico.model.dto;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ClienteDto {

    private Integer id_cliente;
    private String nombre;
    private String apellidos;
    private String curp;
    private String fecha_nac;
}
