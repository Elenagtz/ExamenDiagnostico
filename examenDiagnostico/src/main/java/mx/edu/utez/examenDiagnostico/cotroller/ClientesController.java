package mx.edu.utez.examenDiagnostico.cotroller;

import lombok.AllArgsConstructor;
import mx.edu.utez.examenDiagnostico.model.dto.ClienteDto;
import mx.edu.utez.examenDiagnostico.model.entity.ClientesBean;
import mx.edu.utez.examenDiagnostico.service.impl.ClientesImpl;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class ClientesController {

    private final ClientesImpl clientesService;

    @PostMapping("/cliente")
    public ClienteDto create(@RequestBody ClienteDto clienteDto){
        ClientesBean clienteSave = clientesService.save(clienteDto);
        return clienteDto.builder()
                .id_cliente(clienteSave.getId_cliente())
                .nombre(clienteSave.getNombre())
                .apellidos(clienteSave.getApellidos())
                .curp(clienteSave.getCurp())
                .fecha_nac(clienteSave.getFecha_nac())
                .build();
    }

    @PutMapping("/cliente/{id}")
    public ClienteDto update(@RequestBody ClienteDto clienteDto){
        ClientesBean clienteUpdate = clientesService.save(clienteDto);
        return clienteDto.builder()
                .id_cliente(clienteUpdate.getId_cliente())
                .nombre(clienteUpdate.getNombre())
                .apellidos(clienteUpdate.getApellidos())
                .curp(clienteUpdate.getCurp())
                .fecha_nac(clienteUpdate.getFecha_nac())
                .build();
    }

    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<?> delete (@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
        try{
            ClientesBean clientes = clientesService.findById(id);
            clientesService.delete(clientes);
            return new ResponseEntity<>(clientes, HttpStatus.NO_CONTENT);
        } catch (DataAccessException ex){
            response.put("msj", ex.getMessage());
            response.put("Clientes", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/editoriales/{id}")
    public ClientesBean showById(@PathVariable Integer id){
        try {
            return clientesService.findById(id);
        } catch (DataAccessException dae) {
            throw new RuntimeException("Error en Base de Datos: ", dae);
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener la card: ", ex);
        }
    }

    @GetMapping("/editoriales")
    public List<ClientesBean> findAll() {
        try {
            return clientesService.findAll();
        } catch (DataAccessException dae) {
            throw new RuntimeException("Error en Base de Datos: ", dae);
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener la card: ", ex);
        }
    }

}
