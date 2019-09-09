/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import domain.Partida;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author gudeck
 */
public class UDPClient {

    public static Partida getPartida() {

        String nomeDNS = "LGUSTAVOPC";
        String palavra;

        DatagramSocket aSocket = null;

        try {

            aSocket = new DatagramSocket();
            InetAddress aHost = InetAddress.getByName(nomeDNS);
            Integer serverPort = 6789;

            DatagramPacket request = new DatagramPacket(new byte[0], 0,
                    aHost, serverPort);
            aSocket.send(request);

            byte[] buffer = new byte[256];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            aSocket.receive(reply);
            
            palavra = new String(reply.getData());
            
            palavra = palavra.replaceAll("\0", "");
            
            return (new Partida(
                    palavra));

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Input Output: " + e.getMessage());
        } finally {
            if (aSocket != null) {
                aSocket.close();
            }
        }

        return null;
    }
}
