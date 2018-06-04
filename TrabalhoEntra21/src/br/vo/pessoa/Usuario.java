package br.vo.pessoa;

import br.util.Arquivo;
import br.util.ValidaCodigo;
import br.vo.Historico;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Vinícius Luis da Silva
 */
public abstract class Usuario implements Serializable {
    
    private static ArrayList<Usuario> usuariosCadastrados = new ArrayList<>();
    
    public static boolean existeUsuario(String user) {
        for (Usuario pessoa : usuariosCadastrados) {
            if(pessoa.getUser().equals(user)) {
                return true;
            }
        }
        return false;
    }
    
    public static Usuario getPorCodigo(String codigo) {
        for (Usuario pessoa : usuariosCadastrados) {
            if(pessoa.getCodigo().equals(codigo)) {
                return pessoa;
            }
        }
        return null;
    }
    
    public static void addUsuario(Usuario novo) {
        usuariosCadastrados.add(novo);
    }
    
    public static Usuario getUsuario(String nomeUsuario) {
        for(Usuario user: Usuario.usuariosCadastrados) {
            if(user.getUser().equals(nomeUsuario)) {
                return user;
            }
        }
        throw new IllegalArgumentException("Usuário não encontrado!");
    }
    
    public static ArrayList<Usuario> getUsuarios() {
        return usuariosCadastrados;
    }
    
    public static void setUsuarios(ArrayList<Usuario> base) {        
        Usuario.usuariosCadastrados = base;
    }
    
    private String nome;
    private String codigo;
    private String usuario;
    private String senha;
    private String pergunta;
    private String resposta;
    
    public Usuario(String nome, String codigo, String nomeUsuario, String senha, String pergunta, String resposta) {
        this.setNome(nome);
        this.setCodigo(codigo);
        this.setUser(nomeUsuario);
        this.setPass(senha);
        this.setPergunta(pergunta);
        this.setResposta(resposta);
        Usuario.addUsuario(this);
    }
    
    public Usuario() {
        if(Usuario.existeUsuario("admin")) {
            throw new IllegalArgumentException("Pode haver somente um admin");
        } else {
            this.setUser("admin");
            this.senha = "admin";
        }
    }
    
    public void atualizaUsuario(String nome, String codigo, String senha, String pergunta, String resposta) {
        this.setNome(nome);
        this.setCodigo(codigo);
        this.setPass(senha);
        this.setPergunta(pergunta);
        this.setResposta(resposta);
        Arquivo.gravarAlteracoesUsuarios();
        Historico.addHistoric(new Historico("O usuário " + this.getUser() + " foi alterado!"));
    }
    
    public String getNome() {
       return this.nome;
    }
    
    protected void setNome(String nome) {
        if(nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Nome inválido! " + nome);
        }
        this.nome = nome;
    }
    
    public String getCodigo() {
        return codigo;
    }

    protected void setCodigo(String codigo) {
        if(!(ValidaCodigo.isCPF(codigo) || ValidaCodigo.isCNPJ(codigo))) {
            throw new IllegalArgumentException("O Código " + codigo + " é inválido!");
        }
        this.codigo = codigo;
    }

    public String getUser() {
        return usuario;
    }

    protected void setUser(String user) {
        if(Usuario.existeUsuario(user)) {
            throw new IllegalArgumentException("O nome de usário " + user + " já foi cadastrado!");
        }
        this.usuario = user;
    }

    public boolean isPass(String pass) {
        return pass.equals(this.senha);
    }

    protected void setPass(String pass) {
        //digito, upper case, lower case, especial
        boolean[] caracteresNecessários = new boolean[4];
        for(int i = 0; i < pass.length(); i++) {
            if(Character.isDigit(pass.charAt(i))) {
                caracteresNecessários[0] = true;
            } else if(Character.isLowerCase(pass.charAt(i))) {
                caracteresNecessários[1] = true;
            } else if(Character.isUpperCase(pass.charAt(i))) {
                caracteresNecessários[2] = true;
            } else if(br.util.Character.isSpecialCharacter(pass.charAt(i))){
                caracteresNecessários[3] = true;
            }
        }
        if(!caracteresNecessários[0]) {
            throw new IllegalArgumentException("É necessário ter pelo menos um digito!");
        } else if(!caracteresNecessários[1]) {
            throw new IllegalArgumentException("É necessário ter pelo menos uma letra minuscula!");
        } else if(!caracteresNecessários[2]) {
            throw new IllegalArgumentException("É necessário ter pelo menos uma letra mauscula!");
        } else if(!caracteresNecessários[3]) {
            throw new IllegalArgumentException("É necessário ter pelo menos um caracter especial!");
        }
        this.senha = pass;
    }
    
    public String getPass() {
        return this.senha;
    }
    
    protected void setPergunta(String pergunta) {
        if(pergunta.equals("") || pergunta.charAt(0) == ' ') {
            throw new IllegalArgumentException("Pergunta Inválida!");
        }
        System.out.println("pergunta " + pergunta);
        this.pergunta = (pergunta.charAt(pergunta.length() - 1 ) == 63) ? pergunta : pergunta + "?";
    }
    
    public String getPergunta() {
        return this.pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    protected void setResposta(String resposta) {
        if(resposta.equals("")) {
            throw new IllegalArgumentException("Resposta Inválida!");
        }
        this.resposta = resposta;
    }
    
}
