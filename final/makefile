compile:
	javac -cp po-uilib.jar:.:pex-support.jar `find pex -name *.java`

run:
	java -cp po-uilib.jar:.:pex-support.jar pex.app.App

test:
	chmod +x runtests.sh ; xterm -e ./runtests.sh

compilet:
	make; make clean

tests:
	./runtests.sh

clean:
	find . -name "*.class" -type f -delete
