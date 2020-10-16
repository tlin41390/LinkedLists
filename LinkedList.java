import java.util.*;

public class LinkedList<E> 
{
	// initialize the Node variable.
    private class Node<E>{
        E data;
        Node<E> next;

        public Node (E value)
        {
            data = value;
            next = null;
        }
    }
    
    Node<E> head;
    int size;
    //initialize the linked list variable.
    public LinkedList()
    {
        head = null;
        size = 0;

    }

    public void add(E item)
    {
    	//add element when the list is null.
        if(head==null)
        {
            head = new Node(item);
            ++size;
        }else{
	//add element where there is something on the list
            Node<E> prev = head;
	//iterates through the list to move everytihing back by 1 for room to the new element.
            while( prev.next != null)
            {
                prev = prev.next;
            }
	//adds last element in the list.
            Node<E> node = new Node(item);
            prev.next = node;
            ++size;
        }
    }

    public void add(E item, int position)
    {
    	//checks if there is nothing on the list so it can add an item there.
        if(position ==0)
        {
            Node<E> node = new Node(item);
            node.next = head;
            head = node;
            ++size;
        }else{
	//iterates every element before the position back by 1.
            Node<E> prev = head;
            for (int i=0;i<position-1;i++)
            {
                prev = prev.next;
            }
	//adds the element into the position then icrease size.
            Node<E> node = new Node<E>(item);
            node.next = prev.next;
            prev.next = node;
            ++size;
        }
    }
	//code gets the position of the element
    public E get(int position)
    {
    	//checks to see if the position is valid.
        if(position<0||position>=size)
        {
            return null;
        }
        Node<E> curr = head;
        for (int i =0;i<position;i++)
        {
            curr = curr.next;
        }
        return curr.data;
    }

    public E remove(int position)
    {
    	//checks to see if the position is valid.
	if(position <0|| position>= size)
	{
		return null;
	}
        if(position ==0)
        {
            Node<E> node = head;
            head = head.next;
            --size;
            return node.data;
        }
        else{
	// Move every element to the left
            Node<E> prev = head;
            for(int i=0;i<position-1;i++)
            {
                prev = prev.next;
            }
	    // removes the element then change the pointer to the one over the next one, then decreaese size.
            Node<E> node = prev.next;
            prev.next= node.next;
            --size;
            System.out.println(node.data);
            return node.data;
        }
    }
// revese the list
    public Node<E> reverse(Node<E> head)
    {
    	//initialze three reference nodes. prev curr and next.
        Node<E> prev = null;
        Node<E> curr = head;
        Node<E> next = null;
        while(curr!=null)
        {
	//moves the pointers around in order to get the desired reversed result.
            next = curr.next;
            curr.next = prev;
            prev= curr;
            curr = next;   
        }
        head = prev;
        return head;
    }
	//print ount linked list
    public void printList()
    {
        Node<E> node = head;
        while (node != null)
        {
            System.out.print(node.data+ "->");
            node = node.next;
        }
    }
    
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
	list.add(4);
	//4->
	list.printList();
	System.out.println();
	list.add(5,1);
	//4->5->
	list.printList();
	System.out.println();
	list.add(7);
	//4->5->7
	list.printList();
        list.add(2,3);
	//4->5->7->2
	list.remove(3);
	//4->5->7->
	System.out.println(list.get(1));
	//5
        list.printList();
        list.head = list.reverse(list.head);
	//7->5->4->
        System.out.println();
        list.printList();
    }

}
