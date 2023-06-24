import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {
    public String buscaPokemon (String pokemon){
        String caracteristicas="https://pokeapi.co/api/v2/pokemon/" + pokemon;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(caracteristicas))
        .build();

        HttpResponse<String> response;
        try {
            response=client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            
        } 
        return "";
    }
}
