package indi.zhy;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI
{
	public final static int INFINITY = Integer.MAX_VALUE;
	private JFrame frame;
	public static JTextField tfVexNum;
	public static JTextField tfArcNum;
	public static JTextField tfVexs;
	public static JTextField tfArcs;
	public static JTextField tfType;
	public static JTextField tfLookVex;
	public static JTextField tfValueOfVex;
	public static JTextField tfVadj;
	public static JTextField tfV;
	public static JTextField tfW;
	private MGraph mgr;
	private ShortestPath_FLOYD floyd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("最短路径");
		frame.setBounds(100, 100, 582, 690);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextArea promt = new JTextArea();
		promt.setFont(new Font("Monospaced", Font.PLAIN, 15));
		promt.setLineWrap(true);
		promt.setBounds(167, 240, 383, 176);
		frame.getContentPane().add(promt);

		tfVexNum = new JTextField();
		tfVexNum.setEditable(false);
		tfVexNum.setText("4");
		tfVexNum.setBounds(381, 49, 51, 41);
		frame.getContentPane().add(tfVexNum);
		tfVexNum.setColumns(10);

		JLabel lblNewLabel = new JLabel("顶点数");
		lblNewLabel.setBounds(316, 60, 51, 18);
		frame.getContentPane().add(lblNewLabel);

		JLabel label = new JLabel("边数");
		label.setBounds(446, 60, 38, 18);
		frame.getContentPane().add(label);

		tfArcNum = new JTextField();
		tfArcNum.setEditable(false);
		tfArcNum.setText("7");
		tfArcNum.setColumns(10);
		tfArcNum.setBounds(499, 49, 51, 41);
		frame.getContentPane().add(tfArcNum);

		JLabel label_1 = new JLabel("顶点");
		label_1.setBounds(67, 114, 72, 18);
		frame.getContentPane().add(label_1);

		tfVexs = new JTextField();
		tfVexs.setEditable(false);
		tfVexs.setText("A,B,C,D");
		tfVexs.setColumns(10);
		tfVexs.setBounds(167, 103, 383, 41);
		frame.getContentPane().add(tfVexs);

		JLabel label_2 = new JLabel("边的顶点及权值");
		label_2.setBounds(35, 168, 118, 28);
		frame.getContentPane().add(label_2);

		tfArcs = new JTextField();
		tfArcs.setEditable(false);
		tfArcs.setText("Default");
		tfArcs.setColumns(10);
		tfArcs.setBounds(167, 157, 383, 41);
		frame.getContentPane().add(tfArcs);

		JLabel lblNewLabel_1 = new JLabel("类型");
		lblNewLabel_1.setBounds(167, 60, 72, 18);
		frame.getContentPane().add(lblNewLabel_1);

		tfType = new JTextField();
		tfType.setEditable(false);
		tfType.setText("UDN");
		tfType.setColumns(10);
		tfType.setBounds(213, 49, 77, 41);
		frame.getContentPane().add(tfType);

		JLabel lblNewLabel_2 = new JLabel("提示框");
		lblNewLabel_2.setBounds(67, 251, 72, 18);
		frame.getContentPane().add(lblNewLabel_2);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 220, 564, 7);
		frame.getContentPane().add(separator);

		tfLookVex = new JTextField();
		tfLookVex.setText("B");
		tfLookVex.setBounds(269, 494, 86, 41);
		frame.getContentPane().add(tfLookVex);
		tfLookVex.setColumns(10);

		tfValueOfVex = new JTextField();
		tfValueOfVex.setText("0");
		tfValueOfVex.setColumns(10);
		tfValueOfVex.setBounds(464, 494, 86, 41);
		frame.getContentPane().add(tfValueOfVex);

		tfVadj = new JTextField();
		tfVadj.setText("2");
		tfVadj.setColumns(10);
		tfVadj.setBounds(269, 548, 86, 41);
		frame.getContentPane().add(tfVadj);

		tfV = new JTextField();
		tfV.setText("1");
		tfV.setColumns(10);
		tfV.setBounds(464, 548, 38, 41);
		frame.getContentPane().add(tfV);

		tfW = new JTextField();
		tfW.setText("0");
		tfW.setColumns(10);
		tfW.setBounds(512, 548, 38, 41);
		frame.getContentPane().add(tfW);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 426, 564, 7);
		frame.getContentPane().add(separator_1);

		JLabel label_3 = new JLabel("功能域");
		label_3.setBounds(67, 505, 72, 18);
		frame.getContentPane().add(label_3);

		// buttons
		JButton create = new JButton("Create");
		create.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				// mgr = new MGraph();
				Object vexs[] = { "A", "B", "C", "D" };
				int[][] arcs = { { 0, 15, 3, INFINITY }, { 10, 0, 2, INFINITY }, { INFINITY, INFINITY, 0, 2 },
						{ INFINITY, 8, 4, 0 } };
				mgr = new MGraph(GraphKind.UDG, 4, 7, vexs, arcs);
				promt.setText("Success!");

				// mgr.createGraph();
			}
		});
		create.setBounds(35, 49, 113, 41);
		frame.getContentPane().add(create);

		JButton btVWnext = new JButton("vw邻接");
		btVWnext.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					promt.setText("索引为: " + tfV.getText() + " 相对于索引为" + tfW.getText() + "的顶点的下一个邻接点为: " + String
							.valueOf(mgr.nextAdjVex(Integer.parseInt(tfV.getText()), Integer.parseInt(tfW.getText()))));
				} catch (NumberFormatException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btVWnext.setBounds(366, 548, 93, 41);
		frame.getContentPane().add(btVWnext);

		JButton btVnext = new JButton("v的邻接");
		btVnext.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					promt.setText("索引为: " + tfVadj.getText() + " 的顶点的下一个邻接点为: "
							+ String.valueOf(mgr.firstAdjVex(Integer.parseInt(tfVadj.getText()))));
				} catch (NumberFormatException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btVnext.setBounds(167, 548, 93, 41);
		frame.getContentPane().add(btVnext);

		JButton btValueOfVex = new JButton("索引取值");
		btValueOfVex.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					promt.setText("索引 " + tfValueOfVex.getText() + "的值为: "
							+ String.valueOf(mgr.getVex(Integer.parseInt(tfValueOfVex.getText()))));
				} catch (NumberFormatException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btValueOfVex.setBounds(366, 494, 93, 41);
		frame.getContentPane().add(btValueOfVex);

		JButton btGetArcs = new JButton("边数");
		btGetArcs.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				promt.setText("边数: " + String.valueOf(mgr.getArcNum()));
			}
		});
		btGetArcs.setBounds(366, 440, 184, 41);
		frame.getContentPane().add(btGetArcs);

		JButton btGetVexs = new JButton("顶点数");
		btGetVexs.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				promt.setText(String.valueOf("顶点数: " + mgr.getVexNum()));
			}
		});
		btGetVexs.setBounds(167, 440, 185, 41);
		frame.getContentPane().add(btGetVexs);

		JButton btFindVex = new JButton("查找顶点");
		btFindVex.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				promt.setText(tfLookVex.getText() + " 的位置为: " + mgr.locateVex(tfLookVex.getText()));
			}
		});
		btFindVex.setBounds(167, 494, 93, 41);
		frame.getContentPane().add(btFindVex);

		JButton btPath = new JButton("最短路径");
		btPath.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				floyd = new ShortestPath_FLOYD();
				floyd.FLOYD(mgr);
				promt.setText(Algs.display(floyd.getD()));
				Algs.sb.setLength(0);
			}
		});
		btPath.setBounds(167, 601, 185, 41);
		frame.getContentPane().add(btPath);

		JButton btLocation = new JButton("最佳位置");
		btLocation.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					promt.setText(Algs.findPlace(mgr, floyd.getD()));
					Algs.sb.setLength(0);
				} catch (Exception e2)
				{
					e2.printStackTrace();
				}
			}
		});
		btLocation.setBounds(366, 601, 184, 41);
		frame.getContentPane().add(btLocation);

	}
}
