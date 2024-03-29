package modules;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Queue<Item> implements Iterable<Item>
{
	private Node first; // link to least recently added node
	private Node last; // link to most recently added node
	private int N; // number of items on the queue

	private class Node
	{
		// nested class to define nodes
		Item item;
		Node next;
	}

	public boolean isEmpty()
	{
		return N == 0;
	}

	public int size()
	{
		return N;
	}

	public void enqueue(Item item)
	{
		// add item to the end of the list
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty())
			first = last;
		else
			oldlast.next = last;
		N++;
	}

	public Item dequeue()
	{
		Item item = first.item;
		first = first.next;
		if (isEmpty())
			last = null;
		N--;
		return item;
	}

	public Iterator<Item> iterator()
	{
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item>
	{
		private Node current = first;

		public boolean hasNext()
		{
			return current != null;
		}

		public void remove()
		{
		}

		public Item next()
		{
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	public static void main(String[] args)
	{
		Stack<String> s = new Stack<String>();

		while (!StdIn.isEmpty())
		{
			String item = StdIn.readString();
			if (!item.equals("-"))
				s.push(item);
			else if (!s.isEmpty())
				StdOut.print(s.pop() + " ");
		}

		StdOut.println("(" + s.size() + " left on stack.)");
	}
}
