/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ayah
 */
public class Op {

    private String line;

    Op() {
    }

    public ArrayList<String> read() {

        File x = new File("Poly"); //search the file 
        ArrayList<String> result = new ArrayList<>();
        if (x.exists()) {//checks of the file exist

            Scanner input = null;//initilalize input scanner
            try {
                input = new Scanner(x); // Scanning

            } catch (FileNotFoundException ex) {
                System.out.println("noooooo data!!!!!!!!!!!");
            }

            while (input.hasNext()) {//checks if the file has nextLine
                line = input.nextLine(); // This is used to get to the next line and trim thm from the sides
                char[] chars = line.toCharArray();

                System.out.println("infix is : {" + line + "}");
                Stack s = new Stack();
                StringBuilder expr = new StringBuilder();
                /*for(int j = 0; j < chars.length; j++){
                      if(validiation(chars[j], chars[j + 1])== false)
                       System.out.println("invalid equation");}*/
                for (int j = 0; j < chars.length; j++) {//a for loop to fill polynomials in stack

                    Expression temp = new Expression(chars[j]);//temp is 
                    test(temp, s, expr);
               
                      
                   
                }

                while (!s.isEmpty()) {//if not empty pop
                    expr.append(s.pop().toString());
                }
                result.add(expr.toString());
            }
        }
        return result;
    }

    public void test(Expression temp, Stack s, StringBuilder expr) {
        Stack a = new Stack();
        if ("(".equals(temp.toString()) == true) {//always push if left paranthises 
            s.push(new Node(temp));
            a.push(new Node(temp));
            return;
        } else if (")".equals(temp.toString())) {
            expr.append(s.pop().data.toString());
            s.pop();
            return;

        }

        if (temp.priority == 0) {
            expr.append(temp.toString());
            return;
        } else if (s.isEmpty() || "(".equals(s.top().toString()) == true) {
            s.push(new Node(temp));
            return;

        } else if (temp.priority > s.top().data.priority) {
            s.push(new Node(temp));
            return;

        } else if (temp.priority == s.top().data.priority) {
            if (temp.expr != '/' || temp.expr != '-') {
                expr.append(s.pop().data.toString());
            }
            s.push(new Node(temp));
            return;

        } else if (temp.priority < s.top().data.priority) {

            expr.append(s.pop().data.toString());
            test(temp, s, expr);
            return;
        }

    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public boolean validiation() {

        return false;
    }

    private boolean validiation(char charsA, char charsB) {//returns invalid equations
        if (charsA == '+' && charsB == '-') {
            System.out.println("invalid!!!!!");

        } else if (charsA == '+' && charsB == '+') {
            System.out.println("invalid!!!!!");

        } else if (charsA == '+' && charsB == '/') {
            System.out.println("invalid!!!!!");

        } else if (charsA == '+' && charsB == '*') {
            System.out.println("invalid!!!!!");

        } else if (charsA == '-' && charsB == '-') {
            System.out.println("invalid!!!!!");

        } else if (charsA == '-' && charsB == '+') {
            System.out.println("invalid!!!!!");

        } else if (charsA == '-' && charsB == '/') {
            System.out.println("invalid!!!!!");

        } else if (charsA == '-' && charsB == '*') {
            System.out.println("invalid!!!!!");

        } else if (charsA == '*' && charsB == '-') {
            System.out.println("invalid!!!!!");

        } else if (charsA == '*' && charsB == '+') {
            System.out.println("invalid!!!!!");

        } else if (charsA == '*' && charsB == '/') {
            System.out.println("invalid!!!!!");

        } else if (charsA == '*' && charsB == '*') {
            System.out.println("invalid!!!!!");

        } else if (charsA == '/' && charsB == '-') {
            System.out.println("invalid!!!!!");

        } else if (charsA == '/' && charsB == '+') {
            System.out.println("invalid!!!!!");

        } else if (charsA == '/' && charsB == '/') {
            System.out.println("invalid!!!!!");

        } else if (charsA == '/' && charsB == '*') {
            System.out.println("invalid!!!!!");

        }
     
            
        return true;

    }
}

//2*+(7/2+10)-3
