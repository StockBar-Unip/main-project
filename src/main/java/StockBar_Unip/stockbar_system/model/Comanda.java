package StockBar_Unip.stockbar_system.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Comanda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numeroComanda;

    @ManyToOne
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "comanda", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ItemComanda> itens;

}
