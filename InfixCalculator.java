// Auther: Seif Mohamed Id:31732864
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;   
import java.io.IOException;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.math.RoundingMode;
import java.math.BigDecimal;


public class InfixCalculator {
	private static DecimalFormat df = new DecimalFormat("0.00");
	public static String postEval (myQueue input){
		myStack stackEv = new myStack();
		double result = 0.0;
		double temp1 = 0.0;
		double temp2 = 0.0;
		while (!input.isEmpty()){
			if(input.getFirst().toString().charAt(0) == '+'){
				if (stackEv.getLength() < 2){
					return ("This is invalid experession");
					
				}
				temp2 = Double.parseDouble(String.valueOf(stackEv.pop()));
				temp1 = Double.parseDouble(String.valueOf(stackEv.pop()));
				stackEv.push(temp1 + temp2);
				input.dequeue();	
			}

			else if(input.getFirst().toString().charAt(0) == '-'){
				if (stackEv.getLength() < 2){
					return ("This is invalid experession");
				}
				temp2 = Double.parseDouble(String.valueOf(stackEv.pop()));
				temp1 = Double.parseDouble(String.valueOf(stackEv.pop()));
				stackEv.push(temp1 - temp2);
				input.dequeue();

			}

			else if(input.getFirst().toString().charAt(0) == '!'){
				if (stackEv.getLength() < 1){
					return ("This is invalid experession");
				}
				input.dequeue();
				temp1 = Double.parseDouble(String.valueOf(stackEv.pop()));
				if (temp1 == 1.0)
					stackEv.push(0.0);
					
				else if (temp1 == 0.0)
					stackEv.push(1.0);
				
				else {
					return ("This is invalid experession");
				}
			} 

			else if(input.getFirst().toString().charAt(0) == '>'){
				if (stackEv.getLength() < 2){
					return ("This is invalid experession");
				}
				input.dequeue();
				temp2 = Double.parseDouble(String.valueOf(stackEv.pop()));
				temp1 = Double.parseDouble(String.valueOf(stackEv.pop()));
				if (Double.compare(temp1, temp2) > 0)
					stackEv.push(1.0);
					
				else if (Double.compare(temp1, temp2) == 0 || Double.compare(temp1, temp2) < 0)
					stackEv.push(0.0);
				
				else {
					return ("This is invalid experession");
				}
			} 

			else if(input.getFirst().toString().equals("sin")){
				if (stackEv.getLength() < 1){
					return ("This is invalid experession");
				}
				input.dequeue();
				temp1 = Double.parseDouble(String.valueOf(stackEv.pop()));
				stackEv.push(Math.sin(temp1));
				}

				else if(input.getFirst().toString().equals("cos")){
				if (stackEv.getLength() < 1){
					return ("This is invalid experession");
				}
				input.dequeue();
				temp1 = Double.parseDouble(String.valueOf(stackEv.pop()));
				stackEv.push(Math.cos(temp1));
				}

				else if(input.getFirst().toString().equals("tan")){
				if (stackEv.getLength() < 1){
					return ("This is invalid experession");
				}
				input.dequeue();
				temp1 = Double.parseDouble(String.valueOf(stackEv.pop()));
				stackEv.push(Math.tan(temp1));
				}
			 

			else if(input.getFirst().toString().charAt(0) == '<'){
				if (stackEv.getLength() < 2){
					return ("This is invalid experession");
				}
				input.dequeue();
				temp2 = Double.parseDouble(String.valueOf(stackEv.pop()));
				temp1 = Double.parseDouble(String.valueOf(stackEv.pop()));
				if (Double.compare(temp1, temp2) < 0)
					stackEv.push(1.0);
					
				else if (Double.compare(temp1, temp2) == 0 || Double.compare(temp1, temp2) > 0)
					stackEv.push(0.0);
				
				else {
					return ("This is invalid experession");
				}
			} 

			else if(input.getFirst().toString().charAt(0) == '='){
				if (stackEv.getLength() < 2){
					return ("This is invalid experession");
				}
				input.dequeue();
				temp2 = Double.parseDouble(String.valueOf(stackEv.pop()));
				temp1 = Double.parseDouble(String.valueOf(stackEv.pop()));
				if (Double.compare(temp1, temp2) == 0)
					stackEv.push(1.0);
					
				else if (Double.compare(temp1, temp2) < 0 || Double.compare(temp1, temp2) > 0)
					stackEv.push(0.0);
				
				else {
					return ("This is invalid experession");
				}
			} 

			else if(input.getFirst().toString().charAt(0) == '&'){
				if (stackEv.getLength() < 2){
					return ("This is invalid experession");
				}
				input.dequeue();
				temp2 = Double.parseDouble(String.valueOf(stackEv.pop()));
				temp1 = Double.parseDouble(String.valueOf(stackEv.pop()));
				if (temp1 == 1.0 && temp2 == 1.0)
					stackEv.push(1.0);
					
				else if (temp1 == 1.0 && temp2 == 0.0 || temp1 == 0.0 && temp2 == 1.0 || temp1 == 0.0 && temp2 == 0.0)
					stackEv.push(0.0);
				
				else {
					return ("This is invalid experession");
				}
			} 

			else if(input.getFirst().toString().charAt(0) == '|'){
				if (stackEv.getLength() < 2){
					return ("This is invalid experession");
				}
				input.dequeue();
				temp2 = Double.parseDouble(String.valueOf(stackEv.pop()));
				temp1 = Double.parseDouble(String.valueOf(stackEv.pop()));
				if (temp1 == 1.0 || temp2 == 1.0)
					stackEv.push(1.0);
					
				else if (temp1 == 0.0 && temp2 == 0.0)
					stackEv.push(0.0);
				
				else {
					return ("This is invalid experession");	
				}
			} 

			else if(input.getFirst().toString().charAt(0) == '*'){
				if (stackEv.getLength() < 2){
					return ("This is invalid experession");
				}
				temp2 = Double.parseDouble(String.valueOf(stackEv.pop()));
				temp1 = Double.parseDouble(String.valueOf(stackEv.pop()));
				stackEv.push(temp1 * temp2);
				input.dequeue();
			}

			else if(input.getFirst().toString().charAt(0) == '^'){
				if (stackEv.getLength() < 2){
					return ("This is invalid experession");
				}
				temp2 = Double.parseDouble(String.valueOf(stackEv.pop()));
				temp1 = Double.parseDouble(String.valueOf(stackEv.pop()));
				stackEv.push(Math.pow(temp1, temp2));
				input.dequeue();
			}

			else if(input.getFirst().toString().charAt(0) == '/'){
				if (stackEv.getLength() < 2){
					return ("This is invalid experession");
				}
				temp2 = Double.parseDouble(String.valueOf(stackEv.pop()));
				temp1 = Double.parseDouble(String.valueOf(stackEv.pop()));
				if (temp2 == 0) {
					System.out.println("can not divide by zero");
					return ("can not divide by zero");
					
				}
				else { stackEv.push(temp1 / temp2);
				input.dequeue(); }
			}

			else if(input.getFirst().toString().charAt(0) == '%'){
				if (stackEv.getLength() < 2){
					return ("This is invalid experession");
				}
				temp2 = Double.parseDouble(String.valueOf(stackEv.pop()));
				temp1 = Double.parseDouble(String.valueOf(stackEv.pop()));
				if (temp2 == 0) {
					System.out.println("can not divide by zero");
					return ("can not divide by zero");
					
				}
				else { stackEv.push(temp1 % temp2);
				input.dequeue(); }
			}

			else {
				stackEv.push(input.dequeue());
				
			}

		}	
				
			result = (Double.parseDouble(String.valueOf(stackEv.pop())));
			df.setRoundingMode(RoundingMode.DOWN);
			//result = df2.format(result);
			 //BigDecimal bd = new BigDecimal(result).setScale(2, RoundingMode.HALF_UP);
       		 //double newInput = bd.doubleValue();
       		 //System.out.println(newInput);
			 String res = df.format(result);			
			 return res;
			
			
	}


