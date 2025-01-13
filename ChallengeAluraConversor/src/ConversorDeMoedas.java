import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConversorDeMoedas {

    // Substitua com sua chave de API real
    private static final String API_KEY = "befeec2ac4cfb7421348d1dd";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Exibe o menu
            System.out.println("Conversor de Moedas:");
            System.out.println("1. Dólar => Peso argentino");
            System.out.println("2. Peso argentino => Dólar");
            System.out.println("3. Dólar => Real brasileiro");
            System.out.println("4. Real brasileiro => Dólar");
            System.out.println("5. Dólar => Peso colombiano");
            System.out.println("6. Peso colombiano => Dólar");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção válida (1-7): ");

            int opcao = scanner.nextInt();

            if (opcao == 7) {
                System.out.println("Saindo do programa...");
                break;
            }

            System.out.print("Digite o valor para conversão: ");
            double valor = scanner.nextDouble();

            // Definir as moedas de origem e destino com base na opção
            String moedaOrigem = "";
            String moedaDestino = "";

            switch (opcao) {
                case 1:
                    moedaOrigem = "USD";
                    moedaDestino = "ARS";
                    break;
                case 2:
                    moedaOrigem = "ARS";
                    moedaDestino = "USD";
                    break;
                case 3:
                    moedaOrigem = "USD";
                    moedaDestino = "BRL";
                    break;
                case 4:
                    moedaOrigem = "BRL";
                    moedaDestino = "USD";
                    break;
                case 5:
                    moedaOrigem = "USD";
                    moedaDestino = "COP";
                    break;
                case 6:
                    moedaOrigem = "COP";
                    moedaDestino = "USD";
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    continue;
            }

            // Obtém a taxa de conversão e realiza a conversão
            try {
                double taxaConversao = obterTaxaDeConversao(moedaOrigem, moedaDestino);
                double valorConvertido = valor * taxaConversao;
                System.out.println("Valor convertido de " + moedaOrigem + " para " + moedaDestino + ": " + valorConvertido);
            } catch (Exception e) {
                System.out.println("Erro ao obter a taxa de câmbio: " + e.getMessage());
            }
        }

        scanner.close();
    }

    // Função para obter a taxa de conversão através da API
    private static double obterTaxaDeConversao(String moedaOrigem, String moedaDestino) throws Exception {
        String urlString = API_URL + moedaOrigem;
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Lê a resposta da API
        Scanner scanner = new Scanner(connection.getInputStream());
        StringBuilder resposta = new StringBuilder();
        while (scanner.hasNext()) {
            resposta.append(scanner.nextLine());
        }
        scanner.close();

        // Parseia a resposta JSON usando Gson
        JsonObject jsonResponse = JsonParser.parseString(resposta.toString()).getAsJsonObject();
        if (jsonResponse.get("result").getAsString().equals("success")) {
            JsonObject taxas = jsonResponse.getAsJsonObject("conversion_rates");
            return taxas.get(moedaDestino).getAsDouble();
        } else {
            throw new Exception("Erro ao obter taxas de conversão");
        }
    }
}
