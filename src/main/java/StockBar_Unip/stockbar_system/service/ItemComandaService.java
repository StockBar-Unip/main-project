package StockBar_Unip.stockbar_system.service;

import StockBar_Unip.stockbar_system.model.Bebida;
import StockBar_Unip.stockbar_system.model.Comanda;
import StockBar_Unip.stockbar_system.model.ItemComanda;
import StockBar_Unip.stockbar_system.repository.BebidaRepository;
import StockBar_Unip.stockbar_system.repository.ComandaRepository;
import StockBar_Unip.stockbar_system.repository.ItemComandaRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemComandaService {

    private final ComandaRepository comandaRepository;
    private final BebidaRepository bebidaRepository;
    private final ItemComandaRepository itemComandaRepository;

    public ItemComandaService(ComandaRepository comandaRepository, BebidaRepository bebidaRepository,
                              ItemComandaRepository itemComandaRepository) {
        this.comandaRepository = comandaRepository;
        this.bebidaRepository = bebidaRepository;
        this.itemComandaRepository = itemComandaRepository;
    }

    public void adicionarItemNaComanda(Integer idComanda, String nomeBebida, Integer quantidadeBebida) {
        Comanda comanda = comandaRepository.findById(idComanda)
                .orElseThrow(() -> new IllegalArgumentException("Comanda não encontrada."));

        Bebida bebida = bebidaRepository.findByNomeIgnoreCase(nomeBebida)
                .orElseThrow(() -> new IllegalArgumentException("Bebida não encontrada."));

        if (bebida.getQuantidadeEstoque() < quantidadeBebida) {
            throw new IllegalArgumentException("Estoque insuficiente para a bebida: " + bebida.getNome());
        }

        bebida.setQuantidadeEstoque(bebida.getQuantidadeEstoque() - quantidadeBebida);
        bebidaRepository.save(bebida);

        ItemComanda itemComanda = new ItemComanda();
        itemComanda.setComanda(comanda);
        itemComanda.setBebida(bebida);
        itemComanda.setQuantidade(quantidadeBebida);
        itemComandaRepository.save(itemComanda);
    }
}
