JCC = javac
JVM = java
.SUFFIXES: .java .class
.java.class: ; $(JC) $(JFLAGS) $*.java

JFLAGS = -g
DFLAGS = -d

TEST = test

StatisticsTools.class: StatisticsTools.java
	$(JCC) $(DFLAGS) ../Java-Statistics-Tools StatisticsTools.java

DrawHistogram.class: DrawHistogram.java
	$(JCC) $(DFLAGS) ../Java-Statistics-Tools DrawHistogram.java

Methods.class: Methods.java
	$(JCC) $(DFLAGS) ../Java-Statistics-Tools Methods.java

test.class: test.java
	$(JCC) $(JFLAGS) test.java

update: StatisticsTools.class DrawHistogram.class Methods.class

test: update test.class
	$(JVM) $(TEST)

clean:
	$(RM) *.class