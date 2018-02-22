send-msgs: main.cell
	../../bin/cellc project.txt
	g++ -std=c++11 generated.cpp -o send-msgs

send-msgs.exe: main.cell
	../../bin/cellc-cs.exe project.txt
	mcs -nowarn:219 generated.cs -out:send-msgs.exe

clean:
	rm -rf generated.* interfaces.txt send-msgs send-msgs.exe
