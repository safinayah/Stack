/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication6;

import javafxapplication6.Expression;

/**
 *
 * @author ayah
 */
public class Node {

    Expression data;
    Node next;
    Node() {
    }
    
    Node(Expression data) {
        this.data = data;
        
    }


    Node(Expression data, Node next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }

}
