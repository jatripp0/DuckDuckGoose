package edu.frostburg.cosc310.Tripp;

/**
 * A class to represent a Node data structure in a linked list
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 */
class Node <T>{
    
    private T element;
    private Node<T> next;
    
    public Node(T element, Node<T> next){
        this.element = element;
        this.next = next;
    }
    
    /**
     * Get the next node
     * @return the next Node
     */
    public Node<T> getNext(){return next;}
    
    /**
     * Get the element of the node
     * @return the element of the Node
     */
    public T getElement(){return element;}
    
    /**
     * set the next Node
     * @param n the next node
     */
    public void setNext(Node<T> n){next = n;}
}
