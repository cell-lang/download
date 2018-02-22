social-network-mixed.exe: ../social-network/social-network.cell main.cs
	../../bin/cellc-cs.exe project.txt
	mcs -nowarn:219 generated.cs main.cs -out:social-network-mixed.exe

clean:
	@rm -rf generated.* interfaces.txt social-network-mixed.exe
