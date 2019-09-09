/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.BDarquivo;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.List;
import java.util.Random;

/**
 *
 * @author 2017122760013
 */
public class UDPServer {

    public static void main(String[] args) {

        List<String> palavras;
        String palavra;
        
        Random numeroAleatorio = new Random();
        
        DatagramPacket request, reply;
        DatagramSocket aSocket = null;
        
        try {

            aSocket = new DatagramSocket(6789);
            byte[] buffer = new byte[256];

            while (true) {

                request = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(request);

                palavras = BDarquivo.lerDados();
                palavra = palavras.get(numeroAleatorio.nextInt(palavras.size()));

                reply = new DatagramPacket(palavra.getBytes(), palavra.length(),
                        request.getAddress(), request.getPort());
                aSocket.send(reply);
            }
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Input Output: "
                    + e.getMessage());
        } finally {
            if (aSocket != null) {
                aSocket.close();
            }
        }
    }
}
