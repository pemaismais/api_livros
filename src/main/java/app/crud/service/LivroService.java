package app.crud.service;

import app.crud.entity.Livro;
import app.crud.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public Livro create(Livro livro) {
        try {
            return livroRepository.save(livro);
        }catch(Exception e){
            throw new RuntimeException("Unable to create livro", e);
        }
    }

    public Livro update(Long id,Livro livro){
        livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find the livro with id " + id));
        try {
            livro.setId(id);
            return  livroRepository.save(livro);
        }catch(Exception e){
            throw new RuntimeException("Unable to update livro", e);
        }
    }

    public void delete(Long id){
        if (!livroRepository.existsById(id)) {
            throw new RuntimeException("Could not find the livro with id " + id);
        }
        try{
            livroRepository.deleteById(id);
        }catch(Exception e){
            throw new RuntimeException("Unable to delete livro", e);
        }
    }

    public List<Livro> findAll(){
        try{
            return livroRepository.findAll();
        }catch(Exception e){
            throw new RuntimeException("Unable to reach livros", e);
        }
    }

    public Livro findById(Long id){
        try{
            return livroRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Could not find the livro with id " + id));

        }catch(RuntimeException e){
            throw e;
        }
        catch(Exception e){
            throw new RuntimeException("Unable to reach exercise", e);
        }
    }


}
