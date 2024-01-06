package mx.edu.utez.examenDiagnostico.model.dao;

import mx.edu.utez.examenDiagnostico.model.entity.ClientesBean;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<ClientesBean, Integer> {
}
