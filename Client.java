import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.Scanner;
import javax.imageio.ImageIO;
public class Client {
	public static void main(String[] args) throws Exception {
	   
		//create scanner object for input
	    Scanner scan =new Scanner(System.in);
	    //input path of file to be send
	    System.out.println("Input file path:");
	    String inputPath=scan.nextLine();
	    //input destination IP address
	    System.out.println("Input IP Address");
	    String IP=scan.nextLine();
	    //input port number
	    System.out.println("Input port number:");
	    Integer portNo=scan.nextInt();
	   
	    //establish socket connection to server
	    Socket socket = new Socket(IP, portNo);
		    
	    //write to socket using OutputStream
	    OutputStream outputStream = socket.getOutputStream();
	    BufferedImage image = ImageIO.read(new File(inputPath));
	
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    ImageIO.write(image, "jpg", byteArrayOutputStream);
	
	    //using byte stream for given input
	    byte size[] = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
	    outputStream.write(size);
	    outputStream.write(byteArrayOutputStream.toByteArray());
	}    
}
