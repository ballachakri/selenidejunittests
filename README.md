**Selenide Junit5 Allure reports**

to run tests
> mvn clean test
> allure serve target/allure-results

**allure.properties file in resource folder**
allure.results.directory=target/allure-results

**dependencies**

<properties>
<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
<maven.compiler.release>21</maven.compiler.release>
<allure.version>2.26.0</allure.version>
<aspectj.version>1.9.22</aspectj.version>
</properties>

    <dependencyManagement>
        <dependencies>
            <!-- https://mvnrepository.com/artifact/io.qameta.allure/allure-bom -->
            <dependency>
                <groupId>io.qameta.allure</groupId>
                <artifactId>allure-bom</artifactId>
                <version>2.26.0</version>
                <type>pom</type>
            </dependency>
            <!-- https://mvnrepository.com/artifact/org.junit/junit-bom -->
            <dependency>
                <groupId>org.junit</groupId>
                <artifactId>junit-bom</artifactId>
                <version>5.10.2</version>
                <type>pom</type>
                <scope>test</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <dependencies>
        <!-- https://mvnrepository.com/artifact/com.codeborne/selenide -->
        <dependency>
            <groupId>com.codeborne</groupId>
            <artifactId>selenide</artifactId>
            <version>7.7.1</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/io.qameta.allure/allure-selenide -->
        <dependency>
            <groupId>io.qameta.allure</groupId>
            <artifactId>allure-selenide</artifactId>
            <version>2.28.0</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/io.qameta.allure/allure-junit5 -->
        <dependency>
            <groupId>io.qameta.allure</groupId>
            <artifactId>allure-junit5</artifactId>
            <version>2.26.0</version>
            <scope>test</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.assertj/assertj-core -->
        <dependency>
            <groupId>org.assertj</groupId>
            <artifactId>assertj-core</artifactId>
            <version>3.27.3</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

**build plugins**

<build>
<plugins>
<plugin>
<groupId>org.apache.maven.plugins</groupId>
<artifactId>maven-surefire-plugin</artifactId>
<version>3.2.5</version>
<configuration>
<testFailureIgnore>false</testFailureIgnore>
<argLine>-Dfile.encoding=${project.build.sourceEncoding}
-javaagent:"${settings.localRepository}/org/aspectj/aspectjweaver/${aspectj.version}/aspectjweaver-${aspectj.version}.jar"
</argLine>
</configuration>
<dependencies>
<dependency>
<groupId>org.aspectj</groupId>
<artifactId>aspectjweaver</artifactId>
<version>${aspectj.version}</version>
</dependency>
</dependencies>
</plugin>
</plugins>
</build>