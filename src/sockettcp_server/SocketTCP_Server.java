/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockettcp_server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class SocketTCP_Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            ServerSocket miSocket = new ServerSocket(8080);
            System.out.println("Socket TCP iniciado.....");
            while(true){
                Socket socket  = miSocket.accept();
                //DataInputStream in = new DataInputStream(socket.getInputStream());
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                
                
                System.out.println("ip: " + socket.getInetAddress());
                System.out.println("puerto: " + socket.getPort());
                System.out.println("Mensaje:  " + in.readLine());
                
                out.println("Nombre: Lorena\n"
                        + "ID: 208313\n"
                        + "NRC: 26872 \n"
                        + "Asignatura: Interconectividad\n"
                        + "Docente: Jonhn Criollo");
                
                out.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(SocketTCP_Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
