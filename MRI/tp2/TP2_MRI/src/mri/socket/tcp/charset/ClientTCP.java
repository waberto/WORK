package mri.socket.tcp.charset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTCP {

    public static void main(String[] args) throws UnknownHostException, IOException {
        //cr�er une socket client

        //cr�er reader et writer associ�s

        //Tant que le mot �fin� n�est pas lu sur le clavier,

        //Lire un message au clavier

        //envoyer le message au serveur

        //recevoir et afficher la r�ponse du serveur
    	int portEcoute = 9998;
    	String charset = "UTF-8";
    	args[1] = charset;
    	Socket client = new Socket(InetAddress.getLocalHost(), portEcoute);
    	
    	try{
    		BufferedReader reader = creerReader(client, args[1]);
    		PrintWriter printer = creerPrinter(client, args[1]);
    		
    		envoyerNom(printer, args[0]); 		
    		
    		String nom = recevoirMessage(reader);
    		String lire = lireMessageAuClavier();
    		
    		
    		while((lire!=null) && !lire.equals("fin")){
    			
    			envoyerMessage(printer, lire);
    			lire = recevoirMessage(reader);
    			System.out.println(nom + " > " + lire);
    			lire = lireMessageAuClavier();
    		
    		}
    	}catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
		}finally {
			client.close();
		}
    		
    	
    	
    }
    

    public static String lireMessageAuClavier() throws IOException {
        //lit un message au clavier en utilisant par exemple un BufferedReader
        //sur System.in
    	BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    	return buffer.readLine();
    }

    public static BufferedReader creerReader(Socket socketVersUnClient, String charset)
    throws IOException {
        //identique serveur
    	
    	return new BufferedReader(new InputStreamReader(socketVersUnClient.getInputStream(), charset));
    }

    public static PrintWriter creerPrinter(Socket socketVersUnClient, String charset) throws
    IOException {
        //identique serveur
    	return new PrintWriter(new OutputStreamWriter(socketVersUnClient.getOutputStream(), charset), true);
    }

    public static String recevoirMessage(BufferedReader reader) throws
    IOException {
        //identique serveur
    	String s = reader.readLine();
    	return s;
    }

    public static void envoyerMessage(PrintWriter p, String message) throws
    IOException {
        //identique serveur
    	p.println(message);
    	p.flush();
    }
    
    public static void envoyerNom(PrintWriter printer, String nom) throws
    IOException {
        //envoi « NAME: nom » au serveur
    	//printer.println("Nom : " +nom);
    	envoyerMessage(printer,"Nom : " + nom);
    }


}