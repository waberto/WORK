package mri.socket.address;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;


public class AfficheInterfaces {

	public static void main(String[] args) throws SocketException {
		// TODO Auto-generated method stub
		ArrayList<NetworkInterface> a = Collections.list(NetworkInterface.getNetworkInterfaces());
		for(NetworkInterface ni:a){
				System.out.println("Network interface : ");
				System.out.println("nom : " +ni.getName());
				System.out.println("nom Human-readable : " +ni.getDisplayName());
				Enumeration<InetAddress> inetAddresses = ni.getInetAddresses();
		        for (InetAddress inetAddress : Collections.list(inetAddresses)) {
		            System.out.printf("InetAddress: %s\n", inetAddress);
		        }
		        System.out.printf("\n");
					
		}
			}
		}



