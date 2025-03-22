package StockBar_Unip.stockbar_system.repository;

import StockBar_Unip.stockbar_system.model.Cliente;
import StockBar_Unip.stockbar_system.model.Comanda;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComandaRepository extends JpaRepository<Comanda,Integer> {
    boolean existsByCliente(Cliente cliente);
    @EntityGraph(attributePaths = {"itens", "itens.bebida"})
    @Query("SELECT c FROM Comanda c")
    List<Comanda> findAllWithItens();

}
