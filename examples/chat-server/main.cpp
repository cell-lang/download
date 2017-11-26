#include <iostream>
#include "generated.h"

using std::string;
using std::get;
using std::cout;
using std::endl;

using generated::Logins;


int main(int argc, char **argv) {
  Logins *logins = new Logins();

  // Logging in a bunch of users
  logins->execute("login(user_id: 0, name: \"emy\")");
  logins->execute("login(user_id: 1, name: \"jake\")");
  logins->execute("login(user_id: 2, name: \"sarah\")");
  logins->execute("login(user_id: 3, name: \"paul\")");

  // Printing the username relations
  auto usernames = logins->get_Usernames();
  for (auto it=usernames.begin() ; it != usernames.end() ; it++)
    cout << get<0>(*it) << "  " << get<1>(*it) << endl;
  cout << endl;

  // This attempt to log in will fail because of a duplicate username
  try {
    logins->execute("login(user_id: 4, name: \"jake\")");
    // We're not supposed to ever get here
    cout << "Error" << endl;
    return 1;
  }
  catch (long long) {
    // The error was expected, ignoring it
  }

  // Checking that the username relation was not
  // affected by after the failed login attempt
  auto usernames2 = logins->get_Usernames();
  if (usernames2 != usernames) {
    cout << "Error" << endl;
    return 1;
  }

  // Reading and printing the current state of the automaton
  logins->read_state()->print(cout);
  cout << endl << endl;

  // Making a copy of logins
  Logins *logins_copy = new Logins();
  string state_str = logins->read_state()->printed();
  logins_copy->set_state(state_str.c_str());

  // Printing the state of logins_copy
  logins_copy->read_state()->print(cout);
  cout << endl;

  delete logins;
  delete logins_copy;
}
