# Lab 6 Conclusions

This lab introduced the principles of Test-Driven Development (TDD) through the implementation of a Traffic Light Controller modeled as a finite state machine. The objective was to design a system controlling a four-way intersection while ensuring safe state transitions and preventing conflicting traffic signals.

## Learning Outcomes

After completing this lab, I am able to:

* Understand the fundamentals of Test-Driven Development (TDD).
* Apply the Red-Green-Refactor development cycle.
* Create unit tests before or alongside implementation.
* Verify system behavior through automated testing.
* Identify edge cases and validate system correctness.
* Use JUnit to create and execute unit tests in Java.
* Improve software reliability through systematic testing.

## Project Overview

The implemented Traffic Light Controller models a four-way intersection using four states:

* North-South Green
* North-South Yellow
* East-West Green
* East-West Yellow

The controller follows a fixed transition sequence:

```text
NS_GREEN → NS_YELLOW → EW_GREEN → EW_YELLOW → NS_GREEN
```

The implementation guarantees that both directions can never display a green signal simultaneously, ensuring safe traffic operation.

## Testing Strategy

A comprehensive suite of unit tests was developed to verify:

* Correct initial state assignment.
* Proper transitions between all traffic light states.
* Completion of a full state cycle.
* Prevention of simultaneous green signals in perpendicular directions.
* Correct behavior after multiple consecutive transitions.
* Long-term state consistency during extended operation.

## Summary

The lab demonstrated how TDD can be used to incrementally develop reliable software by defining expected behavior through tests. The Traffic Light Controller provided a practical example of combining state-machine design with automated unit testing to ensure correctness, maintainability, and safety-critical behavior.
