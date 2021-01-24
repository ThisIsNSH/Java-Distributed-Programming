# Distributed-Programming
This repository contains Nishant's version of various Distributed Programming algorithms.

[![ForTheBadge built-with-love](http://ForTheBadge.com/images/badges/built-with-love.svg)](https://GitHub.com/thisisnsh/)

## Lamport Logical Clock Algorithm
The Lamport timestamp algorithm is a simple logical clock algorithm used to determine the order of events in a distributed computer system. As different nodes or processes will typically not be perfectly synchronized, this algorithm is used to provide a partial ordering of events with minimal overhead, and conceptually provide a starting point for the more advanced vector clock method. The algorithm is named after its creator, Leslie Lamport.

#### Run Code 
```sh
$ java Lamport.java
```

## Ricart–Agrawala Mutual Exclusion Algorithm
Ricart–Agrawala algorithm is an algorithm to for mutual exclusion in a distributed system proposed by Glenn Ricart and Ashok Agrawala. This algorithm is an extension and optimization of Lamport’s Distributed Mutual Exclusion Algorithm. Like Lamport’s Algorithm, it also follows permission based approach to ensure mutual exclusion.

#### Run Code 
```sh
$ java RicartAgrawala.java
```

## Token Ring Leader Election Algorithm
This algorithm applies to systems organized as a ring(logically or physically). In this algorithm we assume that the link between the process are unidirectional and every process can message to the process on its right only. Data structure that this algorithm uses is active list, a list that has priority number of all active processes in the system.

#### Run Code 
```sh
$ java RingToken.java
```

## Bully Leader Election Algorithm
In distributed computing, the bully algorithm is a method for dynamically electing a coordinator or leader from a group of distributed computer processes. The process with the highest process ID number from amongst the non-failed processes is selected as the coordinator.

#### Run Code 
```sh
$ java Bully.java
```

