# InfixCalculator

<h2> Introduction </h2>

InfixCalculator is a calculator that takes a string input of a mathematical operation. Then ouput the results taking precedence of operators in consideration. In other words, the program would evaluate 4 + 3 * 2 to be 10 rather than 14. The program also tells you if the experession entered in not valid such as 2 + + 2
<br>
<h2>Files in the program</h2>
I created my own data structure for stack and queue to be simple and with some additional methods to help debugging. The data structure files are:<br>
Node.java: Node object used in both queue and stack<br>
Linkedlist.java: simple linkedlist implementation<br>
myQueue: simple queue implementation <br>
myStack: simple stack implementation <br>
<strong>InfixCalculator </strong>: contain main algorithm and functions <br>
<h2>Simple explanation </h2>

The program uses stacks and queues to verify which operators are going to be performed first. The algorithm is divided into two stages: <br>
<strong>1- arranging the input into queue using the precedence of operands<br>
  2- evaluating the generated queue.</strong>
  <br><br>
 Arranging the input into the queue is done using a stack of  operators. When an operator is found in the input it’s either directly added to the stack or we first remove all elements on top of the stack with higher precedence to this operator and add them to the queue. <i><strong>This operation takes place in the main function</i></strong>

<br>
Evaluating the queue takes place in postEval function defined in infixcalculator. The function takes the operator in the queue and its operand/s then evaluates it and adds it to the final result. <br>

<h2>Supported operators</h2>
Supported operators by the program: + - * / % ^ &| > < ! == != <= >= <br>
Supported functions: sin(), cos(), tan() <br>

<h2>Output example</h2>
Input file: <br>
1 + 2 ^ 2 - 3 * 8 <br>
3 * 10 + 2 ^ 3 <br>
3 * ( 1 + 2 ) <br>
cos ( 0 ) <br>
tan ( 1 ) <br>
2 + + 1 <br>
1 > 0 <br>
1 | 0 <br> 
1 & 0 <br>

Output file: <br>
-19.00 <br>
38.00 <br>
9.00 <br>
1.00 <br>
1.55 <br>
This is invalid expression <br>
1.00 <br> 
1.00 <br>
0.00 <br>



<h2>How to run </h2>
In the folder there is “sources.txt” file this file has all java files you need to run.
In command line or terminal window, run:

```powershell
Javac @sources.txt
```
That compiles all files in the project.
Then run
```powershell
Java InfixCalculator [testfile] [outputfile]
```
For example: 
```powershell
Java InfixCalculator testcases.txt output.txt
```
Then you find the output in the output text file.

<h2>Detailed explanation</h2>


