/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication6;

/**
 *
 * @author tareq
 */
public class Expression {
    
    int priority;//gives the priority of each operation
    char expr;
    
    public Expression(char expr){
        this.expr=expr;
        if(expr >= '0' && expr <= '9'){
           this.priority = 0;
        }else if(expr == '+'){//priority of sum
            this.priority = 2;
        }
        else if( expr =='-'){//preiority of sub
            this.priority = 2;
        }
        else if(expr == '*'){//preiority of multi
            this.priority = 3;
        }
        else if(expr == '/'){//preiority of div
             this.priority = 3;
          
        }else if(expr == ')' || expr == '('){//preiority of paranthises
             this.priority = 4;
         }
    }
    
    @Override
    public String toString(){//returns exp
        return (this.expr+"");
    }
}
