package StockBar_Unip.stockbar_system.repository;

import StockBar_Unip.stockbar_system.model.ItemComanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemComandaRepository extends JpaRepository<ItemComanda,Integer> {

    @Query("SELECT SUM(ic.quantidade * ic.bebida.precoUnitario) " +
            "FROM ItemComanda ic " +
            "WHERE ic.comanda.numeroComanda = :numeroComanda")
    Double calcularTotalPorComanda(@Param("numeroComanda") Integer numeroComanda);
}
