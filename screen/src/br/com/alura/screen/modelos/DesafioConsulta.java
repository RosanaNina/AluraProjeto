import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import static java.lang.System.exit;

public class ConsultaReceita {
    private String nomeReceita;

    Scanner sc = new Scanner(System.in);

    public ConsultaReceita(String nomeReceita) {
        this.nomeReceita = nomeReceita;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void buscarReceita() throws IOException, InterruptedException {
        int opcao = 0;
        System.out.println("===== WELCOME TO - ULTIMATE RECIPE SEARCH ");
        do {
            System.out.println( """
                    Selecione a opção:
                    1 - Buscar Receita
                    2 - Sair do Programa
                    """);
            int selecao = sc.nextInt();
            switch (selecao) {
                case 1:
                    System.out.println("Insira o nome da receita a ser pesquisada: ");
                    this.setNomeReceita(sc.next());
                    String endereco = "https://www.themealdb.com/api/json/v1/1/search.php?s=" +
                            this.getNomeReceita();
                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(endereco))
                            .build();
                    HttpResponse<String> response = client
                            .send(request, HttpResponse.BodyHandlers.ofString());
                    System.out.println(response.body());
                    break;
                case 2:
                    System.out.println("Saindo do programa...");
                    exit(0);
                    break;
            }
        } while (opcao == 0);
    }

    public String getNomeReceita() {
        return nomeReceita;
    }

    public void setNomeReceita(String nomeReceita) {
        this.nomeReceita = nomeReceita;
    }
}