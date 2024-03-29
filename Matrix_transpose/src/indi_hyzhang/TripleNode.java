package indi_hyzhang;

public class TripleNode
{

	public int row;
	public int column;
	public int value;

	public TripleNode(int row, int column, int value)
	{
		this.row = row;
		this.column = column;
		this.value = value;
	}

	public TripleNode()
	{
		this(0, 0, 0);
	}

	public String toString()
	{
		return "(" + row + "," + column + "," + value + ")";
	}
}