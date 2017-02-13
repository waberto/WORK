package mri.socket.tcp.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServeurTCP {

    public static void main(String[] args) throws IOException {

        //Attente des connexions sur le port 9999
    	int portEcoute = 9999;

		ServerSocket socketServeur = new ServerSocket(portEcoute);
		
        //Traitement des exceptions
    	try{    		
    		while(true){
    			System.out.println("Serveur en attente du message client : ");
    			Socket socketClient = socketServeur.accept();
    			System.out.println("Le client" +socketClient.getInetAddress() + " est connecté");
    			traiterSocketCliente(socketClient);
    			socketClient.close();    			
    		}
    	} catch(IOException e){
    		System.out.println("Erreur" +e.getMessage());
    	}finally{
    		socketServeur.close();
    	}
        //Dans une boucle, pour chaque socket clientes, appeler traiterSocketCliente

    }

    public static void traiterSocketCliente(Socket socketVersUnClient)  {
        //Créer printer et reader
    	
        //Tant qu’il y’a un message à lire via recevoirMessage
    	
        //Envoyer message au client via envoyerMessage

        //Si plus de ligne à lire fermer socket cliente
    	try{
    		BufferedReader reader = creerReader(socketVersUnClient);
    		PrintWriter printer = creerPrinter(socketVersUnClient);
    		String s = "" ;
    			while(s != null){
    				s = recevoirMessage(reader);
    				System.out.println("Reçu du client : " +s);
    				envoyerMessage(printer, "Serveur : " +s);
    			}
    	} catch(IOException e){
    		e.printStackTrace();
    	}
    }

    public static BufferedReader creerReader(Socket socketVersUnClient)
    throws IOException {
		
        //créé un BufferedReader associé à la Socket
    	return new BufferedReader(new InputStreamReader(socketVersUnClient.getInputStream()));
    }

    public static PrintWriter creerPrinter(Socket socketVersUnClient) throws
    IOException {
		
        //créé un PrintWriter associé à la Socket
    	return new PrintWriter(socketVersUnClient.getOutputStream(), true);
    }

    public static String recevoirMessage(BufferedReader reader) throws
    IOException {
		
        //Récupérer une ligne
        //Retourner la ligne lue ou null si aucune ligne à lire.
    	String s = reader.readLine();
    	return s;
    }

    public static void envoyerMessage(PrintWriter printer, String message)
    throws IOException {
        //Envoyer le message vers le client
    	printer.println(message);
    }

}