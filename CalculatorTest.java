import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * Test the Calculator class
 */
public class CalculatorTest
{ 
  @Test
  public void testInfixToPostfix1()
  {
    Calculator c = new Calculator();
    assertEquals("2 3 4 * + 5 - ", c.infixToPostfix("2 + 3 * 4 - 5"));
  }

  @Test
  public void testInfixToPostfix2()
  {
    Calculator c = new Calculator();
    assertEquals("5 3 - 2 2 / + ", c.infixToPostfix("5 - 3 + 2 / 2"));
  }

  @Test
  public void testInfixToPostfix3()
  {
    Calculator c = new Calculator();
    assertEquals("3 2 3 ^ * 1 + ", c.infixToPostfix("3 * 2 ^ 3 + 1"));
  }

  @Test
  public void testInfixToPostfix4()
  {
    Calculator c = new Calculator();
    assertEquals("1 4 + 5 2 - * ", c.infixToPostfix("( 1 + 4 ) * ( 5 - 2 )"));
  }

  @Test
  public void testInfixToPostfix5()
  {
    Calculator c = new Calculator();
    assertEquals("7 1 4 2 - + 2 ^ * 5 * ", c.infixToPostfix("7 * ( 1 + ( 4 - 2 ) ) ^ 2 * 5"));
  }

  @Test
  public void testInfixToPostfix6()
  {
    Calculator c = new Calculator();
    assertEquals("3 4 2 * 1 5 - 2 3 ^ ^ / + ", c.infixToPostfix("3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3"));
  }

  @Test
  public void testInfixToPostfix7()
  {
    Calculator c = new Calculator();
    assertEquals("3 -4 2 * 1 5 - 2 3 ^ ^ / + ", c.infixToPostfix("3 + -4 * 2 / ( 1 - 5 ) ^ 2 ^ 3"));
  }

  @Test
  public void testInfixToPostfix8()
  {
    Calculator c = new Calculator();
    assertEquals("3 4 2 * 1 5 - 2 3 ^ ^ * + ", c.infixToPostfix("3 + 4 * 2 * ( 1 - 5 ) ^ 2 ^ 3"));
  }

  @Test
  public void testEvaluatePostfix1()
  {
    Calculator c = new Calculator();
    assertEquals(9, c.evaluatePostfix("2 3 4 * + 5 - "));
  }

  @Test
  public void testEvaluatePostfix2()
  {
    Calculator c = new Calculator();
    assertEquals(3, c.evaluatePostfix("5 3 - 2 2 / + "));
  }

  @Test
  public void testEvaluatePostfix3()
  {
    Calculator c = new Calculator();
    assertEquals(25, c.evaluatePostfix("3 2 3 ^ * 1 + "));
  }

  @Test
  public void testEvaluatePostfix4()
  {
    Calculator c = new Calculator();
    assertEquals(15, c.evaluatePostfix("1 4 + 5 2 - * "));
  }

  @Test
  public void testEvaluatePostfix5()
  {
    Calculator c = new Calculator();
    assertEquals(315, c.evaluatePostfix("7 1 4 2 - + 2 ^ * 5 * "));
  }

  @Test
  public void testEvaluatePostfix6()
  {
    Calculator c = new Calculator();
    assertEquals(3, c.evaluatePostfix("3 4 2 * 1 5 - 2 3 ^ ^ / + "));
  }

  @Test
  public void testEvaluatePostfix7()
  {
    Calculator c = new Calculator();
    assertEquals(-3, c.evaluatePostfix("-3 4 2 * 1 5 - 2 3 ^ ^ / + "));
  }

 @Test
  public void testEvaluatePostfix8()
  {
    Calculator c = new Calculator();
    assertEquals(524291, c.evaluatePostfix("3 4 2 * 1 5 - 2 3 ^ ^ * + "));
  }

@Test
  public void testEvaluatePostfix9()
  {
    Calculator c = new Calculator();
    assertEquals(-524285, c.evaluatePostfix("3 4 -2 * 1 5 - 2 3 ^ ^ * + "));
  }
}
