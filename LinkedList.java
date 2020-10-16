import java.util.*;

public class LinkedList<E> 
{
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
    public LinkedList()
    {
        head = null;
        size = 0;

    }

    public void add(E item)
    {
        if(head==null)
        {
            head = new Node(item);
            ++size;
        }else{
            Node<E> prev = head;
            while( prev.next != null)
            {
                prev = prev.next;
            }
            Node<E> node = new Node(item);
            prev.next = node;
            ++size;
        }
    }

    public void add(E item, int position)
    {
        if(position ==0)
        {
            Node<E> node = new Node(item);
            node.next = head;
            head = node;
            ++size;
        }else{
            Node<E> prev = head;
            for (int i=0;i<position-1;i++)
            {
                prev = prev.next;
            }
            Node<E> node = new Node<E>(item);
            node.next = prev.next;
            prev.next = node;
            ++size;
        }
    }

    public E get(int position)
    {
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
            Node<E> prev = head;
            for(int i=0;i<position-1;i++)
            {
                prev = prev.next;
            }
            Node<E> node = prev.next;
            prev.next= node.next;
            --size;
            System.out.println(node.data);
            return node.data;
        }
    }

    public Node<E> reverse(Node<E> head)
    {
        Node<E> prev = null;
        Node<E> curr = head;
        Node<E> next = null;
        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev= curr;
            curr = next;   
        }
        head = prev;
        return head;
    }

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
		list.printList();
		System.out.println();
		list.add(5,1);
		list.printList();
		System.out.println();
		list.add(7);
		list.printList();
        list.add(2,3);
		list.remove(3);
		System.out.println(list.get(1));
        list.printList();
        list.head = list.reverse(list.head);
        System.out.println();
        list.printList();
    }

}
