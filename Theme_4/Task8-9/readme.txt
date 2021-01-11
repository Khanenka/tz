                                 Задание 8
Установите web приложение на Tomcat сервер. Настройте контекст приложения
таким образом, чтобы war файл автоматически распаковывался при запуске сервером
приложений. Проверьте работоспособность вашего приложения.
                            Решение 8 задания
1)Создал проект в IJ
2)Добавил джава класс с аннотацией-> @WebServlet(name = "HomeworkServlet", urlPatterns = "/homework")
3)Зашел в СATALINA_HOME/conf/server.xml.настроил :unpackWARs="true".
4)добавил в POM.xml:<packaging>war</packaging>

    <dependencies>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>4.0.1</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
    </properties>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-war-plugin</artifactId>
                <version>3.3.1</version>
            </plugin>
            <plugin>
                <groupId>org.apache.tomcat.maven</groupId>
                <artifactId>tomcat7-maven-plugin</artifactId>
                <version>2.2</version>
                <executions>
                    <execution>
                        <id>deployToTomcat9</id>
                        <phase>install</phase>
                        <goals>
                            <goal>undeploy</goal>
                            <goal>deploy</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
                    <username>tomcat</username>
                    <password>tomcat</password>
                </configuration>
            </plugin>
5)запустил tomcat
6)задеплоил и проверил сервлет
                                 
                                   Задание 9
Соберите ваше веб приложение при помощи maven. Установите, переустановите,
посмотрите статус сервера при помощи Tomcat maven plugin. Опишите проблемы,
возникшие при использовании, и попробуйте их решить.

                                    Решение 9 задания
Добавил в 8 задание плагин: <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>tomcat-maven-plugin</artifactId>
                <version>1.1</version>
                <configuration>
                    <port>8080</port>
                    <url>http://localhost:8080/manager/text</url>
                    <path>/</path>
                    <username>tomcat</username>
                    <password>tomcat</password>
                </configuration>
            </plugin>

вызвал команды:mvn tomcat:redeploy;
--- tomcat-maven-plugin:1.1:redeploy (default-cli) @ Task8-9 ---
[INFO] Deploying war to http://localhost:8080/
[INFO] OK - Приложение успешно развёрнуто в контекстном пути [/]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.893 s
[INFO] Finished at: 2020-12-24T14:41:01+03:00
[INFO] ------------------------------------------------------------------------
mvn tomcat:deploy;
Deploying war to http://localhost:8080/
[INFO] OK - Приложение успешно развёрнуто в контекстном пути [/]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.072 s
[INFO] Finished at: 2020-12-24T14:04:22+03:00
[INFO] ------------------------------------------------------------------------
mvn tomcat:start;
 Starting application at http://localhost:8080/
[INFO] OK - Запущено приложение по пути контекста [/]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.758 s
[INFO] Finished at: 2020-12-24T14:04:52+03:00
[INFO] ------------------------------------------------------------------------

mvn tomcat:stop;
 Stopping application at http://localhost:8080/
[INFO] OK - Остановлено приложение по пути контекста [/]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.763 s
[INFO] Finished at: 2020-12-24T14:05:07+03:00
[INFO] ------------------------------------------------------------------------
mvn tomcat:sessions;
 Listing session information for application at http://localhost:8080/
[INFO] OK - Информация о сеансах приложения по пути контекста [/]
[INFO] Стандартный максимальный период неактивного сеанса: [30] минут
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.596 s
[INFO] Finished at: 2020-12-24T14:05:24+03:00
[INFO] ------------------------------------------------------------------------
mvn tomcat:list;
Listing applications at http://localhost:8080/manager/text
[INFO] OK - Список приложений для виртуального хоста [localhost]
[INFO] /:stopped:0:ROOT
[INFO] /tomcat-quickstart-1.0-SNAPSHOT:running:0:tomcat-quickstart-1.0-SNAPSHOT
[INFO] /examples:running:0:examples
[INFO] /host-manager:running:0:host-manager
[INFO] /Task8-9-1.0-SNAPSHOT:running:0:Task8-9-1.0-SNAPSHOT
[INFO] /homework:running:0:homework
[INFO] /manager:running:0:manager
[INFO] /Task8-9:running:0:Task8-9
[INFO] /tomcat-quickstart:running:0:tomcat-quickstart
[INFO] /docs:running:0:docs
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.644 s
[INFO] Finished at: 2020-12-24T14:39:50+03:00
[INFO] ------------------------------------------------------------------------
mvn tomcat:info;
 Listing server information at http://localhost:8080/manager/text
[INFO] OK - Server info
[INFO] Tomcat Version: [Apache Tomcat/9.0.41]
[INFO] OS Name: [Windows 10]
[INFO] OS Version: [10.0]
[INFO] OS Architecture: [amd64]
[INFO] JVM Version: [11+28]
[INFO] JVM Vendor: [Oracle Corporation]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.685 s
[INFO] Finished at: 2020-12-24T14:05:45+03:00
[INFO] ------------------------------------------------------------------------


