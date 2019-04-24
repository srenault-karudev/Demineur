JFLAGS = -g
JC = javac
J = java
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java



CLASSES = \
	   ActionClic.java \
           ControleurDimension.java \
           Main.java \
           Raffraichisseur.java \


default: classes

classes: $(CLASSES:.java=.class)

test: classes
		$(J) Main

doc :
	mkdir document
	javadoc -d document *.java	

clean:
		rm *.class
		rm save.txt
