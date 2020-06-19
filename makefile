install:
	sudo systemctl stop tomcat
	sudo rm -rf /usr/share/tomcat/webapps/my_servlet /usr/share/tomcat/webapps/my_servlet.war
	sudo cp target/my_servlet.war /usr/share/tomcat/webapps
	sudo systemctl start tomcat

test:
	curl -v localhost:8080/my_servlet/hi
	curl -v localhost:8080/my_servlet/params?name=Randy
	curl -v localhost:8080/my_servlet/headers
	curl -v localhost:8080/my_servlet/headers -H 'Accept-Language: fil-US,en;q=0.9,it;q=0.8'
	curl -v localhost:8080/my_servlet/headers -H 'Accept-Language: es-US,en;q=0.9,it;q=0.8'
