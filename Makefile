# Makefile
# Jia-hui Ma
# jma289
# pa5
# A simple Makefile for the Queens program
Queens: Queens.class
        echo Main-class: Queens > Manifest
        jar cvfm Queens Manifest Queens.class
        rm Manifest
        chmod u+x Queens
Queens.class: Queens.java
        javac -Xlint Queens.java
clean:
        rm -f Queens.class Queens
submit: Makefile Queens.java
        submit cmps012a-pt.w18 pa5 Makefile Queens.java
check:  
        ls /afs/cats.ucsc.edu/class/cmps012a-pt.w18/pa5/jma289
