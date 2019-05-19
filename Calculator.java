/*
 * Calculator - take an infix string, change to postfix notation and evaluate.
 * Gurnit Kaur
 * 3/25/19
 */
public class Calculator  
{

  // Take an infix arithmetic expression and return a postfix arithmetic expression.
  public String infixToPostfix(String infixNotation)
  {
   GenericList<String> stack = new GenericList<String>();
   String postfix = "";
   Parse p = new Parse(infixNotation);
   String str;
   while (true)
   {
     	// 1. Read a token from the infix expression.
      str = p.getNextToken();
      if(str == "")
         break;
         
   	// 2. If the token is a number, then add it to the postfix expression.
      if(!p.isOperator(str))
      {
         postfix = postfix + str + " ";
         continue;
      }
      
   	// 3. If the stack is empty or contains a left parenthesis on top,
   	//    push the token onto the stack
      if(stack.isEmpty() || stack.peek().equals("(")) 
      {
         stack.push(str);
         continue;
      }


    	// 4. If the token is a left parenthesis, push it on the stack.
      if(str.equals("("))
      {
        stack.push(str);
         continue;
      }
            

   	// 5. If the token is a right parenthesis, pop the stack and add value
   	//    to the postfix expression. Repeat until you see a left parenthesis.
   	//    Discard the left and right parenthesis.       
      if(str.equals(")"))
      {
         while(!stack.isEmpty() && stack.peek() != "(")
         {
           postfix = postfix + stack.pop() + " "; 
           break;
         }
        if(!stack.isEmpty() )
         stack.pop();                                          
           
      }   
 
   	// 6. If the token is ^ (which is right associative) and
   	//    has equal precedence as top of stack
   	//    ( the only operation of equal precedence is ^ ), push it onto the stack.
   	//    If the token has higher precedence as top of stack,
   	//    push it on the stack.
      else if(!stack.isEmpty() && str.equals("^")  && p.lessThanEqualTo(str, stack.peek()))
      {
           stack.push(str);
           if(!p.lessThanEqualTo(str , stack.peek())) 
               stack.push(str);         
      }                     
     
   
   	// 7. If the token has precedence equal to or less than the top of stack,
   	///    pop the stack and add value to the postfix expression.
   	//    Then test the token against the new top of stack and repeat.
   	//    Push the token onto the stack.
     else
     {
         while(!stack.isEmpty() && p.lessThanEqualTo(str, stack.peek()))
         {
           postfix = postfix + stack.pop() + " ";   
         }
          stack.push(str);
          continue;
         
     }    
   }
    	// 8. At the end of the expression,
   	//    pop all values from the stack and add to the output queue.  
   
    while(!stack.isEmpty())
      {
         postfix = postfix + stack.pop()+ " " ;
      }   
   return postfix;
 }

  public int evaluatePostfix(String postfixNotation)
  {
   GenericList<Integer> stack = new GenericList<Integer>();
   Parse p = new Parse(postfixNotation);
   String token = p.getNextToken(); 
   while( token != "")
   {        
      if(!p.isOperator(token))
         stack.push(Integer.parseInt(token));       
      else
      {
         int n2 = stack.pop();   
         int n1 = stack.pop();   
                    
            switch(token)
            {
               case "+":
               stack.push(n1 + n2);
               break;
               
               case "-":
               stack.push(n1-n2);
               break;
               
               case "/":
               stack.push(n1/n2);
               break;
               
               case "*":
               stack.push(n1*n2);
               break;
               
               case "^":
               stack.push((int)Math.pow(n1, n2));
               break;             
           
            }
         } token = p.getNextToken(); 
   }
   
   return stack.pop();
   
   // 1. Push operands onto the stack.
    
	// 2. When you see an operator, pop the first operand off the stack
	//    and place to the right of the operator. Pop the next operand
	//    off the stack and place to the left of the operator.
   
	// 3. Perform the operation and push the result onto the stack.

	// 4. Repeat from step 1 until expression is completed.

	// 5. The value at the top of the stack is the result.
  }

  public static void main(String[] args)
  {
    String infixNotation;
    String postfixNotation;
    int calculatedValue;

    // Take the first argument from the command line as a string with
    // infix notation.
    if (args.length == 0)
    {
      System.out.println("You need to enter an infix notation string");
      System.exit(1);
    }
    infixNotation = args[0];
    System.out.println("You entered: " + infixNotation);
    postfixNotation = new Calculator().infixToPostfix(infixNotation);
    System.out.println("Postfix notation: " + postfixNotation);
    calculatedValue = new Calculator().evaluatePostfix(postfixNotation);
    System.out.println("Result of evaluation: " + calculatedValue);
  }
}
