
//imports
import java.net.*;
import java.util.*;
import java.io.*;

public class SimpleNetworkServer {

  public static void main(String[] args) throws Exception {
    int portNum = 9959;
    Scanner scan = new Scanner(System.in);

    DataInputStream input;
    DataOutputStream output; // input output variables

    ServerSocket listener = new ServerSocket(portNum); // creating serversocket to connect to server

    Socket socket = listener.accept(); // listener accept to connect to server

    output = new DataOutputStream(socket.getOutputStream());
    input = new DataInputStream(socket.getInputStream());

    System.out.println("Please enter four numbers");

    int firstNum = scan.nextInt();
    int secondNum = scan.nextInt(); // scanning four ints
    int thirdNum = scan.nextInt();
    int fourthNum = scan.nextInt();

    output.writeInt(firstNum);
    output.writeInt(secondNum); // sending out first two numbers to other application

    char operand = input.readChar(); // reads in operator

    int result = 0;

    switch (operand) { // same switch statement to determine char operator
      case '+':
        result = thirdNum + fourthNum;
      case '-':
        result = thirdNum - fourthNum;
      case '/':
        result = thirdNum / fourthNum;
      case '*':
        result = thirdNum * fourthNum;
    }
    System.out.println("Result server comput: " + result);

    socket.close();
    listener.close(); // close socket, listener, and scanner
    scan.close();

  }
}
