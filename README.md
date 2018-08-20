# vapor-test
Simple Mockup Classes to test the Vapor Drone Control System

This is a simple Java Maven project

It just contains a Itinerary JSON file converter and executes command through a drone mockup that prints command status on the main console.

To test the code:

1. you must download all the 4 repositories

2. run the following maven command

```mvn clean install```

In each project folder with this sequence:

```vapor-model```
```vapor-dsl/co.watly.vapor.dsl``` <-- this tooks very long time, so every time (except first) you edit its code, you better run ```mvn -o clean install```, if you did not introduce any new dependency to download
```vapor-controller```
```vapor-test```

2a. The project ```vapor-dsl/co.watly.vapor.dsl.ui``` is just useful to run the Vapor DSL's editor as Eclipse Plugin

3. Create a JSON file reporting star and end coordinates like this:

```{
	"start" : {
		"latitude": 45.798651,
		"longitude" : 13.212938,
		"height" : 300
	},
	"end" : {
		"latitude": 45.799940,
		"longitude" : 13.212957,
		"height" : 0
	},
	"maxHeight" : 800,
	"weight" : 30
}```

4. run the ```vapor-test``` code using the following command:

```java -javaagent:./bin/ea-async-1.2.0.jar -cp "./*;bin/*" co.watly.vapor.test.Main path/to/itinerary.json```