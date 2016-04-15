default:  dot.g4
	antlr4  dot.g4
	javac  dot*.java

run:  dotLexer.class Expression.txt
	grun  dot dot -gui Expression.txt

clean:
	rm -rf *.java
	rm -rf *.tokens

rm: clean
	rm -rf *.class
