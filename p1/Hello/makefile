default:  Hello.g4
	antlr4  Hello.g4
	javac  Hello*.java

run:  HelloLexer.class Expression.txt
	grun  Hello prog -tokens Expression.txt

clean:
	rm -rf *.java
	rm -rf *.tokens

rm: clean
	rm -rf *.class
