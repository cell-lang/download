using System;
using System.IO;
//using System.Linq;

using CellLang;


static class SocialNetworkMain {
  public static void Main(string[] args) {
    if (args.Length != 2) {
      Console.Error.WriteLine("Usage: social-network-mixed.exe <input file> <output file>");
      return;
    }

    // Creating an instance of SocialNetwork
    Generated.SocialNetwork socialNetwork = new Generated.SocialNetwork();

    // Reading and setting the initial state for the automaton
    socialNetwork.SetState(File.ReadAllText(args[0]));

    // Sending a message
    socialNetwork.Execute("delete_person(id: person(5))");

    // Writing the new state to a file
    using (StreamWriter outputWriter = new StreamWriter(args[1])) {
      socialNetwork.ReadState().Print(outputWriter);
    }
  }
}