	public static boolean isNumeric(String input)
{
    try{
        double inputDbl = Integer.parseInt(input);
        return true;
    }
    catch(NumberFormatException ex)
    {
        return false;
    }
}
	public static void main (String [] args){
		
		if (args.length == 2){
		myQueue queue = new myQueue ();
		myStack stack = new myStack ();
		myQueue output = new myQueue();
		String fileName1 = args[0];
		String fileName2 = args[1];
		int c = 1;

		 try {
      File myObj = new File(fileName1);
      Scanner scnr = new Scanner(myObj);
      

      while (scnr.hasNextLine()) {
      	String currentLine;
		String currentD = "";

       currentLine = scnr.nextLine();
       for(int i = 0; i < currentLine.length(); i++){
       	if(currentLine.charAt(i) == ' ')
       		continue;
      	//stack.show();
      	//System.out.println();
       if (Character.isDigit(currentLine.charAt(i))){
       	currentD = "" + currentLine.charAt(i);
       	while (i < currentLine.length()-1 && (Character.isDigit(currentLine.charAt(i+1)) || currentLine.charAt(i+1) == '.')){
       		i++;
       		currentD = currentD + currentLine.charAt(i);
       	}
       		queue.enqueue(currentD);
       		currentD = "";
       		continue;
       }

       if (i < currentLine.length()-2 && currentLine.charAt(i) == 's' && currentLine.charAt(i+1) == 'i' && currentLine.charAt(i+2) == 'n'){
       	stack.push("sin");
       	continue;
       }

       if (i < currentLine.length()-2 && currentLine.charAt(i) == 'c' && currentLine.charAt(i+1) == 'o' && currentLine.charAt(i+2) == 's'){
       	stack.push("cos");
       	continue;
       }

       if (i < currentLine.length()-2 && currentLine.charAt(i) == 't' && currentLine.charAt(i+1) =='a' && currentLine.charAt(i+2) == 'n'){
       	stack.push("tan");
       	continue;
       }

       if (currentLine.charAt(i) == '!'){
       	if(stack.isEmpty()){
       		stack.push(currentLine.charAt(i));
       	continue;
       	}
       	while (!stack.isEmpty() && (stack.getFirst().toString().charAt(0) == '!'))
       		queue.enqueue(stack.pop());
       	stack.push(currentLine.charAt(i));
     	continue;	
       }

      	if (currentLine.charAt(i) == '^'){
       	if(stack.isEmpty()){
       		stack.push(currentLine.charAt(i));
       	continue;
       	}
       	while (!stack.isEmpty() && (stack.getFirst().toString().charAt(0) == '!'))
       		queue.enqueue(stack.pop());
       	stack.push(currentLine.charAt(i));
     	continue;	
       }




       if (currentLine.charAt(i) == '*' || currentLine.charAt(i) == '/' || currentLine.charAt(i) == '%'){
       	if(stack.isEmpty()){
       		stack.push(currentLine.charAt(i));
       	continue;
       	}
       	while (!stack.isEmpty() && (stack.getFirst().toString().charAt(0) == '^' 
       	|| stack.getFirst().toString().charAt(0) == '*' || stack.getFirst().toString().charAt(0) == '/' || stack.getFirst().toString().charAt(0) == '%'))
       		queue.enqueue(stack.pop());
       	stack.push(currentLine.charAt(i));
     	continue;
       	
       }


       if (currentLine.charAt(i) == '+' || currentLine.charAt(i) == '-'){
       	if(stack.isEmpty()){
       		stack.push(currentLine.charAt(i));
       	continue;
       	}
       while (!stack.isEmpty() && (stack.getFirst().toString().charAt(0) == '*' || stack.getFirst().toString().charAt(0) == '/' ||
        stack.getFirst().toString().charAt(0) == '%'|| stack.getFirst().toString().charAt(0) == '^' 
        || stack.getFirst().toString().charAt(0) == '+' || stack.getFirst().toString().charAt(0) == '-' || stack.getFirst().toString().charAt(0) == '!' ))
       	queue.enqueue(stack.pop());
       
      
      
       	stack.push(currentLine.charAt(i));
       	continue;
       }

       if (currentLine.charAt(i) == '>' || currentLine.charAt(i) == '<'){
       	if(stack.isEmpty()){
       		stack.push(currentLine.charAt(i));
       	continue;
       	}
       while (!stack.isEmpty() && (stack.getFirst().toString().charAt(0) == '*' || stack.getFirst().toString().charAt(0) == '/' ||
        stack.getFirst().toString().charAt(0) == '%' || stack.getFirst().toString().charAt(0) == '^' 
        || stack.getFirst().toString().charAt(0) == '+' || stack.getFirst().toString().charAt(0) == '-' || stack.getFirst().toString().charAt(0) == '!' 
        || stack.getFirst().toString().charAt(0) == '<' || stack.getFirst().toString().charAt(0) == '>' ))
       	queue.enqueue(stack.pop());
       
      
      
       	stack.push(currentLine.charAt(i));
       	continue;
       }

       if (currentLine.charAt(i) == '='){
       	if(stack.isEmpty()){
       		stack.push(currentLine.charAt(i));
       	continue;
       	}
       while (!stack.isEmpty() && (stack.getFirst().toString().charAt(0) == '*' || stack.getFirst().toString().charAt(0) == '/' ||
        stack.getFirst().toString().charAt(0) == '%'
        || stack.getFirst().toString().charAt(0) == '+' || stack.getFirst().toString().charAt(0) == '-' || stack.getFirst().toString().charAt(0) == '!' 
        || stack.getFirst().toString().charAt(0) == '<' || stack.getFirst().toString().charAt(0) == '>' || stack.getFirst().toString().charAt(0) == '='
         || stack.getFirst().toString().charAt(0) == '^' ))
       	queue.enqueue(stack.pop());
       
      
      
       	stack.push(currentLine.charAt(i));
       	continue;
       }

       	if (currentLine.charAt(i) == '&'){
       	if(stack.isEmpty()){
       		stack.push(currentLine.charAt(i));
       	continue;
       	}
       while (!stack.isEmpty() && (stack.getFirst().toString().charAt(0) == '*' || stack.getFirst().toString().charAt(0) == '/' ||
        stack.getFirst().toString().charAt(0) == '%'
        || stack.getFirst().toString().charAt(0) == '+' || stack.getFirst().toString().charAt(0) == '-' || stack.getFirst().toString().charAt(0) == '!' 
        || stack.getFirst().toString().charAt(0) == '<' || stack.getFirst().toString().charAt(0) == '>' || stack.getFirst().toString().charAt(0) == '=' 
       	|| stack.getFirst().toString().charAt(0) == '&' || stack.getFirst().toString().charAt(0) == '^' ))
       	queue.enqueue(stack.pop());
      
      
       	stack.push(currentLine.charAt(i));
       	continue;
       }

       if (currentLine.charAt(i) == '|'){
       	if(stack.isEmpty()){
       		stack.push(currentLine.charAt(i));
       	continue;
       	}
       while (!stack.isEmpty() && (stack.getFirst().toString().charAt(0) == '*' || stack.getFirst().toString().charAt(0) == '/' ||
        stack.getFirst().toString().charAt(0) == '%'
        || stack.getFirst().toString().charAt(0) == '+' || stack.getFirst().toString().charAt(0) == '-' || stack.getFirst().toString().charAt(0) == '!' 
        || stack.getFirst().toString().charAt(0) == '<' || stack.getFirst().toString().charAt(0) == '>' || stack.getFirst().toString().charAt(0) == '=' 
       	|| stack.getFirst().toString().charAt(0) == '&' || stack.getFirst().toString().charAt(0) == '|' || stack.getFirst().toString().charAt(0) == '^' ))
       	queue.enqueue(stack.pop());
      
      
       	stack.push(currentLine.charAt(i));
       	continue;
       }


      

       if (currentLine.charAt(i) == '('){
       		stack.push(currentLine.charAt(i));
       	continue;
       }

       if (currentLine.charAt(i) == ')'){

       			if(stack.isEmpty()){
       				System.out.println("Misssing ( ");
       				break;
       				}
       			while (!stack.isEmpty() && stack.getFirst().toString().charAt(0) != '(')
       				queue.enqueue(stack.pop());
       			if (!stack.isEmpty() && stack.getFirst().toString().charAt(0) == '(')
       				stack.pop();
       			else {
       				System.out.println("Misssing ( ");
       				break;
       			}
       			if (!stack.isEmpty() && (stack.getFirst().equals("sin") || stack.getFirst().equals("cos") || stack.getFirst().equals("tan"))) {
       				queue.enqueue(stack.pop());
       			}
       			
       }



       
      	}
      	while(!stack.isEmpty())
      		queue.enqueue(stack.pop());
      
      		System.out.println("Line " + c + "postifix form is ");
      		queue.show();
      		c++;
      		output.enqueue(postEval (queue));

      		queue = new myQueue ();
			stack = new myStack ();

       }
      scnr.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
      e.printStackTrace();
	}
	
	  try {
      FileWriter myWriter = new FileWriter(fileName2);
      while (!output.isEmpty())
      myWriter.write(output.dequeue() + "\n");
      myWriter.close();
      System.out.println("Project 1 done");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
}
else {
	System.out.println("enter two arguments please");
}
}
}