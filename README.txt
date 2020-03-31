Requirements: 

1.Download JDK#8 or higher version in your local machine (from https://www.oracle.com/java/technologies/javase-downloads.html)

2.Ensure that JDK is in your path 

    Open Terminal, type the following command and hit return.

    export JAVA_HOME=/Library/Java/Home
    Type the following command on terminal to confirm the path.

    echo $JAVA_HOME

3.Compile 
   
   javac ContentReader.java

4. Exceute by passing 2 command line arguments
    Arg#1: URL to be parsed
    Arg#2: CSS Class name in which the header content links are stored.
    
    For example:
    java ContentReader https://www.apple.com/mac/ chapternav-label
    or
    java ContentReader https://www.apple.com/ipad/ chapternav-label
    or
    java ContentReader https://www.apple.com/iphone/ chapternav-label
    