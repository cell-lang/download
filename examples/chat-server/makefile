test-chat-server: main.cpp logins.cell
	../../bin/cellc project.txt
	g++ -std=c++11 main.cpp generated.cpp -o test-chat-server

test-chat-server.exe: main.cs logins.cell
	../../bin/cellc-cs.exe project.txt
	mcs -nowarn:219 generated.cs main.cs -out:test-chat-server.exe

clean:
	rm -rf generated.* interfaces.txt test-chat-server test-chat-server.exe
