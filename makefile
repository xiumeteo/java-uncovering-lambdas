compile:
	javac -cp byte-buddy-1.4.15.jar:. *.java

compileone:
	javac -cp byte-buddy-1.4.15.jar:. ${NAME}.java

runone:
	java -cp byte-buddy-1.4.15.jar:. ${NAME}

showone:
	javap -v -cp byte-buddy-1.4.15.jar:. ${NAME}

bootstrapmake: BootstrapExample.java
	javac -cp byte-buddy-1.4.15.jar:. BootstrapExample.java

bootsraprun: BootstrapExample.class
	java -cp  byte-buddy-1.4.15.jar:. BootstrapExample
