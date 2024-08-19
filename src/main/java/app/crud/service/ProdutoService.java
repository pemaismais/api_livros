package app.crud.service;

import app.crud.entity.Produto;
import app.crud.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> findAll(){
        try{
            return produtoRepository.findAll();
        }catch(Exception e){
            throw new RuntimeException("Unable to reach exercises", e);
        }
    }
}
