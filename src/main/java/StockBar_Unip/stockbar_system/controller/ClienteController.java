package StockBar_Unip.stockbar_system.controller;

import StockBar_Unip.stockbar_system.model.Cliente;
import StockBar_Unip.stockbar_system.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;


    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return ResponseEntity.ok(clienteSalvo);
    }


    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return ResponseEntity.ok(clientes);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Integer id) {
        return clienteRepository.findById(id)
                .map(cliente -> ResponseEntity.ok(cliente))
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/buscar-por-nome")
    public ResponseEntity<List<Cliente>> buscarClientePorNome(@RequestParam String nome) {
        List<Cliente> clientes = clienteRepository.findByNomeContainingIgnoreCase(nome);
        return ResponseEntity.ok(clientes);
    }
}
