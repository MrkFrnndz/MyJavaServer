import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataCollectServer {
	private static Socket socket = null;
	private static ServerSocket server = null;
    public final static int SOCKET_PORT = 8998;
    private static boolean isConnected=true;
	
	    public static void main(String[] args) throws IOException {	
		try {
	    	server = new ServerSocket(SOCKET_PORT);
			socket = server.accept();
			
			System.out.println("Server started!");
			
		} catch (IOException e) {
			System.out.println("Error in opening Socket");
			System.exit(-1);
		}
		
		Date date = new Date() ;
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
	    String curDate = dateFormat.format(date);
	    
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter pw = new PrintWriter(new FileWriter("C:\\PDT\\DataScan\\" + curDate + ".txt"));
		
		try{
			String line = br.readLine();
			while(line != null){
			    pw.println(line);
			    line = br.readLine();
			}
			pw.flush();
			pw.close();
		} catch(IOException ex){
			System.out.printf("Can't write to file. ", ex);
		} finally {
			if(socket != null){
        		br.close();
        		pw.close();
		        socket.close();
        	}
		}
	}
}
