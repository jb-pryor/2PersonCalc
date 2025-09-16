
//imports
import java.net.*;
import java.util.*;
import java.io.*;

public class SimpleNetworkServer {

  public static void main(String[] args) throws Exception {
    int portNum = 9959;
    Scanner scan = new Scanner(System.in);

    DataInputStream input;
    DataOutputStream output;

    ServerSocket listener = new ServerSocket(portNum);

    Socket socket = listener.accept();

    output = new DataOutputStream(socket.getOutputStream());
    input = new DataInputStream(socket.getInputStream());

    System.out.println("Please enter four numbers");
    int firstNum = scan.nextInt();
    int secondNum = scan.nextInt();
    int thirdNum = scan.nextInt();
    int fourthNum = scan.nextInt();

    output.writeInt(firstNum);
    output.writeInt(secondNum);

    char operand = input.readChar();

    int result = 0;

    switch (operand) {
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
    listener.close();
    scan.close();

  }
}
