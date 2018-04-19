social-network: social-network.cell main.cell
	../../bin/cellc project.txt
	g++ -std=c++11 generated.cpp -o social-network

social-network.exe: social-network.cell main.cell
	../../bin/cellc-cs.exe project.txt
	mcs -nowarn:219 generated.cs -out:social-network.exe

social-network.jar: social-network.cell main.cell
	mkdir -p tmp
	rm -rf tmp/net/ tmp/gen/
	mkdir tmp/gen/
	java -jar ../../bin/cellc-java.jar project.txt tmp/gen/
	javac -g -d tmp/ tmp/gen/*.java
	jar cfe social-network.jar net.cell_lang.Generated -C tmp net/

update:
	javac -g -d tmp/ Generated.java
	jar cfe social-network.jar net.cell_lang.Generated -C tmp net/

clean:
	@rm -rf tmp/
	@rm -f generated.* Generated.java interfaces.txt
	@rm -f social-network social-network.exe social-network.jar
