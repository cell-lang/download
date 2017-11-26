test-water-sensor: water-sensor.cell main.cpp
	../../bin/cellc project.txt
	g++ -std=c++11 main.cpp generated.cpp -o test-water-sensor

clean:
	rm -rf generated.* test-water-sensor
