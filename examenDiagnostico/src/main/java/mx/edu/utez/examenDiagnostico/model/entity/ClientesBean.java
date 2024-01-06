package mx.edu.utez.examenDiagnostico.model.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
@ToString
@Table(name = "clientes")
public class ClientesBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id_cliente;
    @Column(name = "nombre",nullable = false)
    private String nombre;
    @Column (name = "apellidos", nullable = false)
    private String apellidos;
    @Column (name = "curp",unique = true, nullable = false)
    private String curp;
    @Column (name = "fecha_nac", nullable = false)
    private String fecha_nac;


}
