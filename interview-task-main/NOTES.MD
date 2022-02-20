- Describe in your own words what is z-score and Min-Max scaling and why would we need to use such normalization methods? describe by example, if possible.
```
We use z-score and min max scaler to calculate the probability of a score occurring within our normal distribution
and to compare two scores that are from different normal distributions.

The diffirence between the two methods is that Min-Max scalling transform all the number to make him between 0-1
and z-score shows the relation between the number and the Mean using Standard Deviation.
Example:
If we have two different tests, the first test Means equals 70 and Standard Deviation equlas 20.
For the second test 50 and 25, the student gets a score of 80 in both tests.
z-score 80-70/20, 80-50/25. the better mark that has the higher z-score.
```

- We used Junit5 in our test cases, describe in your own words why would we use such library? 
what is unit testing and why would we use it?
```
Junit5 and all other testing labraries make sure that the code works as it should be, not only working, that's to 
avoid any bugs or functional errors while using the app, it also, provides a cleaner vision for the developer
to understand what he's working on and what's wanted from him in a more specific way when adopting TDD manner.
```
- What is the IDE did you use?
```
Intellij IDEA community
```

- Name the Java APIs you used?
```
Java SE 8 Features and OpenJDK 17.
```

- Mention down any difficulties or concerns you faced while working on the task. Your feedback is appreciated :D.
```
Data conversion without data loss to comply with the expected value in Junit5.
handling CSV files as test cases wanted
deleviring clean code
exceptions handling and getting more familiar with new types of them. 
```

- If you implement any of the bonus points, please mention it in this file
```
No bonus point.
```

- Did this task enrich technical skills or knowledge? If yes, tell us how: 
```
Yes! very much actually, first time dealing with csv files using java and it turned out to be easier than I thought,
got to know the power of handling exceptions and how it prevent the code from crashing, I now have a wider vision
of why distributing the code to many classes/interfaces makes life easier because it did for me.
```
