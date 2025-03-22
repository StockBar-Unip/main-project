package StockBar_Unip.stockbar_system.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Bebida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private Integer quantidadeEstoque;
    private Double precoUnitario;

    @ManyToOne
    @JoinColumn(name = "fk_fornecedor")
    private Fornecedor fornecedor;
}
