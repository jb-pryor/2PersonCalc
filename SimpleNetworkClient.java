
//imports
import java.net.*;
import java.util.*;
import java.io.*;

public class SimpleNetworkClient {

  public static void main(String[] args) throws Exception {

    int portNum = 9959;

    Scanner scan = new Scanner(System.in);

    DataInputStream input;
    DataOutputStream output;

    Socket myClient = new Socket("127.0.0.1", portNum); // 127.0.0.1 is localHost

    input = new DataInputStream(myClient.getInputStream());
    output = new DataOutputStream(myClient.getOutputStream());

    System.out.println("Please enter in an operation +,-,/,*");

    char operand = scan.next().charAt(0);

    output.writeChar(operand);

    int fNum = input.readInt();
    int sNum = input.readInt();

    int result = 0;

    switch (operand) {
      case '+':
        result = fNum + sNum;
      case '-':
        result = fNum - sNum;
      case '/':
        result = fNum / sNum;
      case '*':
        result = fNum * sNum;
    }

    System.out.println("Result client compute: " + result);

    myClient.close();
    scan.close();
  }
}
