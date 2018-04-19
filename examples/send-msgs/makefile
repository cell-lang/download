send-msgs: main.cell
	../../bin/cellc project.txt
	g++ -std=c++11 generated.cpp -o send-msgs

send-msgs.exe: main.cell
	../../bin/cellc-cs.exe project.txt
	mcs -nowarn:219 generated.cs -out:send-msgs.exe

send-msgs.jar: main.cell
	mkdir -p tmp
	rm -rf tmp/net/ tmp/gen/
	mkdir tmp/gen/
	java -jar ../../bin/cellc-java.jar project.txt tmp/gen/
	javac -d tmp/ tmp/gen/*.java
	jar cfe send-msgs.jar net.cell_lang.Generated -C tmp net/

clean:
	@rm -rf tmp/
	@rm -f generated.* interfaces.txt
	@rm -f send-msgs send-msgs.exe send-msgs.jar
