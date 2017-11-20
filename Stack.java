/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication6;

import javafxapplication6.Node;

/**
 *
 * @author ayah
 */
public class Stack {
    Node top; 
    Stack(){
        
        this.top=null; 
        
    }
    public boolean isEmpty(){//check if empty
        return(top==null);
    
    }
    public void makeEmpty(){//make the stack empty
       top =null; 
        }
    public Node top(){//returns top od the stack
        
        if(isEmpty())
            return null; 
        return top;
    
    }
    public Node pop()  {//removes node from the stack
        Node temp = null;
        if(isEmpty()){//check if the stack is empty
            System.out.print("stack is empty");
          
        }
        else{ //deletes the topwhen stack is not empty 
           temp = top;
           top = top.next;
        }
        return temp;
    
    }
   public Node popAndTop(){ //returns the value after the top
        if(isEmpty())//checks if empty
            return null ; 
        Node topItem=top; 
        top= top.next; 
        
       return top ;
   
   }
   public void push(Node x){//adds node to the top
       
       Node topOfStack= x ;
       x.next = top;
       top = topOfStack;
       
   }

    @Override
    public String toString() {
        return "Stack{" + "top=" + top.toString() + '}';
    }


    
}
