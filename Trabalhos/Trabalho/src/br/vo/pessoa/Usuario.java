package br.vo.pessoa;

import br.util.ValidaCodigo;
import java.io.Serializable;
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
    }
    
    public Usuario() {
        if(Usuario.existeUsuario("admin")) {
            throw new IllegalArgumentException("Pode haver somente um admin");
        } else {
            this.setUser("admin");
            this.senha = "admin";
        }
    }
    
    public String getNome() {
       return this.nome;
    }
    
    public void setNome(String nome) {
        if(nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Nome inválido! " + nome);
        }
        this.nome = nome;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if(!(ValidaCodigo.isCPF(codigo) || ValidaCodigo.isCNPJ(codigo))) {
            throw new IllegalArgumentException("O Código " + codigo + " é inválido!");
        }
        this.codigo = codigo;
    }

    public String getUser() {
        return usuario;
    }

    public void setUser(String user) {
        if(Usuario.existeUsuario(user)) {
            throw new IllegalArgumentException("O nome de usário " + user + " já foi cadastrado!");
        }
        this.usuario = user;
    }

    public boolean isPass(String pass) {
        return pass.equals(this.senha);
    }

    public void setPass(String pass) {
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
    
    public void setPergunta(String pergunta) {
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

    public void setResposta(String resposta) {
        if(resposta.equals("")) {
            throw new IllegalArgumentException("Resposta Inválida!");
        }
        this.resposta = resposta;
    }

    public boolean equals(Usuario usuario) {
        System.out.println("equals");
        return this.getNome().equals(usuario.getNome())
            && this.getCodigo().equals(usuario.getNome())
            && this.getPergunta().equals(usuario.getPergunta())
            && this.getResposta().equals(usuario.getResposta())
            && this.getUser().equals(usuario.getUser());
    }
    
}
