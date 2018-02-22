using System;
using System.IO;
using System.Linq;

using CellLang;


static class ChatServerMain {
  public static void Main(string[] args) {
    Generated.Logins logins = new Generated.Logins();

    // Logging in a bunch of users
    logins.Execute("login(user_id: 0, name: \"emy\")");
    logins.Execute("login(user_id: 1, name: \"jake\")");
    logins.Execute("login(user_id: 2, name: \"sarah\")");
    logins.Execute("login(user_id: 3, name: \"paul\")");

    // Printing the usernames relations
    Tuple<long, string>[] usernames = logins.Usernames();
    for (int i=0 ; i < usernames.Length ; i++)
      Console.WriteLine("({0}, {1})", usernames[i].Item1, usernames[i].Item2);
    Console.WriteLine("");

    // This attempt to log in will fail because of a duplicate username
    try {
      logins.Execute("login(user_id: 4, name: \"jake\")");
      // We're not supposed to ever get here
      Console.WriteLine("Error (1)!");
      return;
    }
    catch {
      // The error was expected, ignoring it
    }

    // Checking that the username relation was not
    // affected by after the failed login attempt
    Tuple<long, string>[] usernames2 = logins.Usernames();
    if (!usernames2.SequenceEqual(usernames)) {
      Console.WriteLine("Error (2)!");
      return;
    }

    StreamWriter stdOutWriter = new StreamWriter(Console.OpenStandardOutput());
    stdOutWriter.AutoFlush = true;

    // Reading and printing the current state of the automaton
    logins.ReadState().Print(stdOutWriter);
    Console.WriteLine("\n");

    // Making a copy of logins
    Generated.Logins loginsCopy = new Generated.Logins();
    string stateStr = logins.ReadState().ToString();
    loginsCopy.SetState(stateStr);

    // Printing the state of loginsCopy
    loginsCopy.ReadState().Print(stdOutWriter);
    Console.WriteLine("");
  }
}
