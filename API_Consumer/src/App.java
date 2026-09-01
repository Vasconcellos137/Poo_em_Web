import java.awt.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class App {
    public static void main(String[] args) throws Exception{
        //1. endereco da api a ser consumida
        String endereco = "https://dog.ceo/api/breeds/image/random";

        //2. criar um cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        //3. criar uma requisicao HTTP
        HttpRequest requisicao = HttpRequest.newBuilder().uri(URI.create(endereco)).GET().build(); 

        //4. executar a requisição
        HttpResponse<String> resposta = client.send(requisicao, HttpResponse.BodyHandlers.ofString());

        //5. resposta 
        System.out.println("Status HTTP: " + resposta.statusCode());
        System.out.println("JSON recebido:");

        String json = resposta.body();
        System.out.println(json);


        String imagemURL = json.split("\"message\":\"")[1].split("\"")[0];

        //6. abrir a imagem no navegador
        Image imagemRedimensionada = new ImageIcon(URI.create(imagemURL).toURL()).getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        ImageIcon imagemIcone = new ImageIcon(imagemRedimensionada);

        JFrame janela = new JFrame("Dogs");
        janela.setSize(450, 450);
        JLabel label = new JLabel(imagemIcone, SwingConstants.CENTER);
        janela.add(label);
        janela.setVisible(true);

    }
}