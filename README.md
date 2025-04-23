# Programming Languages – In-Class Test

This repository contains a Java application developed during a live in-class test for the **Programming Languages** course.  
The goal was to demonstrate understanding of GUI programming, user interaction handling, and basic simulation logic using Java and Swing.

<div align="center">
  <img src="https://github.com/user-attachments/assets/6dbb6e9a-2b74-4bd2-9424-e9d43f639d65" width="600"/>
</div>



## Task Overview

The assignment was to implement a program with the following features:

- The user can **draw rectangles** on the screen by clicking two opposite corners.
- Once drawn, the rectangles **move in the direction of gravity**.
- Gravity is **controllable via arrow keys**:
  - ↑ Arrow – gravity pulls **up**
  - ↓ Arrow – gravity pulls **down**
  - ← Arrow – gravity pulls **left**
  - → Arrow – gravity pulls **right**

Each rectangle moves continuously in the current gravity direction unless it hits the edge of the window.

## Technologies Used

- **Java**
- **Swing** (for GUI)

- Object-oriented design with basic multithreading

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/Bartolomeooo/programming-languages-in-class-test.git
   cd programming-languages-in-class-test

2. Compile and run:
   ```bash
   javac -d out src/**/*.java
   java -cp out Main
