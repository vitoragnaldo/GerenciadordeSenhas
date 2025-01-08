public class Senha {
    private String site;
    private String usuario;
    private String senha;

    public Senha(String site, String usuario, String senha) {
        this.site = site;
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getSite() {
        return site;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public String toString() {
        return "Site: " + site + ", Usuário: " + usuario + ", Senha: " + senha;
    }
}
