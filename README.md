# StockBar System  

O **StockBar System** é uma aplicação desenvolvida para o controle de comandas e gerenciamento de estoque em bares e restaurantes. Construída com **Spring Boot**, a aplicação oferece funcionalidades essenciais para facilitar a administração do estabelecimento.  

---  

## 🚀 Funcionalidades  

### 🛒 Controle de Comandas  
- Cadastro e listagem de comandas.  
- Exibição detalhada dos itens consumidos, incluindo produto, quantidade, preço unitário e total dinâmico da comanda.  

### 📦 Gerenciamento de Estoque  
- Registro de fornecedores com nome, telefone e e-mail.  
- Cadastro de bebidas, incluindo nome, quantidade em estoque e preço unitário, associadas aos fornecedores.  
- Atualização automática do estoque conforme os produtos são consumidos.  

### 🔄 Mock de Dados  
- Geração automática de dados fictícios para testes ao iniciar a aplicação.  
- Carga inicial de fornecedores, clientes e bebidas populares (ex.: Cerveja Pilsen, Whisky, Caipirinha, Vodka, etc.).  

---  

## 🛠️ Tecnologias Utilizadas  
- **Java 21**  
- **Spring Boot 3.4.4**  
- **Spring Data JPA**  
- **Thymeleaf** (para renderização das páginas HTML)  
- **H2 Database** (para testes e desenvolvimento)  
- **Lombok** (para reduzir código boilerplate)  
- **Spring Boot Starter Validation e Test** (para validações e testes)  

---  

## ▶️ Como Executar  

1. **Clone o repositório:**  
   ```sh  
   git clone https://github.com/seu-usuario/stockbar-system.git  
   cd stockbar-system  
   ```  

2. **Verifique os requisitos:**  
   - Certifique-se de que **Java 21** e **Maven** estejam instalados e configurados corretamente.  

3. **Compile e execute a aplicação:**  
   ```sh  
   mvn spring-boot:run  
   ```  

4. **Acesse no navegador:**  
   - URL padrão: [http://localhost:8080](http://localhost:8080)  

> **Nota:** Ao iniciar a aplicação, os dados fictícios são carregados automaticamente pelo método `mocarDados()`.  

---  

## 📜 Licença  
Este projeto é de uso educacional e está aberto para melhorias. Para mais informações, consulte a equipe responsável.  

---  

## 📩 Contato  
Para dúvidas ou sugestões, abra uma **issue** no repositório ou entre em contato com a equipe do **StockBar System**.  

---  

**Desenvolvido com 💙 para otimizar a gestão de bares e restaurantes!** 🍻  

Se precisar de ajustes, só avisar! 🚀
