package StockBar_Unip.stockbar_system.controller;

import StockBar_Unip.stockbar_system.service.ItemComandaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itens-comanda")
public class ItemComandaController {

    private final ItemComandaService itemComandaService;

    public ItemComandaController(ItemComandaService itemComandaService) {
        this.itemComandaService = itemComandaService;
    }

    @PostMapping
    public ResponseEntity<String> adicionarProdutoNaComanda(
            @RequestParam Integer idComanda,
            @RequestParam String nomeProduto,
            @RequestParam Integer quantidadeProduto) {
        itemComandaService.adicionarItemNaComanda(idComanda, nomeProduto, quantidadeProduto);
        return ResponseEntity.status(201).body("Produto adicionado com sucesso à comanda!");
    }
}