CO = -g
JAVAC = javac
JCFLAG = -encoding UTF-8 -implicit:none
RM = rm
JVM= java
JVMFLAG=
FILE=
.SUFFIXES: .java .class
.java.class: 
	$(JAVAC) $(CO) $*.java

CLASSES = \
		Dessin.java\
		Panel.java \
		Mouse.java \
        Windows.java
        

WINDOWS = Main





classes: $(CLASSES:.java=.class)

default: classes

clean: $(RM) *.class

test: classes
	$(JVM) $(WINDOWS)

classes: $(CLASSES:.java=.class)

run: Windows.class
	$(JVM) $(JVMFLAG) Windows



clean :
	-rm -f *.class

mrproper : clean Windows.class



.class : run clean mrproper

