# Conversor-de-Moedas
Conversor de moedas em tempo real.
Conversor de Moedas em Tempo Real
Este projeto é um Conversor de Moedas em Java que permite a conversão entre várias moedas, utilizando taxas de câmbio obtidas em tempo real por meio de uma API externa. O projeto oferece uma interface simples via console para interagir com o usuário.

Funcionalidades:
O usuário pode escolher entre várias opções de conversão de moedas.
As taxas de câmbio são obtidas em tempo real através da API de câmbio.
As opções de conversão incluem:
Dólar (USD) para Peso Argentino (ARS)
Peso Argentino (ARS) para Dólar (USD)
Dólar (USD) para Real Brasileiro (BRL)
Real Brasileiro (BRL) para Dólar (USD)
Dólar (USD) para Peso Colombiano (COP)
Peso Colombiano (COP) para Dólar (USD)
Sair
Pré-requisitos:
Java 8 ou superior.
Biblioteca Gson para manipulação de JSON.
Chave da API de Câmbio (Exemplo: ExchangeRate-API).
Como usar:
Clone este repositório ou baixe o código.

Certifique-se de ter o Java 8 ou superior instalado no seu computador.

Se você estiver utilizando Maven para gerenciar dependências, o arquivo pom.xml está configurado para baixar automaticamente a dependência do Gson.

Substitua a chave da API na variável API_KEY no código (no arquivo ConversorDeMoedas.java).

java
private static final String API_KEY = "sua_chave_de_api";  // Substitua com a sua chave da API
Execute o código via IntelliJ IDEA ou a linha de comando:

Se estiver utilizando IntelliJ, basta clicar com o botão direito sobre o arquivo ConversorDeMoedas.java e selecionar Run.
Ou compile e execute com o seguinte comando no terminal:
bash
Copiar código
javac ConversorDeMoedas.java
java ConversorDeMoedas
Exemplo de Execução:
Ao rodar o programa, o menu de opções será exibido no console:

mathematica
Copiar código
Conversor de Moedas:
1. Dólar => Peso argentino
2. Peso argentino => Dólar
3. Dólar => Real brasileiro
4. Real brasileiro => Dólar
5. Dólar => Peso colombiano
6. Peso colombiano => Dólar
7. Sair
Escolha uma opção válida (1-7): 1
Digite o valor para conversão: 10
Valor convertido de USD para ARS: 1636.2
Dependências:
Gson: Para manipulação de dados JSON.
API de câmbio (Exemplo: ExchangeRate-API) para obter as taxas de conversão de moedas em tempo real.
Estrutura do Projeto:
bash
Copiar código
/conversor-moedas
├── /src
│   └── ConversorDeMoedas.java
├── /lib (se você não usar Maven ou Gradle)
└── pom.xml (se estiver usando Maven)
Como funciona:
O programa solicita ao usuário que escolha uma opção de conversão entre as moedas.
Com a opção selecionada, o usuário fornece o valor desejado para conversão.
O programa consulta a API de câmbio usando a chave da API fornecida e obtém a taxa de conversão para as moedas solicitadas.
O valor convertido é exibido no console.
O programa continuará executando até que o usuário escolha a opção de Sair.
Considerações:
Limites de API: Dependendo da API escolhida, pode haver limites de requisição para planos gratuitos. Verifique as condições de uso da API.
Possíveis erros: O programa exibe mensagens de erro caso não consiga obter as taxas de conversão devido a problemas com a API ou rede.
Licença:
Este projeto é de código aberto, e você pode usá-lo conforme desejado. No entanto, por favor, verifique os termos de uso da API para garantir conformidade.
