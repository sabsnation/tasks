import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ViaCepApi {
    public static void main(String[] args) {
        String cep = "01001000"; // Substitua pelo CEP desejado
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        try {
            // Criando o cliente HTTP
            HttpClient client = HttpClient.newHttpClient();
            
            // Criando a requisição
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            
            // Enviando a requisição e recebendo a resposta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            // Exibindo a resposta no console
            if (response.statusCode() == 200) {
                System.out.println("Resposta da API:");
                System.out.println(response.body());
            } else {
                System.out.println("Erro ao consultar API: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
        }
    }
}
