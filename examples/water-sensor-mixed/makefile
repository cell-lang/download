test-water-sensor: water-sensor.cell main.cpp
	../../bin/cellc project.txt
	g++ -std=c++11 main.cpp generated.cpp -o test-water-sensor

test-water-sensor.exe: water-sensor.cell main.cs
	../../bin/cellc-cs.exe project.txt
	mcs -nowarn:219 generated.cs main.cs -out:test-water-sensor.exe

test-water-sensor.jar: water-sensor.cell main.java
	mkdir -p tmp
	rm -rf tmp/net/ tmp/gen/
	mkdir tmp/gen/
	java -jar ../../bin/cellc-java.jar project.txt tmp/gen/
	javac -g -d tmp/ tmp/gen/*.java main.java
	jar cfe test-water-sensor.jar Test  -C tmp .

clean:
	rm -rf tmp/ generated.* interfaces.txt
	rm -f test-water-sensor test-water-sensor.exe test-water-sensor.jar
