default:  json.g4
	antlr4  json.g4
	javac  json*.java

run:  jsonLexer.class Expression.txt
	grun  json json -tokens Expression.txt

clean:
	rm -rf *.java
	rm -rf *.tokens

rm: clean
	rm -rf *.class
