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
            Node prev = head;
            for(int i =0;i<size;i++)
            {
                prev = prev.next;
            }
            Node node = new Node(item);
            prev.next = node;
            ++size;
        }
    }

    public void add(E item, int position)
    {
        if(position ==0)
        {
            Node node = new Node (item);
            node.next = head;
            head = node;
            ++size;
        }else{
            Node prev = head;
            for (int i=0;i<position-1;i++)
            {
                prev = prev.next;
            }
            Node node = new Node(item);
            node.next = prev.next;
            prev.next = node;
            ++size;
        }
    }

    public Node<E> get(int position)
    {
        Node curr = head;
        for (int i =0;i<position;i++)
        {
            curr = curr.next;
        }
        System.out.println(curr.next);
        return curr.next;
    }

    public Node<E> remove(int position)
    {
        if(position ==0)
        {
            Node node = head;
            head = head.next;
            --size;
            return node.data;
        }
        else{
            Node prev = head;
            for(int i=0;i<position-1;i++)
            {
                prev = prev.next;
            }
            Node node = prev.next;
            prev.next= node.next;
            --size;
            System.out.println(node.data);
            return node.data;
        }
    }

    public Node<E> reverse(E head)
    {
        Node prev = null;
        Node curr = head;
        Node next = null;
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
    

    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        list.add(4);
        list.add(5,1);
        System.out.println(list.toString());
        list.reverse(head);

    }

}