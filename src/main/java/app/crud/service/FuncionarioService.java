package app.crud.service;

import app.crud.entity.Funcionario;
import app.crud.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario create(Funcionario funcionario){
        try {
            return funcionarioRepository.save(funcionario);
        }catch(Exception e){
            throw new RuntimeException("Unable to create funcionario", e);
        }
    }
    public Funcionario update(Long id, Funcionario funcionario){
        funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find the funcionario with id " + id));
        try {
            funcionario.setId(id);
            return  funcionarioRepository.save(funcionario);
        }catch(Exception e){
            throw new RuntimeException("Unable to update funcionario", e);
        }
    }

    public void delete(Long id){
        if (!funcionarioRepository.existsById(id)) {
            throw new RuntimeException("Could not find the funcionario with id " + id);
        }
        try{
            funcionarioRepository.deleteById(id);
        }catch(Exception e){
            throw new RuntimeException("Unable to delete funcionario", e);
        }
    }

    public List<Funcionario> findAll(){
        try{
            return funcionarioRepository.findAll();
        }catch(Exception e){
            throw new RuntimeException("Unable to reach funcionarios", e);
        }
    }

    public Funcionario findById(Long id){
        try{
            return funcionarioRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Could not find the funcionario with id " + id));

        }catch(RuntimeException e){
            throw e;
        }
        catch(Exception e){
            throw new RuntimeException("Unable to reach exercise", e);
        }
    }
}

