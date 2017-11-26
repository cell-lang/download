test-water-sensor: main.cell
	../../bin/cellc project.txt
	g++ -std=c++11 generated.cpp -o test-water-sensor

clean:
	rm -rf generated.* test-water-sensor
