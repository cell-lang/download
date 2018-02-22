test-water-sensor: main.cell
	../../bin/cellc project.txt
	g++ -std=c++11 generated.cpp -o test-water-sensor

test-water-sensor.exe: main.cell
	../../bin/cellc-cs.exe project.txt
	mcs -nowarn:219 generated.cs -out:test-water-sensor.exe

clean:
	rm -rf generated.* interfaces.txt test-water-sensor test-water-sensor.exe
