package StockBar_Unip.stockbar_system.service;

import StockBar_Unip.stockbar_system.model.Bebida;
import StockBar_Unip.stockbar_system.repository.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BebidaService {

    @Autowired
    private BebidaRepository bebidaRepository;

    public Bebida cadastrarBebida(Bebida bebida) {
        validarBebida(bebida);
        return bebidaRepository.save(bebida);
    }

    private void validarBebida(Bebida bebida) {
        if (bebida.getNome() == null || bebida.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da bebida é obrigatório.");
        }
        if (bebida.getQuantidadeEstoque() == null || bebida.getQuantidadeEstoque() < 0) {
            throw new IllegalArgumentException("A quantidade em estoque deve ser um valor positivo.");
        }
        if (bebida.getPrecoUnitario() == null || bebida.getPrecoUnitario() <= 0) {
            throw new IllegalArgumentException("O preço unitário deve ser maior que zero.");
        }
        if (bebida.getFornecedor() == null || bebida.getFornecedor().getId() == null) {
            throw new IllegalArgumentException("O fornecedor da bebida é obrigatório.");
        }
    }

    public List<Bebida> consultarBebidas() {
        return bebidaRepository.findAll();
    }
}
