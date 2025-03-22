package StockBar_Unip.stockbar_system.repository;

import StockBar_Unip.stockbar_system.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
    Optional<Cliente> findByNome(String nomeCliente);
    List<Cliente> findByNomeContainingIgnoreCase(String nome);

    Optional<Cliente> findByNomeIgnoreCase(String nomeCliente);
}
