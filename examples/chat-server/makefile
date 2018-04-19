test-chat-server: main.cpp logins.cell
	../../bin/cellc project.txt
	g++ -std=c++11 main.cpp generated.cpp -o test-chat-server

test-chat-server.exe: main.cs logins.cell
	../../bin/cellc-cs.exe project.txt
	mcs -nowarn:219 generated.cs main.cs -out:test-chat-server.exe

test-chat-server.jar: main.java logins.cell
	rm -rf tmp/
	mkdir tmp/
	mkdir tmp/gen/ tmp/cls/
	java -jar ../../bin/cellc-java.jar project.txt tmp/gen/
	javac -d tmp/cls/ main.java tmp/gen/*.java
	jar cfe test-chat-server.jar Main -C tmp/cls/ .

clean:
	rm -rf tmp/ generated.* interfaces.txt test-chat-server*
