import java.util.Arrays;
import java.io.IOException;
import java.io.Writer;
import java.io.PrintWriter;
import net.cell_lang.Logins;
import net.cell_lang.Pair;


class Main {
  public static void main(String[] args) throws IOException {
    Logins logins = new Logins();

    // Logging in a bunch of users
    logins.execute("login(user_id: 0, name: \"emy\")");
    logins.execute("login(user_id: 1, name: \"jake\")");
    logins.execute("login(user_id: 2, name: \"sarah\")");
    logins.execute("login(user_id: 3, name: \"paul\")");

    // Printing the usernames relations
    Pair<long[], String[]> usernames = logins.usernames();
    for (int i=0 ; i < usernames.item1.length ; i++)
      System.out.printf("(%d, %s)%n", usernames.item1[i], usernames.item2[i]);
    System.out.println();

    // This attempt to log in will fail because of a duplicate username
    try {
      logins.execute("login(user_id: 4, name: \"jake\")");
      // We're not supposed to ever get here
      System.out.println("Error (1)!");
      return;
    }
    catch (Exception e) {
      // The error was expected, ignoring it
    }

    // Checking that the username relation was not
    // affected by after the failed login attempt
    Pair<long[], String[]> usernames2 = logins.usernames();
    if (!Arrays.equals(usernames.item1, usernames2.item1) || !Arrays.equals(usernames.item2, usernames2.item2)) {
      System.out.println("Error (2)!");
      return;
    }

    Writer writer = new PrintWriter(System.out);

    // Reading and printing the current state of the automaton
    logins.readState().print(writer);
    writer.write("\n\n");

    // Making a copy of logins
    Logins loginsCopy = new Logins();
    String stateStr = logins.readState().toString();
    loginsCopy.setState(stateStr);

    // Printing the state of loginsCopy
    loginsCopy.readState().print(writer);
    writer.write("\n");
    writer.flush();
  }
}
