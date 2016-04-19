default:  csv.g4
	antlr4  csv.g4
	javac  csv*.java

run:  csvLexer.class Expression.txt
	grun  csv file -gui Expression.txt

clean:
	rm -rf *.java
	rm -rf *.tokens

rm: clean
	rm -rf *.class
