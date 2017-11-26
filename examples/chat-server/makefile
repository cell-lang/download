test-chat-server: main.cpp logins.cell
	../../bin/cellc project.txt
	g++ -std=c++11 main.cpp generated.cpp -o test-chat-server

clean:
	rm -rf generated.* test-chat-server
