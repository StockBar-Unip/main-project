package StockBar_Unip.stockbar_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ItemComanda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_comanda")
    @JsonIgnore
    private Comanda comanda;

    @ManyToOne
    @JoinColumn(name = "fk_bebida")
    private Bebida bebida;

    private Integer quantidade;
}
