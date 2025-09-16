
//imports
import java.net.*;
import java.util.*;
import java.io.*;

public class SimpleNetworkClient {

  public static void main(String[] args) throws Exception {

    int portNum = 9959; // setting portnumber

    Scanner scan = new Scanner(System.in);

    DataInputStream input;
    DataOutputStream output; // creating input output variables

    Socket myClient = new Socket("127.0.0.1", portNum); // 127.0.0.1 is localHost

    input = new DataInputStream(myClient.getInputStream());
    output = new DataOutputStream(myClient.getOutputStream());

    boolean alive = true;

    while (alive) {

      System.out.println("Please enter in an operation +,-,/,*");

      char operand = scan.next().charAt(0);// scans in char

      output.writeChar(operand); // sends out char operator

      int fNum = input.readInt(); // reads in first two ints
      int sNum = input.readInt();

      int result = 0; // declaring result

      switch (operand) { // switch statement for char decision
        case '+':
          result = fNum + sNum;
          break;
        case '-':
          result = fNum - sNum;
          break;
        case '/':
          result = fNum / sNum;
          break;
        case '*':
          result = fNum * sNum;
          break;
      }

      System.out.println("Result client compute: " + result); // prints result

      alive = input.readBoolean();

    }

    myClient.close(); // closes server and scanner
    scan.close();
  }
}
