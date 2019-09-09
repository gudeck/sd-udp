/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gudeck
 */
public class BDarquivo {

    public static List<String> lerDados() throws FileNotFoundException, IOException {

        String palavra;
        File file = new File("palavras.txt");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        List<String> palavras = new ArrayList<>();

        while ((palavra = buffer.readLine()) != null) {

            palavras.add(palavra);

        }

        return palavras;
    }

}
