default:  cymbol.g4
	antlr4  cymbol.g4
	javac  cymbol*.java

run:  cymbolLexer.class Expression.txt
	grun  cymbol cymbol -gui Expression.txt

clean:
	rm -rf *.java
	rm -rf *.tokens

rm: clean
	rm -rf *.class
