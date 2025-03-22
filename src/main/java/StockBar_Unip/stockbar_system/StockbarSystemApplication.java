package StockBar_Unip.stockbar_system;

import StockBar_Unip.stockbar_system.model.*;
import StockBar_Unip.stockbar_system.repository.BebidaRepository;
import StockBar_Unip.stockbar_system.repository.ClienteRepository;
import StockBar_Unip.stockbar_system.repository.ComandaRepository;
import StockBar_Unip.stockbar_system.repository.FornecedorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import jakarta.transaction.Transactional;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class StockbarSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockbarSystemApplication.class, args);
    }

    @Bean
    CommandLineRunner run(FornecedorRepository fornecedorRepository,
                          BebidaRepository bebidaRepository,
                          ClienteRepository clienteRepository,
                          ComandaRepository comandaRepository) {
        return args -> {
            mocarDados(fornecedorRepository, bebidaRepository, clienteRepository, comandaRepository);
        };
    }

    @Transactional
    public static void mocarDados(FornecedorRepository fornecedorRepository,
                                  BebidaRepository bebidaRepository,
                                  ClienteRepository clienteRepository,
                                  ComandaRepository comandaRepository) {

        // Mocando fornecedores
        Fornecedor fornecedor1 = new Fornecedor();
        fornecedor1.setNome("Distribuidora ABC");
        fornecedor1.setTelefone("11987654321");
        fornecedor1.setEmail("contato@abc.com");
        fornecedorRepository.save(fornecedor1);

        Fornecedor fornecedor2 = new Fornecedor();
        fornecedor2.setNome("Bebidas Express");
        fornecedor2.setTelefone("21987654322");
        fornecedor2.setEmail("contato@express.com");
        fornecedorRepository.save(fornecedor2);

        Fornecedor fornecedor3 = new Fornecedor();
        fornecedor3.setNome("Cervejaria Nacional");
        fornecedor3.setTelefone("31987654323");
        fornecedor3.setEmail("contato@cervejaria.com");
        fornecedorRepository.save(fornecedor3);

        // Mocando bebidas
        Bebida bebida1 = new Bebida();
        bebida1.setNome("Cerveja Pilsen");
        bebida1.setQuantidadeEstoque(1000);
        bebida1.setPrecoUnitario(5.99);
        bebida1.setFornecedor(fornecedor3);
        bebidaRepository.save(bebida1);

        Bebida bebida2 = new Bebida();
        bebida2.setNome("Cerveja IPA");
        bebida2.setQuantidadeEstoque(500);
        bebida2.setPrecoUnitario(7.99);
        bebida2.setFornecedor(fornecedor3);
        bebidaRepository.save(bebida2);

        Bebida bebida3 = new Bebida();
        bebida3.setNome("Whisky 12 anos");
        bebida3.setQuantidadeEstoque(300);
        bebida3.setPrecoUnitario(159.99);
        bebida3.setFornecedor(fornecedor1);
        bebidaRepository.save(bebida3);

        Bebida bebida4 = new Bebida();
        bebida4.setNome("Whisky 18 anos");
        bebida4.setQuantidadeEstoque(200);
        bebida4.setPrecoUnitario(299.99);
        bebida4.setFornecedor(fornecedor1);
        bebidaRepository.save(bebida4);

        Bebida bebida5 = new Bebida();
        bebida5.setNome("Batida de Coco");
        bebida5.setQuantidadeEstoque(800);
        bebida5.setPrecoUnitario(14.99);
        bebida5.setFornecedor(fornecedor2);
        bebidaRepository.save(bebida5);

        Bebida bebida6 = new Bebida();
        bebida6.setNome("Batida de Maracujá");
        bebida6.setQuantidadeEstoque(600);
        bebida6.setPrecoUnitario(16.99);
        bebida6.setFornecedor(fornecedor2);
        bebidaRepository.save(bebida6);

        Bebida bebida7 = new Bebida();
        bebida7.setNome("Caipirinha Tradicional");
        bebida7.setQuantidadeEstoque(400);
        bebida7.setPrecoUnitario(12.99);
        bebida7.setFornecedor(fornecedor2);
        bebidaRepository.save(bebida7);

        Bebida bebida8 = new Bebida();
        bebida8.setNome("Vodka Importada");
        bebida8.setQuantidadeEstoque(300);
        bebida8.setPrecoUnitario(89.99);
        bebida8.setFornecedor(fornecedor1);
        bebidaRepository.save(bebida8);

        // Mocando clientes
        Cliente cliente1 = new Cliente();
        cliente1.setNome("Camila Eiko");
        clienteRepository.save(cliente1);

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Leticia Moura");
        clienteRepository.save(cliente2);

        Cliente cliente3 = new Cliente();
        cliente3.setNome("Rafael Luna");
        clienteRepository.save(cliente3);

        // Mocando comandas e itens
        Comanda comanda1 = new Comanda();
        comanda1.setCliente(cliente1);

        ItemComanda itemComanda1 = new ItemComanda();
        itemComanda1.setComanda(comanda1);
        itemComanda1.setBebida(bebida1); // Cerveja Pilsen
        itemComanda1.setQuantidade(20);

        ItemComanda itemComanda2 = new ItemComanda();
        itemComanda2.setComanda(comanda1);
        itemComanda2.setBebida(bebida3); // Whisky 12 anos
        itemComanda2.setQuantidade(5);

        comanda1.setItens(Arrays.asList(itemComanda1, itemComanda2));
        comandaRepository.save(comanda1);

        Comanda comanda2 = new Comanda();
        comanda2.setCliente(cliente2);

        ItemComanda itemComanda3 = new ItemComanda();
        itemComanda3.setComanda(comanda2);
        itemComanda3.setBebida(bebida6); // Batida de Maracujá
        itemComanda3.setQuantidade(10);

        comanda2.setItens(Collections.singletonList(itemComanda3));
        comandaRepository.save(comanda2);

        Comanda comanda3 = new Comanda();
        comanda3.setCliente(cliente3);
        comandaRepository.save(comanda3);

        System.out.println("Dados fictícios mocados com sucesso!");
    }
}
