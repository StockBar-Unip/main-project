package StockBar_Unip.stockbar_system.controller;

import StockBar_Unip.stockbar_system.model.Bebida;
import StockBar_Unip.stockbar_system.service.BebidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bebidas")
public class BebidaController {

    @Autowired
    private BebidaService bebidaService;

    // Endpoint para cadastrar uma nova bebida
    @PostMapping
    public ResponseEntity<Bebida> cadastrarBebida(@RequestBody Bebida bebida) {
        Bebida novaBebida = bebidaService.cadastrarBebida(bebida);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaBebida);
    }

    @GetMapping
    public ResponseEntity<List<Bebida>> listarBebidaes() {
        List<Bebida> bebidaesCadastrados = bebidaService.consultarBebidas();

        if (bebidaesCadastrados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(bebidaesCadastrados);
    }

}
