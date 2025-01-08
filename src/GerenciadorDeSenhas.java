import java.io.*;
import java.util.*;

public class GerenciadorDeSenhas {
    private List<Senha> senhas;
    private String arquivo;

    public GerenciadorDeSenhas(String arquivo) {
        this.senhas = new ArrayList<>();
        this.arquivo = arquivo;
        carregarSenhas();
    }

    // Carrega as senhas do arquivo
    public void carregarSenhas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            senhas = (List<Senha>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Nenhuma senha salva encontrada. Iniciando um novo arquivo.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Salva as senhas no arquivo
    public void salvarSenhas() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(senhas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Adiciona uma nova senha
    public void adicionarSenha(String site, String usuario, String senha) {
        senhas.add(new Senha(site, usuario, senha));
        salvarSenhas();
        System.out.println("Senha adicionada com sucesso!");
    }

    // Exibe todas as senhas armazenadas
    public void exibirSenhas() {
        if (senhas.isEmpty()) {
            System.out.println("Nenhuma senha armazenada.");
        } else {
            for (Senha s : senhas) {
                System.out.println(s);
            }
        }
    }

    // Busca uma senha por site
    public void buscarSenha(String site) {
        for (Senha s : senhas) {
            if (s.getSite().equalsIgnoreCase(site)) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("Senha não encontrada para o site: " + site);
    }
}
