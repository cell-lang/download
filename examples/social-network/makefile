social-network: social-network.cell main.cell
	../../bin/cellc project.txt
	g++ -std=c++11 generated.cpp -o social-network

social-network.exe: social-network.cell main.cell
	../../bin/cellc-cs.exe project.txt
	mcs -nowarn:219 generated.cs -out:social-network.exe

clean:
	@rm -rf generated.* interfaces.txt social-network social-network.exe
