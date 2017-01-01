package edu.frostburg.cosc310.Tripp;

/**
 * This class represents a circularly-linked list data structure
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 * @param <T> Generic data type for the Circular Linked List
 */
public class CircuList <T>{
    
    private Node<T> tail;
    private int size;
    
    public CircuList(){}
    
    public int size(){return size;}
    public boolean isEmpty(){return size==0;}
    
    /**
     * Gets the first element of the list
     * @return the first element of the list
     */
    public T first(){
        if(isEmpty()) return null;
        return tail.getNext().getElement();
    }
    
    /**
     * Gets the last element of the list
     * @return the last element of the list
     */
    public T last(){
        if(isEmpty()) return null;
        return tail.getElement();
    }
    
    /**
     * Rotate the elements of the list forward
     */
    public void rotate(){
        if(tail != null)
            tail = tail.getNext();
    }
    
    /**
     * Add the parameter element to the beginning of the list
     * @param e the element to be added
     */
    public void addFirst(T e){
        if(size==0){
            tail = new Node<>(e,null);
            tail.setNext(tail);
        } else {
            Node<T> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }
    
    /**
     * Add the parameter element to the end of the list
     * @param e the element to be added
     */
    public void addLast(T e){
        addFirst(e);
        tail = tail.getNext();
    }
    
    /**
     * Remove the first node of the list
     * @return the element of the removed node
     */
    public T removeFirst(){
        if(isEmpty()) return null;
        Node<T> head = tail.getNext();
        if(head==tail) tail = null;
        else tail.setNext(head.getNext());
        size--;
        return head.getElement();
    }
}
