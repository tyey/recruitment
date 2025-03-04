# Recruitment project

### Before you start:
* Get familiar with the project by quickly reviewing it structure, modules and dependencies.

### Task 1
* Build project in terminal with `./gradlew clean build` command.
* Run module 'environment' with `./gradlew :environment:bootRun` command or in your ide - keep it running it will be needed during whole interview.
* Remove @Disabled annotation from `ReviewSourceIntegrationTest` class in module 'review-source'.
* Run the build again and make sure build is stable and all tests are green.

#### Note: After first run of `environment` app in your project directory 2 folders will be created: `data` with h2 database and `kafka-logs` with kafka data.

### Task 2
* Design the REST layer in module `review-source` according to standards which you think are the most important. Follow clean code and architecture principles which you are using on daily basis.
* Implement endpoints which:
  * allow to get all reviews of a product,
  * allow to add new review for existing product.

### Task 3
* Run module 'event-producer' with `./gradlew :event-producer:bootRun` command or in your ide.
* Design and implement module `event-consumer` which will consume all produced customer events and persist them in a database table `customer_events`.

#### Note: You can analyze sent raw data here: `event-producer/src/main/resources/data.json`
#### Note: Database schema is already created in module 'environment' with use of flyway migration. You can connect to the database with url: `jdbc:h2:tcp://localhost:9090/./data/db` and credentials: `sa`/`sa`. 

# Good Luck!
