import java.net.*;

import javax.swing.JOptionPane;

import java.io.*;
import java.awt.*;

/**
 * @author Niaina
 */
public class Client extends Thread {
  private static Socket s = null;
  private static OutputStream output;
  static DataOutputStream dataOutput;
  private static Robot r;

  public static void main(String[] args) {
    try {
      String ip = JOptionPane.showInputDialog("Entrer l'adresse ip");
      s = new Socket(ip, 5000);
      InetAddress inetAddress = InetAddress.getLocalHost();
      String nomPc = (String) inetAddress.getHostName();
      dataOutput = new DataOutputStream(s.getOutputStream());
      dataOutput.writeUTF(nomPc);
      r = new Robot();
      new ReceiveEvent(s, r);
      new SendImage(s, output, r);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
