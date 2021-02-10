package server;

import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

	private static ServerSocket server = null;
	private static ExecutorService threadPool;
	static Connection con;

	public static void main(String[] args) {
		threadPool = Executors.newCachedThreadPool();
		threadPool.submit(new Server.Monitor());

		try {
			server = new ServerSocket(4444);
			try {
				Class.forName("org.sqlite.JDBC");
				con = DriverManager.getConnection("jdbc:sqlite:vehicle.db");

				// create table if not exists
				String ctreateTable="create table if not exists vehicle(tid number, x double,y double,z double)";
				Statement createStatement = con.createStatement();
				long f1 = createStatement.executeUpdate(ctreateTable);
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("Server listening on port 10000 ....");
			System.out.println("Hit Enter to stop the server");

			while (true) {
				Socket socket = server.accept();
				threadPool.submit(new PersistDBThread(con, socket));
			}
		} catch (SocketException e) {
			System.out.println("Server is down");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void shutdownServer() {
		try {
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		threadPool.shutdown();
		System.exit(0);
	}

	private static class Monitor implements Runnable {

		@Override
		public void run() {
			try {
				while (System.in.read() != '\n') {}
			} catch (IOException e) {
			}

			shutdownServer();
		}
	}

	public static String getIpAddress() {
	    InetAddress host;
	    String ipString = "false";

	    try {
	        host = InetAddress.getLocalHost();
	        ipString = host.getHostAddress();
	    } catch (UnknownHostException e) {
	        System.out.println(e);
	    }

	    return ipString;
	  }
	}
