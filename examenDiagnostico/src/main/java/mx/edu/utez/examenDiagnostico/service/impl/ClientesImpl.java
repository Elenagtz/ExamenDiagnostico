package mx.edu.utez.examenDiagnostico.service.impl;

import lombok.AllArgsConstructor;
import mx.edu.utez.examenDiagnostico.model.dao.ClienteDao;
import mx.edu.utez.examenDiagnostico.model.dto.ClienteDto;
import mx.edu.utez.examenDiagnostico.model.entity.ClientesBean;
import mx.edu.utez.examenDiagnostico.service.IClientes;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor

public class ClientesImpl implements IClientes {
    private final ClienteDao clienteDao;

    @Override
    @Transactional
    public ClientesBean save (ClienteDto clientes){
        ClientesBean clientesBean = ClientesBean.builder()
                .id_cliente(clientes.getId_cliente())
                .nombre(clientes.getNombre())
                .apellidos(clientes.getApellidos())
                .curp(clientes.getCurp())
                .fecha_nac(clientes.getFecha_nac())
                .build();
        return clienteDao.save(clientesBean);
    }

    @Override
    @Transactional(readOnly = true)
    public ClientesBean findById(Integer id){
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional (readOnly = true)
    public List<ClientesBean> findAll(){
        return (List<ClientesBean>) clienteDao.findAll();
    }


    @Override
    @Transactional
    public void delete (ClientesBean clientesBean){
        clienteDao.delete(clientesBean);
    }

}

