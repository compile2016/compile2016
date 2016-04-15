default:  r.g4
	antlr4  r.g4
	javac  r*.java

run:  rLexer.class Expression.txt
	grun  r r -gui Expression.txt

clean:
	rm -rf *.java
	rm -rf *.tokens

rm: clean
	rm -rf *.class
