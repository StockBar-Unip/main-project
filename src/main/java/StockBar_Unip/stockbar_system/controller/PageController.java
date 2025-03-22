package StockBar_Unip.stockbar_system.controller;

import StockBar_Unip.stockbar_system.model.Comanda;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class PageController {

    Comanda comanda;

    @GetMapping("/comanda")
    public String comanda(){
        return "comanda";

    }@GetMapping("/consultaComanda")
    public String consultaComanda(){
        return "consultaComanda";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/cadastroBebidasEstoque")
    public String cadastroBebidasEstoque() {
        return "cadastroBebidasEstoque";
    }

    @GetMapping("/consultaEstoque")
    public String consultaEstoque() {
        return "consultaEstoque";
    }


    @GetMapping("/telaConsulta")
    public String telaConsulta() {
        return "telaConsulta";
    }

    @GetMapping("/cadastroProdutoComanda")
    public String cadastroProdutoComanda() {
        return "cadastroProdutoComanda";
    }

    @GetMapping("/cadastrarFornecedor")
    public String showForm() {
        return "cadastrarFornecedor";
    }

    @GetMapping("/cadastroClienteComanda")
    public String showCadastroClienteComanda() {
        return "cadastroClienteComanda";
    }

    @GetMapping("/consultaFornecedor")
    public String consultaFornecedor() {
    return "consultaFornecedor";
    }

}
