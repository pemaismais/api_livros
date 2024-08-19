package app.crud.service;

import app.crud.entity.Revista;
import app.crud.repository.RevistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevistaService {
    @Autowired
    private RevistaRepository revistaRepository;

    public Revista create(Revista revista){
        try {
           return revistaRepository.save(revista);
        }catch(Exception e){
            throw new RuntimeException("Unable to create revista", e);
        }
    }
    public Revista update(Long id, Revista revista){
        revistaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find the revistao with id " + id));
        try {
            revista.setId(id);
            return  revistaRepository.save(revista);
        }catch(Exception e){
            throw new RuntimeException("Unable to update revistao", e);
        }
    }

    public void delete(Long id){
        if (!revistaRepository.existsById(id)) {
            throw new RuntimeException("Could not find the revistao with id " + id);
        }
        try{
            revistaRepository.deleteById(id);
        }catch(Exception e){
            throw new RuntimeException("Unable to delete revistao", e);
        }
    }

    public List<Revista> findAll(){
        try{
            return revistaRepository.findAll();
        }catch(Exception e){
            throw new RuntimeException("Unable to reach revistaos", e);
        }
    }

    public Revista findById(Long id){
        try{
            return revistaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Could not find the revistao with id " + id));

        }catch(RuntimeException e){
            throw e;
        }
        catch(Exception e){
            throw new RuntimeException("Unable to reach exercise", e);
        }
    }

}

