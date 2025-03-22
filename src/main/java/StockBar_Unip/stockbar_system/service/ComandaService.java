package StockBar_Unip.stockbar_system.service;

import StockBar_Unip.stockbar_system.model.Cliente;
import StockBar_Unip.stockbar_system.model.Comanda;
import StockBar_Unip.stockbar_system.repository.ClienteRepository;
import StockBar_Unip.stockbar_system.repository.ComandaRepository;
import StockBar_Unip.stockbar_system.repository.ItemComandaRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ComandaService {

    private final ClienteRepository clienteRepository;
    private final ComandaRepository comandaRepository;
    private final ItemComandaRepository itemComandaRepository;

    public ComandaService(ClienteRepository clienteRepository, ComandaRepository comandaRepository, ItemComandaRepository itemComandaRepository) {
        this.clienteRepository = clienteRepository;
        this.comandaRepository = comandaRepository;
        this.itemComandaRepository = itemComandaRepository;
    }

    public Integer cadastrarComandaCliente(String nomeCliente) {
        // Busca o cliente ignorando caixa alta/baixa
        Cliente cliente = clienteRepository.findByNomeIgnoreCase(nomeCliente)
                .orElseGet(() -> {
                    Cliente novoCliente = new Cliente();
                    novoCliente.setNome(nomeCliente);
                    return clienteRepository.save(novoCliente);
                });

        // Verifica se já existe uma comanda para este cliente
        boolean comandaExistente = comandaRepository.existsByCliente(cliente);
        if (comandaExistente) {
            throw new IllegalArgumentException("Já existe uma comanda para o cliente: " + nomeCliente);
        }

        // Cria a nova comanda
        Comanda comanda = new Comanda();
        comanda.setCliente(cliente);
        comandaRepository.save(comanda);

        return comanda.getNumeroComanda();
    }

    public List<Comanda> listarComandas() {
        return comandaRepository.findAll();
    }

    public List<Map<String, Object>> listarComandasComTotal() {
        List<Comanda> comandas = comandaRepository.findAll();

        // Transforma cada comanda em um mapa com os detalhes necessários
        return comandas.stream().map(comanda -> {
            double total = comanda.getItens().stream()
                    .mapToDouble(item -> item.getQuantidade() * item.getBebida().getPrecoUnitario())
                    .sum();

            Map<String, Object> detalhes = new HashMap<>();
            detalhes.put("numeroComanda", comanda.getNumeroComanda());
            detalhes.put("cliente", comanda.getCliente().getNome());
            detalhes.put("total", total);
            detalhes.put("itens", comanda.getItens());
            return detalhes;
        }).toList();
    }

    public Map<String, Object> obterDetalhesComanda(Integer numeroComanda) {
        Comanda comanda = comandaRepository.findById(numeroComanda)
                .orElseThrow(() -> new IllegalArgumentException("Comanda não encontrada."));

        Double total = itemComandaRepository.calcularTotalPorComanda(numeroComanda);

        Map<String, Object> detalhes = new HashMap<>();
        detalhes.put("numeroComanda", comanda.getNumeroComanda());
        detalhes.put("cliente", comanda.getCliente().getNome());
        detalhes.put("total", total != null ? total : 0.0);

        return detalhes;
    }


}
