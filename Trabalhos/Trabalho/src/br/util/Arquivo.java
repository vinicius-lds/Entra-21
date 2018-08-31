/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.util;

import br.vo.pessoa.Usuario;
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

}
