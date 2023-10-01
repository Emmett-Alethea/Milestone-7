package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AdminServer extends Thread{

	private ServerSocket serverSocket;
	private Socket clientSocket;
	private static PrintWriter out;
	private static BufferedReader in;
	private static Inventory list = new Inventory();
	
	public void start(int port) throws IOException{
		
		serverSocket = new ServerSocket(port);
		clientSocket = serverSocket.accept();
		
		System.out.println("Connected!");
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		
		System.out.println("Server is shut down");
	}
	
	public void cleanup() throws IOException{
		in.close();
		out.close();
		clientSocket.close();
		serverSocket.close();
	}
	public static void receive() {
		
		Inventory.displayInventory();
		//send this to admin app. how?
	}
	public void update(String item) throws JsonMappingException, JsonProcessingException {
		//map string item to a product 
	try {
		item = AdminApp.returnJson();
	
	ObjectMapper objectmapper = new ObjectMapper(); 
	if(item.contains("damage")) {
		Product rec = objectmapper.readValue(item, Weapon.class);
		Inventory.addItem(rec);
		Inventory.displayInventory();
	}
	if(item.contains("defense")) {
		Product rec = objectmapper.readValue(item,  Armor.class);
		Inventory.addItem(rec);
		Inventory.displayInventory();
	}
	if(item.contains("healthRestore")) {
		Product rec = objectmapper.readValue(item,  Health.class);
		Inventory.addItem(rec);
		Inventory.displayInventory();
	}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	System.out.println("Received command U");}
	

	public static void main(String[] args) throws IOException{

		AdminServer server = new AdminServer();
		server.start(6666);
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			if (inputLine.equals("u") || inputLine.equals("U")) {
				String rec = AdminApp.returnJson();
				server.update(rec);
				System.out.println("Sent");
				
			}
			else {
				System.out.println("Got a message of: " + inputLine);
				out.println("Ok");
			}
		}
		
	
		server.cleanup();
		System.out.println("Server is shut down");

	}

}
