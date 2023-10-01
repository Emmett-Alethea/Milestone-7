package app;

import java.io.IOException;

public class ServerThread extends Thread{
	
	public void run() {
		AdminServer server = new AdminServer();
		try {
			server.start(6666);
			server.cleanup();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
