package app.crud.controller;

import app.crud.entity.Funcionario;
import app.crud.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Funcionario funcionario) {
        try {
            Funcionario response = funcionarioService.create(funcionario);
            return ResponseEntity.ok(response);
        } catch (RuntimeException err) {
            return ResponseEntity.badRequest().body(err.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An unexpected error occurred");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        try{
            funcionarioService.update(id, funcionario);
            return ResponseEntity.ok("Funcionario de id: " + id +" foi updated");
        }catch(RuntimeException err){
            return ResponseEntity.badRequest().body(err.getMessage());
        }
        catch(Exception e){
            return  ResponseEntity.badRequest().body("An unexpected error occurred");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try{
            funcionarioService.delete(id);
            return ResponseEntity.ok("Funcionario de id: " + id +" foi deleted!");
        }catch(RuntimeException err){
            return ResponseEntity.badRequest().body(err.getMessage());
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body("An unexpected error occurred");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        try {
            Funcionario response = funcionarioService.findById(id);
            return ResponseEntity.ok(response);
        }catch(RuntimeException err){
            return ResponseEntity.badRequest().body(err.getMessage());
        }
        catch(Exception e){
            return  ResponseEntity.badRequest().build();
        }
    }
    @GetMapping
    public ResponseEntity<?> getAll(){
        try {
            List<Funcionario> response = funcionarioService.findAll();
            return ResponseEntity.ok(response);
        }catch(RuntimeException err){
            return ResponseEntity.badRequest().body(err.getMessage());
        }
        catch(Exception e){
            return  ResponseEntity.badRequest().build();
        }

    }
}
