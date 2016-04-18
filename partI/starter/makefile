default:  ArrayInit.g4
	antlr4  ArrayInit.g4
	javac  ArrayInit*.java

run:  ArrayInitLexer.class Expression.txt
	grun  ArrayInit init -gui Expression.txt

clean:
	rm -rf *.java
	rm -rf *.tokens

rm: clean
	rm -rf *.class
