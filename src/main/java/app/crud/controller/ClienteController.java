package app.crud.controller;

import app.crud.entity.Cliente;
import app.crud.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Cliente cliente) {
        try {
            Cliente response = clienteService.create(cliente);
            return ResponseEntity.ok(response);
        } catch (RuntimeException err) {
            return ResponseEntity.badRequest().body(err.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An unexpected error occurred");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Cliente cliente) {
        try{
            clienteService.update(id, cliente);
            return ResponseEntity.ok("Cliente de id: " + id +" foi updated");
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
            clienteService.delete(id);
            return ResponseEntity.ok("Cliente de id: " + id +" foi deleted!");
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
            Cliente response = clienteService.findById(id);
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
            List<Cliente> response = clienteService.findAll();
            return ResponseEntity.ok(response);
        }catch(RuntimeException err){
            return ResponseEntity.badRequest().body(err.getMessage());
        }
        catch(Exception e){
            return  ResponseEntity.badRequest().build();
        }

    }
}
