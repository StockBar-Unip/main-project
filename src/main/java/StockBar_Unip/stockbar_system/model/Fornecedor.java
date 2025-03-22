package StockBar_Unip.stockbar_system.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "O nome do fornecedor é obrigatório.")
    private String nome;

    @NotBlank(message = "O telefone do fornecedor é obrigatório.")
    private String telefone;

    @NotBlank(message = "O email do fornecedor é obrigatório.")
    @Email(message = "O email informado é inválido.")
    private String email;

}
