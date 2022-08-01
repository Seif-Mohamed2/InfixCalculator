# InfixCalculator

<h2> Introduction </h2><hr>

InfixCalculator is a calculator that takes a string input of a mathematical operation. Then ouput the results taking precedence of operators in consideration. In other words, the program would evaluate 4 + 3 * 2 to be 10 rather than 14. The program also tells you if the experession entered in not valid such as 2 + + 2
<br>
<h2>Files in the program</h2>
I created my own data structure for stack and queue to be simple and with some additional methods to help debugging. The data structure files are:
Node.java: Node object used in both queue and stack
Linkedlist.java: simple linkedlist implementation
myQueue: simple queue implementation 
myStack: simple stack implementation 
<strong>InfixCalculator </strong>: contain main algorithm and funcions 
<h2>Simple explaination </h2><hr>

The program uses stacks and queues to verify which operators are going to be performed first. The algorithm is divided into two stages: <br>
<strong>1- arranging the input into queue using the precedence of operands<br>
  2- evaluating the generated queue.</strong>
