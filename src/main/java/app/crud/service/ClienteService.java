package app.crud.service;

import app.crud.entity.Cliente;
import app.crud.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente create(Cliente cliente){
        try {
            return clienteRepository.save(cliente);
        }catch(Exception e){
            throw new RuntimeException("Unable to create cliente", e);
        }
    }
    public Cliente update(Long id, Cliente cliente){
        clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find the cliente with id " + id));
        try {
            cliente.setId(id);
            return  clienteRepository.save(cliente);
        }catch(Exception e){
            throw new RuntimeException("Unable to update cliente", e);
        }
    }

    public void delete(Long id){
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Could not find the cliente with id " + id);
        }
        try{
            clienteRepository.deleteById(id);
        }catch(Exception e){
            throw new RuntimeException("Unable to delete cliente", e);
        }
    }

    public List<Cliente> findAll(){
        try{
            return clienteRepository.findAll();
        }catch(Exception e){
            throw new RuntimeException("Unable to reach clientes", e);
        }
    }

    public Cliente findById(Long id){
        try{
            return clienteRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Could not find the cliente with id " + id));

        }catch(RuntimeException e){
            throw e;
        }
        catch(Exception e){
            throw new RuntimeException("Unable to reach exercise", e);
        }
    }
}
