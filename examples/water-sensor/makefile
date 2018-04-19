test-water-sensor: main.cell
	../../bin/cellc project.txt
	g++ -std=c++11 generated.cpp -o test-water-sensor

test-water-sensor.exe: main.cell
	../../bin/cellc-cs.exe project.txt
	mcs -nowarn:219 generated.cs -out:test-water-sensor.exe

test-water-sensor.jar: main.cell
	mkdir -p tmp
	rm -rf tmp/net/ tmp/gen/
	mkdir tmp/gen/
	java -jar ../../bin/cellc-java.jar project.txt tmp/gen/
	javac -d tmp/ tmp/gen/*.java
	jar cfe test-water-sensor.jar net.cell_lang.Generated -C tmp net/

clean:
	@rm -rf tmp/
	@rm -f generated.* Generated.java interfaces.txt
	@rm -f test-water-sensor test-water-sensor.exe test-water-sensor.jar
