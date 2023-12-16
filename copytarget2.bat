set JAVA_HOME=c:\progr\java\jdk-17.0.9
call c:\progr\java\apache-maven-3.6.3\bin\mvn package 


echo "COMPILE OK"
del ..\keycloak-23.0.1\providers\ggps-redir-spi-4.0.1-SNAPSHOT.jar
echo "DEL OK"
copy /Y target\ggps-redir-spi-4.0.1-SNAPSHOT.jar ..\keycloak-23.0.1\providers

echo "COPY OK"