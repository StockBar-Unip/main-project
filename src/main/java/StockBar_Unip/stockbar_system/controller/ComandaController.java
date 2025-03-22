package StockBar_Unip.stockbar_system.controller;

import StockBar_Unip.stockbar_system.model.Comanda;
import StockBar_Unip.stockbar_system.service.ComandaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comandas")
public class ComandaController {

    private final ComandaService comandaService;

    public ComandaController(ComandaService comandaService) {
        this.comandaService = comandaService;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarComandaCliente(@RequestParam String nomeCliente) {
        try {
            Integer numeroComanda = comandaService.cadastrarComandaCliente(nomeCliente);
            return ResponseEntity.status(201).body(numeroComanda);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> listarComandas() {
        List<Map<String, Object>> comandas = comandaService.listarComandasComTotal();

        if (comandas.isEmpty()) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(comandas);
    }

    @GetMapping("/{numeroComanda}")
    public ResponseEntity<?> obterComanda(@PathVariable Integer numeroComanda) {
        Map<String, Object> detalhesComanda = comandaService.obterDetalhesComanda(numeroComanda);
        return ResponseEntity.ok(detalhesComanda);
    }

}


