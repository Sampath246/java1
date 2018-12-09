import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class Server {
    public static void main(String[] args) throws Exception {
        String serverIP ;
        
        Scanner scan =new Scanner(System.in);
        //input port number
        System.out.println("Input port number:");
        Integer portNo=scan.nextInt();
        
        //get IP address
        InetAddress iAddress = InetAddress.getLocalHost();
        serverIP = iAddress.getHostAddress();
        System.out.println("Server IP address : " +serverIP);
    
        //establish socket connection
        ServerSocket serverSocket = new ServerSocket(portNo);
        Socket socket = serverSocket.accept();
        
        //get data from input stream
        InputStream inputStream = socket.getInputStream();
        System.out.println("Reading file...");

        //using byte stream to receive file
        byte[] sizeAr = new byte[4];
        inputStream.read(sizeAr);
        int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();
        byte[] imageAr = new byte[size];
        inputStream.read(imageAr);

        BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));

        //display image attributes
        System.out.println("Received image of size:" + image.getHeight() + "x" + image.getWidth());

        serverSocket.close();
    }
}