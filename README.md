# GitHub REST Service Example

- I use **Maven**, because I use it every day,
- I use **Retrofit** as HTTP client, because I wanted to try something different than the standard **RestTemplate** HTTP Client (used only in tests),
- Package **integration** could be separate module and then could be create parent project (parent pom.xml) and a lot of child projects,
- In real world should be added pagination and sorting to endpoint,
- In real world dependencies should be manage by dependencyManagement in parent pom.xml,
- In real world I should logger configure for example by aspects,
- In real world in parent pom.xml must be define profiles and activate the appropriate profile depending environment,
- In real world exceptions from integration must be better handled,
- In real world API should limit requests (for example, to prevent DDoS attacks).

## Performance test
I created tests with **Gatling** and wrote in Scala. \
First run **REST Service** and next run tests:
````
cd github-rest-service-performance-test
mvn gatling:execute
````
**Simple report** will be displayed in the console. \
**Advanced report** will be available in target/gatling folder as HTML file with a lot of charts for optimization freaks :)