default:  propertyFile.g4
	antlr4  propertyFile.g4
	javac  propertyFile*.java

run:  propertyFileLexer.class Expression.txt
	grun  propertyFile file -gui Expression.txt

clean:
	rm -rf *.java
	rm -rf *.tokens

rm: clean
	rm -rf *.class
