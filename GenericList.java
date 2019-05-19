//Gurnit Kaur
public class GenericList<X> implements MyStack<X>
{
   // Use an array to create the list
  private X[] arr;
  private int size;

  /*
   * Constructor for objects of class GSL
   */
  public GenericList()
  {
    this.newArray();
  }

  /*
   * size - returns the size of the list
   * 
   * return - the size of the list as an integer
   */
  public int size()
  {
    return size;
  }
  /* new Array*/
  private void newArray()
  {
   arr = (X[])new Object[10];
   size = 0; 
  }
  
  /* expandArray*/
  private void expandArray()
  {
      X[] arr2;
      arr2 = (X[]) new Object[(int)(arr.length * 1.2)];
      // Copy elements from arr to arr2
      for (int i = 0; i < arr.length; i++)
        arr2[i] = arr[i];
      // Have arr point to new array
      arr = arr2;
      // Old array will be Garbage Collected
  }

   /*
   * add - add one value to the list in the next available position
   * 
   * param - integer to add to the list
   */
  public void add(X value)throws ArrayIndexOutOfBoundsException
  {
     
    if (size == arr.length) // Is arr full? Then expand by 20%
    {
      this.expandArray();
    }

    arr[size] = value;
    size++;
  }

  /*
   * get - return the value at the specified location in the list
   * 
   * param - index into the list for the value to return
   * return - integer value
   */
  public X get(int index)throws ArrayIndexOutOfBoundsException
  {
      if(index < 0 || index >= this.size)
         throw new ArrayIndexOutOfBoundsException();            
       return arr[index];          
  }

  /*
   * clear - empty the list
   */
  public void clear()
  {
    this.newArray();
  }

  /*
   * insert - insert new element at indicated index
   * 
   * param - index to insert new element
   * param - integer value of new element
   */
  public void insert(int index, X value) throws ArrayIndexOutOfBoundsException
  {
   if(index < 0 || index >= this.size)
        throw new ArrayIndexOutOfBoundsException();
       // If the index points to an empty element, add it.
     else if ( index >= size )
      add(value);
    else
    {
      if (size == arr.length) // Is arr full? Then expand by 20%
      {
        this.expandArray();
      }
      // Open a hole to insert the value
      for (int i = size; i > index; i--)
        arr[i] = arr[i - 1];
      arr[index] = value;
      size++;
    }
  }


  /*
   * toString - return a string value that represents the list
   *
   * return - String
   */
  public String toString()  {
    String returnValue = String.valueOf(arr[size]);
    
      if (size == 1)
          returnValue =  this.get(0) + ", ";
      else if(size == 2)
          returnValue =  this.get(1) + ", " + this.get(0) + ", ";  
      else if(size == 3)
          returnValue =  this.get(2) + ", " + this.get(1) + ", " + this.get(0) + ", ";  
     else
          returnValue = "";   
           
      return "top, " + returnValue + "bottom";
  }

  /*
   * display - display the list
   */
  public void display()
  {
    for (int i = 0; i < size; i++)
      System.out.println(i + ": " + arr[i]);
    if ( arr.length == size)
      System.out.println("List is full\n");
    else
      System.out.println("List has " + (arr.length - size) + " spaces left\n");
  }
     
   /*
   * set - set an element of your string list at specified index to the provided value.  
   */ 
  public void set(int index, X value) throws ArrayIndexOutOfBoundsException
  {
  // Code to set an element of your string list at specified index
  // to the provided value. You cannot set an item beyond that last
  // item in the list. Set will only work on elements greater than
  // or equal to zero and less than size. Do not add elements to the
  // list with set. Display an error if an index is out of bounds.
     if( index < 0 || index >= this.size)
           throw new ArrayIndexOutOfBoundsException();           
     else
         arr[index] = value;           
   }   
   
   /*
   * remove - remove element at specified index.  
   */
   public void remove(int index) throws ArrayIndexOutOfBoundsException
   {
   // Code to remove the element at the specified index. All elements
  // after the index are shifted down to fill the hole. You cannot
  // remove an item beyond the last item in the list. Remove will only
  // work on elements greater than or equal to zero and less than size.
  // Display an error if an index is out of bounds.
     if(index < 0 || index >= size)      
       throw new ArrayIndexOutOfBoundsException();
     else
     {   
         arr[index] = null;
         for (int i = index; i < size - 1; i++)
         arr[i] = arr[i + 1];      
         size--; 
     }      
          
   }
   public void swap(int index1, int index2) throws ArrayIndexOutOfBoundsException
   {
      if((index1 < 0 || index1 >= size)|| index2 < 0 || index2 >= size)      
          throw new ArrayIndexOutOfBoundsException();
      else
      {
         X arr2 = arr[index1];
         arr[index1] = arr[index2];
         arr[index2] = arr2;
      }      
   }  
    
   /*
   * push - push a value on the stack
   * 
   * param - value to add to the top of stack
   */   
  public void push(X value)  
  {  
    this.add(value);
  }
  
    /*
   * pop - return the value at the top of stack
   * 
   * returns - value at top of stack
   */   
  public X pop()  
  {    
      X top = this.get(this.size - 1);      
      size--;
      return top;       
   }
  
  /*
   * peek - return value at top of stack but do not remove it.
   * 
   */
  public X peek() 
  {
       return this.get(size - 1);
  }

  /*
   * isEmpty - returns true if stack is empty. Otherwise false.
   * 
   */
  public boolean isEmpty()
  {
   return this.size()== 0;
  }

}