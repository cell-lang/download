send-msgs: main.cell
	../../bin/cellc project.txt
	g++ -std=c++11 generated.cpp -o send-msgs

clean:
	rm -rf generated.* send-msgs
