# DSA-recursion-examples

# Code
This program is fully coded in Java programming language

## Act One
This program's main purpose is to show and understand how factorial and fibonacci can be programmed using recursion

__Walkthrough of program__  
The program will first display an option to choose to perform factorial or fibonacci  

* If factorial is chosen, a number will be prompted to be input into the program.
* If fibonacci is chosen, a number (nth term) will be prompted 

This will then result in either a factorial or fibonacci operation depending on the option chosen.

## Act Two
Has the objective to show how GCD (Greatest Common Denominator) can be found using recursion

__Walkthrough of program__
* You will only need to enter two numbers of your choice which will result in the GCD of the two, to be displayed to the terminal

## Act Three
Shows the implementation of base conversions (Example: decimal to base 2 number system)

__Walkthrough of program__
* An option to enter any base conversions from decimal to a number of your choice
* Then another prompt will require you to enter the equivalent decimal number for conversion

## Act Five
Towers of Hanoi implementation

__Walkthrough of program__
* The total number of disk will be ask to be prompted (number of your choice)  
_For better display, choose a one digit number_
* outputs the action of the movement of disks from one peg to another (indentation)  

# Problems that can occur 
* A stackoverflow error may occur due to the large memory space used whenever a recursion call is made.

# Possible future enhancements
The output message can be indented in a way that looks like this:  
- Moving top disk from _source_ to _dest_  
  - Moving top disk from _source_ to _dest_  
    - Moving top disk from _source_ to _dest_  
      - Moving top disk from _source_ to _dest_  
    - Moving top disk from _source_ to _dest_  
  - Moving top disk from _source_ to _dest_  
- Moving top disk from _source_ to _dest_  

Instead of:  
- Moving top disk from _source_ to _dest_  
  - Moving top disk from _source_ to _dest_  
    - Moving top disk from _source_ to _dest_  
      - Moving top disk from _source_ to _dest_  
        - Moving top disk from _source_ to _dest_  
          - Moving top disk from _source_ to _dest_  
            - Moving top disk from _source_ to _dest_
              - Moving top disk from _source_ to _dest_  

* This shows the recursive calls, and the end of operation of towers of hanoi
