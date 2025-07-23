# sistema-de-loja

EQUIPE RESPONSÁVEL: Brenno Phelipe Silva dos Santos, Sibele Oliveira Cruz e Silas Santos da Silva.

# Sistema de Gerenciamento de Vendas em Console

Este é um projeto de um sistema de gerenciamento de vendas e estoque, desenvolvido em Java e executado via console. O sistema permite cadastrar e gerenciar clientes e produtos, além de criar notas de compra, simulando um ambiente básico de ponto de venda. O principal objetivo do projeto é aplicar os conceitos fundamentais de **Programação Orientada a Objetos (POO)** absorvidos durante a disciplina.

## Entre as funcionalidades presentes no projeto, estão: 

  * **Gerenciamento de Produtos:**
      * Cadastrar produtos de diferentes tipos (Físico, Digital, Perecível).
      * Alterar o nome, o preço base ou a quantidade de um produto.
      * Listar todos os produtos em estoque, com a opção de filtrar por tipo.
  * **Gerenciamento de Clientes:**
      * Cadastrar clientes do tipo Pessoa Física (com CPF) ou Pessoa Jurídica (com CNPJ).
      * Alterar o telefone ou o endereço de um cliente já cadastrado.
      * Listar todos os clientes cadastrados, exibindo seus dados específicos.
  * **Vendas:**
      * Criar uma nota de compra associada a um cliente existente.
      * Adicionar múltiplos produtos e suas respectivas quantidades à nota.
      * O sistema valida a quantidade em estoque antes de permitir a adição de um item a uma nota.
      * A quantidade do produto em estoque é abatida no momento em que o item é adicionado à nota.
      * Listar todas as notas de compra emitidas, com um resumo detalhado de cada uma.

## Como Executar o Projeto

1.  Certifique-se de que você tem o **JDK (Java Development Kit)** instalado em sua máquina.
2.  Clone ou faça o download deste repositório.
3.  Abra um terminal ou prompt de comando na pasta raiz do projeto.
4.  Compile todos os arquivos `.java` usando o seguinte comando:
    ```bash
    javac Main.java */*.java
    ```
5.  Execute a classe principal para iniciar o programa:
    ```bash
    java Main
    ```
6.  O menu principal será exibido no console, e você poderá interagir digitando as opções numéricas desejadas.

## Lógica 

A construção do projeto foi pensada para ser modular e extensível, separando responsabilidades em diferentes pacotes (`produto`, `cliente`, `armazenamento`, `ui`, `nota`), fazendo o uso inteligente de conceitos de POO, detalhados a seguir.

### 1\. Classes Abstratas: A Base de Tudo

As classes abstratas foram utilizadas como "contratos" ou "moldes" para definir atributos e comportamentos comuns, garantindo uma estrutura coesa e evitando a duplicação de código.

  * `Armazenamento.java`: Define a lógica básica para as classes de armazenamento: uma capacidade máxima (`MAX`) e um contador de itens (`estoque`). Isso cria um padrão para todas as entidades que precisam ser "guardadas" em memória.
  * `Cliente.java`: Define o que todo cliente deve ter: `id`, `nome`, `endereco` e `telefone`. Ela força que qualquer classe que a estenda implemente o método `getTipo()`. Isso é crucial, pois não faz sentido criar um "cliente genérico"; ele precisa ser especializado (Pessoa Física ou Jurídica).
  * `Produto.java`: Define os atributos essenciais de um produto (`id`, `quantidade`, `nome`, `precoBase`) e força as subclasses a implementarem os métodos `getEspecifico()` e `getTipo()`.

### 2\. Herança: A Especialização

A herança permite que uma classe (filha) herde os atributos e métodos de outra (pai), possibilitando a criação de classes mais específicas e especializadas.

  * **Clientes:** As classes `PessoaFisica` e `PessoaJuridica` herdam de `Cliente`.

      * Elas reutilizam todos os atributos e métodos básicos de `Cliente`.
      * Cada uma adiciona seu atributo específico: `cpf` para `PessoaFisica` e `cnpj` para `PessoaJuridica`.

  * **Produtos:** `ProdutoFisico`, `ProdutoDigital` e `ProdutoPerecivel` herdam de `Produto`.

      * Elas adicionam seus atributos específicos (`peso`, `tamanhoKB`, `validadeDias`) e implementam o método `getEspecifico()` para retornar esse valor particular, demonstrando polimorfismo.

Essa estrutura torna o sistema flexível. Se no futuro for necessário criar um novo tipo de produto, bastaria criar uma nova classe herdando de `Produto`, sem a necessidade de alterar o código já existente que manipula produtos.

### 3\. Interface: Definindo um Contrato de Comportamento

A interface `Menu.java` define um contrato simples: qualquer classe que a implemente *deve* fornecer uma implementação para o método `play()`.

  * `ConsoleMenu.java` implementa a interface `Menu`, provendo a lógica do menu interativo no console.
  * **Relevância:** Essa abordagem desacopla a lógica de inicialização do programa (`Main.java`) da implementação específica do menu. Se quiséssemos substituir o menu de console por uma interface gráfica (GUI), poderíamos criar uma nova classe `GUIMenu implements Menu` e apenas trocar a instância na classe `Main`: `Menu gui = new GUIMenu();`. O resto do sistema não precisaria ser alterado.
    
### 4\. Polimorfismo, Upcast e Downcast: Flexibilidade em Ação

  * **Upcast (Conversão para Cima):** Principalmente nas classes de `Armazenamento`. O array `clientes` na classe `ArmazenamentoClientes` é do tipo `Cliente[]`, mas armazena objetos dos tipos `PessoaFisica` e `PessoaJuridica`. O mesmo ocorre com o array `produtos` em `ArmazenamentoProdutos`.
      * **Exemplo (`ArmazenamentoClientes.java`):**
        ```java
        // O objeto PessoaFisica é "convertido" para Cliente ao ser inserido no array.
        clientes[estoque++] = (Cliente) new PessoaFisica(...);
        ```
      * **Relevância:** O Upcast permite criar coleções heterogêneas (um array que guarda diferentes tipos de clientes ou produtos), simplificando o gerenciamento. É possível iterar sobre a lista e chamar métodos definidos na classe pai (como `getId()` e `getNome()`) sem haver uma preocupação com o tipo específico de cada objeto.

  * **Downcast (Conversão para Baixo):** O processo acontece no método `listarClientes()` da classe `ArmazenamentoClientes`.
      * **Exemplo (`ArmazenamentoClientes.java`):**
        ```java
        Cliente c = clientes[i];

        if (c instanceof PessoaFisica) {
            // Verifica se 'c' é uma instância de PessoaFisica antes de converter.
            PessoaFisica pf = (PessoaFisica) c; // Downcast
            System.out.printf("... | CPF: %s\n", pf.getCpf()); // Acessa método específico da filha.
        }
        ```
      * **Relevância:** Para exibir dados completos, como o CPF ou o CNPJ, que não existem na classe `Cliente`, o Downcast é essencial. O uso do operador `instanceof` antes da conversão é uma prática de programação segura fundamental para evitar o erro `ClassCastException` em tempo de execução, garantindo que o Downcast só seja feito se o objeto for realmente daquele tipo.
   

Observação: Esse projeto trata-se de um atividade acadêmica realizada pelos alunos supracitados do Departamento de Computação (DCOMP) da Universidade Federal de Sergipe na disciplina de Programação Orientada a Objetos, ministrada pelo Professor Kalil Bispo, no período de 2025.1.
