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
<br>
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

The project worked perfectly on each test I tried.
So first I created linkedlist class and made some methods that helped me create the stack and the queue. I also added some methods
were not essential to the program working but it helped me find bugs. Like show() method which print all elements in the linkedlist 
this helped me to trace the queue and the stack to find bugs while the program ran. 

The main class (InfixCalculator) contains a main method. The first thing this main method check if the line command has
two arguements becuase if not the program will ask you to input two args (One possible error handled)
also if the filename for input you entered in the commandline does not exist the program throws an excpetion (second error handled)

So if the command has two arguemnts the program creates stack and queue and start performing shunting yard algorithm on each line until 
there is no other line in the input file.

The program starts to check character by character in the line
if the character is spaced just ignore it. if it's a number (checked using isnumeric method defined in the class) the program check the next character to check if it is a number of a . until
the number ends and then store that number in the queue
if the char is s or c or t the program check for the next to char to determine whether the tokin is sin, cos or tan if yes the program add
them to the stack(Extra credit for sin, cos and tan)

After that you will see that the program checks if the char is any of the operators if yes then it performs the algorithm by poping from the stack the higher or equal
precedence for all operators except for ^ as it only pop elements of higher precedence not equal precedence because
it is right to left evaluated ( ^ % are included (extra credit))

Finally after perfomring each step of the shunting yard algorithm, any other elements left in the stack are poped to the queue. 

After finishing the queue a method is called and applied on the queue. this method is postfix exaluation as the queue is now in postfix
form. The method is defined in the class and it takes queue as argument. 

The method create new stack and check for every operator and apply the operator to the next next numbers in the stack. Before performing
each operation the algorithm check if there are enough elements in the stack for the operation(for example in addition before perforimg
the alogirthm check if there are at least two elements in the stack (third error handled))

For ! operation if the number in the stack is not 0 or 1 the method returns invalid and breaks immediately (fourth error handled)


For  & and | the algorithm check if the two operands are 0s or 1s or both if not they return invalid and breaks immediatly(fifth error handled)

for / and % if the the second number is 0 the method returns invalid and break (sixth error handled)

then the result is converted to double and stored in a queue to be printed in the output file.

After that the queue and stack used in the first part are emptied to use them for the second line.

after the inut file is finished the output file get created and all elements in the evaluated queued are printed in it.
