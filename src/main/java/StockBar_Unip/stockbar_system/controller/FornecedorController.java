package StockBar_Unip.stockbar_system.controller;

import StockBar_Unip.stockbar_system.model.Fornecedor;
import StockBar_Unip.stockbar_system.service.FornecedorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    private final FornecedorService fornecedorService;

    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @PostMapping
    public ResponseEntity<Fornecedor> cadastrarFornecedor(@Valid @RequestBody Fornecedor fornecedor) {
        Fornecedor fornecedorCadastrado = fornecedorService.salvarFornecedor(fornecedor);
        return ResponseEntity.status(201).body(fornecedorCadastrado);
    }


    @GetMapping
    public ResponseEntity<List<Fornecedor>> listarFornecedores() {
        List<Fornecedor> fornecedoresCadastrados = fornecedorService.consultarFornecedores();

        if (fornecedoresCadastrados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(fornecedoresCadastrados);
    }

}
