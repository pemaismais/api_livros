package app.crud.controller;

import app.crud.entity.Venda;
import app.crud.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    VendaService vendaService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Venda venda) {
        try {
            Venda response = vendaService.create(venda);
            return ResponseEntity.ok(response);
        } catch (RuntimeException err) {
            return ResponseEntity.badRequest().body(err.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An unexpected error occurred");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Venda venda) {
        try{
            vendaService.update(id, venda);
            return ResponseEntity.ok("Venda de id: " + id +" foi updated");
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
            vendaService.delete(id);
            return ResponseEntity.ok("Venda de id: " + id +" foi deleted!");
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
            Venda response = vendaService.findById(id);
            return ResponseEntity.ok(response);
        }catch(RuntimeException err){
            return ResponseEntity.badRequest().body(err.getMessage());
        }
        catch(Exception e){
            return  ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        try {
            List<Venda> response = vendaService.findAll();
            return ResponseEntity.ok(response);
        } catch (RuntimeException err) {
            return ResponseEntity.badRequest().body(err.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An unexpected error occurred");
        }
    }
}
