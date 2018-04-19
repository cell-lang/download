import java.io.IOException;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import net.cell_lang.SocialNetwork;


class SocialNetworkMain {
  public static void main(String[] args) throws IOException {
    if (args.length != 2) {
      System.out.println("Usage: java -jar social-network-mixed.jar <input file> <output file>");
      return;
    }

    // Creating an instance of SocialNetwork
    SocialNetwork socialNetwork = new SocialNetwork();

    // Reading and setting the initial state for the automaton
    socialNetwork.setState(new String(Files.readAllBytes(Paths.get(args[0]))));

    // Sending a message
    socialNetwork.execute("delete_person(id: person(5))");

    // Writing the new state to a file
    try (FileWriter writer = new FileWriter(args[1])) {
      socialNetwork.readState().print(writer);
    }
  }
}
