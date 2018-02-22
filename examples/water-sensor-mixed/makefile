test-water-sensor: water-sensor.cell main.cpp
	../../bin/cellc project.txt
	g++ -std=c++11 main.cpp generated.cpp -o test-water-sensor

test-water-sensor.exe: water-sensor.cell main.cs
	../../bin/cellc-cs.exe project.txt
	mcs -nowarn:219 generated.cs main.cs -out:test-water-sensor.exe

clean:
	rm -rf generated.* interfaces.txt test-water-sensor test-water-sensor.exe
