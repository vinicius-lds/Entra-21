/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.util;

import br.vo.Financeiro;
import br.vo.Historico;
import br.vo.financeiro.Dispesa;
import br.vo.financeiro.Receita;
import br.vo.pessoa.Usuario;
import br.vo.produto.Produto;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author vinic
 */
public class Arquivo {
    
    public static ArrayList<Usuario> lerArquivoUsuarios() {

        do {

            try {

                Path arq = Paths.get("data/DefinitivamenteNaoEASenhaELoginDeTodoMundo.dat").toAbsolutePath();
                FileInputStream fis = new FileInputStream(arq.toFile());
                ObjectInputStream ois = new ObjectInputStream(fis);

                ArrayList<Usuario> al = (ArrayList<Usuario>) ois.readObject();
                
                fis.close();
                ois.close();
                
                return al;

            } catch (Exception e) {}

        } while(br.util.PedeDados.perguntaBooleana("Ocorreu um erro na leitura do arquivo de usuários cadastrados. Deseja tentar novamente?"));

        return null;
    
    }
    
    public static ArrayList<Produto> lerArquivoProdutos() {

        do {

            try {

                Path arq = Paths.get("data/Produtos.dat").toAbsolutePath();
                FileInputStream fis = new FileInputStream(arq.toFile());
                ObjectInputStream ois = new ObjectInputStream(fis);

                ArrayList<Produto> al = (ArrayList<Produto>) ois.readObject();
                
                fis.close();
                ois.close();
                
                return al;

            } catch (Exception e) {}

        } while(br.util.PedeDados.perguntaBooleana("Ocorreu um erro na leitura do arquivo de produtos cadastrados. Deseja tentar novamente?"));

        return null;
    
    }
    
    public static ArrayList<Receita> lerArquivoReceitas() {

        do {

            try {

                Path arq = Paths.get("data/Receita.dat").toAbsolutePath();
                FileInputStream fis = new FileInputStream(arq.toFile());
                ObjectInputStream ois = new ObjectInputStream(fis);

                ArrayList<Receita> al = (ArrayList<Receita>) ois.readObject();
                
                fis.close();
                ois.close();
                
                return al;

            } catch (Exception e) {}

        } while(br.util.PedeDados.perguntaBooleana("Ocorreu um erro na leitura do arquivo de receitas. Deseja tentar novamente?"));

        return null;
    
    }
    
    public static ArrayList<Dispesa> lerArquivoDispesas() {

        do {

            try {

                Path arq = Paths.get("data/Dispesa.dat").toAbsolutePath();
                FileInputStream fis = new FileInputStream(arq.toFile());
                ObjectInputStream ois = new ObjectInputStream(fis);

                ArrayList<Dispesa> al = (ArrayList<Dispesa>) ois.readObject();
                
                fis.close();
                ois.close();
                
                return al;

            } catch (Exception e) {}

        } while(br.util.PedeDados.perguntaBooleana("Ocorreu um erro na leitura do arquivo de dispesas. Deseja tentar novamente?"));

        return null;
    
    }
    
    public static ArrayList<Historico> lerArquivoHistorico() {

        do {

            try {

                Path arq = Paths.get("data/Historico.dat").toAbsolutePath();
                FileInputStream fis = new FileInputStream(arq.toFile());
                ObjectInputStream ois = new ObjectInputStream(fis);

                ArrayList<Historico> al = (ArrayList<Historico>) ois.readObject();
                
                fis.close();
                ois.close();
                
                return al;

            } catch (Exception e) {}

        } while(br.util.PedeDados.perguntaBooleana("Ocorreu um erro na leitura do arquivo de historico. Deseja tentar novamente?"));

        return null;
    
    }

    public static void gravarAlteracoesUsuarios() {

        do {

            try {
                
                Path arq = Paths.get("data/DefinitivamenteNaoEASenhaELoginDeTodoMundo.dat").toAbsolutePath();
                Files.deleteIfExists(arq);
                Files.createFile(arq);
                FileOutputStream fos = new FileOutputStream(arq.toFile());
                ObjectOutput oos = new ObjectOutputStream(fos);
                
                oos.writeObject(Usuario.getUsuarios());
         
                fos.close();
                oos.close();
                
                break;
                
            } catch (Exception e) {}

        } while(br.util.PedeDados.perguntaBooleana("Ocorreu um erro ao gravar novos dados no arquivo de usários. Deseja tentar novamente?"));

    }
    
    public static void gravarAlteracoesProdutos() {
        do {

            try {
                
                Path arq = Paths.get("data/Produtos.dat").toAbsolutePath();
                Files.deleteIfExists(arq);
                Files.createFile(arq);
                FileOutputStream fos = new FileOutputStream(arq.toFile());
                ObjectOutput oos = new ObjectOutputStream(fos);
                
                oos.writeObject(Produto.getProdutos());
         
                fos.close();
                oos.close();
                
                break;
                
            } catch (Exception e) {}

        } while(br.util.PedeDados.perguntaBooleana("Ocorreu um erro ao gravar novos dados no arquivo de produtos. Deseja tentar novamente?"));

    }
    
    public static void gravarAlteracoesHistorico() {
        do {

            try {
                
                Path arq = Paths.get("data/Historico.dat").toAbsolutePath();
                Files.deleteIfExists(arq);
                Files.createFile(arq);
                FileOutputStream fos = new FileOutputStream(arq.toFile());
                ObjectOutput oos = new ObjectOutputStream(fos);
                
                oos.writeObject(Historico.getHistorico());
         
                fos.close();
                oos.close();
                
                break;
                
            } catch (Exception e) {}

        } while(br.util.PedeDados.perguntaBooleana("Ocorreu um erro ao gravar novos dados no arquivo de histórico. Deseja tentar novamente?"));

    }
    
    public static void gravarAlteracoesReceita() {
        do {

            try {
                
                Path arq = Paths.get("data/Receita.dat").toAbsolutePath();
                Files.deleteIfExists(arq);
                Files.createFile(arq);
                FileOutputStream fos = new FileOutputStream(arq.toFile());
                ObjectOutput oos = new ObjectOutputStream(fos);
                
                oos.writeObject(Financeiro.getInstance().getReceitas());
         
                fos.close();
                oos.close();
                
                break;
                
            } catch (Exception e) {}

        } while(br.util.PedeDados.perguntaBooleana("Ocorreu um erro ao gravar novos dados no arquivo de receitas. Deseja tentar novamente?"));

    }
    
    public static void gravarAlteracoesDispesa() {
        do {

            try {
                
                Path arq = Paths.get("data/Dispesa.dat").toAbsolutePath();
                Files.deleteIfExists(arq);
                Files.createFile(arq);
                FileOutputStream fos = new FileOutputStream(arq.toFile());
                ObjectOutput oos = new ObjectOutputStream(fos);
                
                oos.writeObject(Financeiro.getInstance().getDispesas());
         
                fos.close();
                oos.close();
                
                break;
                
            } catch (Exception e) {}

        } while(br.util.PedeDados.perguntaBooleana("Ocorreu um erro ao gravar novos dados no arquivo de dispesas. Deseja tentar novamente?"));

    }
    
}
