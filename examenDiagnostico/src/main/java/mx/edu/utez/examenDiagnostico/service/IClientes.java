package mx.edu.utez.examenDiagnostico.service;

import mx.edu.utez.examenDiagnostico.model.dto.ClienteDto;
import mx.edu.utez.examenDiagnostico.model.entity.ClientesBean;

import java.util.List;

public interface IClientes {
    ClientesBean save (ClienteDto clientes);
    ClientesBean findById(Integer id);
    void delete (ClientesBean clientesBean);
    List<ClientesBean> findAll();
}
