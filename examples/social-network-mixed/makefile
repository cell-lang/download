social-network-mixed.exe: ../social-network/social-network.cell main.cs
	../../bin/cellc-cs.exe project.txt
	mcs -nowarn:219 generated.cs main.cs -out:social-network-mixed.exe

social-network-mixed.jar: ../social-network/social-network.cell main.java
	mkdir -p tmp
	rm -rf tmp/net/ tmp/gen/
	mkdir tmp/gen/
	java -jar ../../bin/cellc-java.jar project.txt tmp/gen/
	javac -g -d tmp/ tmp/gen/*.java main.java
	jar cfe social-network-mixed.jar SocialNetworkMain -C tmp SocialNetworkMain.class -C tmp net/

clean:
	@rm -rf tmp/ generated.* interfaces.txt
	@rm -f social-network-mixed.exe social-network-mixed.jar
