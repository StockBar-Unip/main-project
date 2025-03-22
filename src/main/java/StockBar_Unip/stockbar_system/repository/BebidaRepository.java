package StockBar_Unip.stockbar_system.repository;

import StockBar_Unip.stockbar_system.model.Bebida;
import StockBar_Unip.stockbar_system.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BebidaRepository extends JpaRepository<Bebida,Integer> {
    Optional<Bebida> findByNomeIgnoreCase(String nome);
}
