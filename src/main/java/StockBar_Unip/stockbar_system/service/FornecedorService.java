package StockBar_Unip.stockbar_system.service;

import StockBar_Unip.stockbar_system.model.Fornecedor;
import StockBar_Unip.stockbar_system.repository.FornecedorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public Fornecedor salvarFornecedor(Fornecedor fornecedor) {
        if (fornecedor.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome do fornecedor é obrigatório.");
        }
        if (fornecedor.getTelefone().isBlank()) {
            throw new IllegalArgumentException("O telefone do fornecedor é obrigatório.");
        }
        if (fornecedor.getEmail().isBlank()) {
            throw new IllegalArgumentException("O email do fornecedor é obrigatório.");
        }

        return fornecedorRepository.save(fornecedor);
    }

    public List<Fornecedor> consultarFornecedores() {
        return fornecedorRepository.findAll();
    }
}