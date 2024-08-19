package app.crud.service;

import app.crud.entity.ItemVenda;
import app.crud.entity.Produto;
import app.crud.entity.Venda;
import app.crud.repository.ProdutoRepository;
import app.crud.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {
    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    private void calcularVenda(Venda venda){
        double total = 0;
        for (ItemVenda itemVenda : venda.getItensVenda()){
            Produto produto = produtoRepository
                    .findById(
                            itemVenda.getProduto()
                                    .getId())
                    .get();

            total += produto.getPreco() * itemVenda.getQuantidade();

        }
        venda.setValorTotal(total);
    }
    private void validarVenda(Venda venda){
        if(venda.getItensVenda().isEmpty()){
            throw new RuntimeException("Itens da venda não pode estar vazia.");
        }
        calcularVenda(venda);
        if( venda.getCliente().getIdade() <18 && venda.getValorTotal() >500){
            throw new RuntimeException("Valor máximo de venda para menor de idade excedido idk");
        }
        for(ItemVenda itemVenda : venda.getItensVenda() ){
            if (itemVenda.getQuantidade() <= 0 ){
                throw new RuntimeException("Quantidade invalida");
            }
        }
    }

    public Venda create(Venda venda){
        try {
            validarVenda(venda);
            for(ItemVenda itemVenda: venda.getItensVenda() ){
                itemVenda.setVenda(venda);
            }

            return vendaRepository.save(venda);
        }
        catch(RuntimeException e){
            throw e;
        }
        catch(Exception e){
            throw new RuntimeException("Unable to create venda", e);
        }
    }
    public Venda update(Long id, Venda venda){
        vendaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find the venda with id " + id));
        try {
            venda.setId(id);
            return  vendaRepository.save(venda);
        }catch(Exception e){
            throw new RuntimeException("Unable to update venda", e);
        }
    }

    public void delete(Long id){
        if (!vendaRepository.existsById(id)) {
            throw new RuntimeException("Could not find the venda with id " + id);
        }
        try{
            vendaRepository.deleteById(id);
        }catch(Exception e){
            throw new RuntimeException("Unable to delete venda", e);
        }
    }


    public Venda findById(Long id){
        try{
            return vendaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Could not find the venda with id " + id));

        }catch(RuntimeException e){
            throw e;
        }
        catch(Exception e){
            throw new RuntimeException("Unable to reach exercise", e);
        }
    }

    public List<Venda> findAll(){
        try{
            return vendaRepository.findAll();
        }  catch(Exception e){
            throw new RuntimeException("Unable to create venda", e);
        }
    }
}