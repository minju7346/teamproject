package myproject;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

abstract class Friend{
	int age;
	String name;
	public Friend() {
		System.out.println("�ȳ��ϼ���!");
	}
	String speak() {return "";}
	String special() {return "";}
}
class MjKim extends Friend{
	Scanner s=new Scanner(System.in);
	public MjKim() {
		name="�����";
		age=20;
	}
	@Override
	public String speak() {
		return "���� "+name+"�̰�" +age+"�� �Դϴ�.  ��̴�"+this.special()+"�Դϴ�.";
		}
	public String special() {
		return "���ø��� �������ϱ�";
	}
}
class JhKim extends Friend{
	Scanner s=new Scanner(System.in);
	public JhKim() {
		name="������";
		age=21;
	}
	@Override
	public String speak() {
		return "����  "+name+"�̰�  " +age+"�� �Դϴ�.  ��̴� "+this.special()+"�Դϴ�.";
	}
	public String special() {
		return "Ĭ���� ���ñ�";
	}
}
public class myproject extends JFrame{
	JLabel la=new JLabel("   ���� ������ ������� �Ұ��մϴ�~ ���⸦ �����ϼ���~");
	JButton mj=new JButton("(�� o�� )");
	JButton jh=new JButton("( �� v�� )");
	
	public myproject() {
		setTitle("���⸦ �Ұ��մϴ� ^v^");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel jp=new JPanel();
		JPanel jp2=new JPanel();
		jp.setBackground(Color.GRAY);
		jp2.setBackground(Color.PINK);
		jp.add(new JLabel("                                                               <�б� ��>                                                                "));
		jp.add(mj);
		jp.add(jh);
		jp.add(new JLabel("         1.������� ���� ������ �� �ڱ�Ұ��� ����ּ���."));
		jp.add(new JLabel("     2.����ָ� ������ �� ���Ҹ��ֿ� ���������ּ��� !"));
		jp.add(new JLabel("        3.�������� ������ �� �Ǿ�� ���Կ� ���������ּ��� !"));
		jp2.add(new JLabel(" [ �Ǿ�� ����  ]      "));
		jp2.add(new JLabel("        <�Ǵ� ���� �Ÿ�>     "));
		jp2.add(new JLabel("          [   ����  ����  ]"));

		Container c=getContentPane();
		c.add(jp,BorderLayout.CENTER);
		c.add(la,BorderLayout.NORTH);
		c.add(jp2,BorderLayout.SOUTH);
			
		mj.addActionListener(new MyAction()); 
		mj.addKeyListener(new MyKey());
		jh.addActionListener(new MyAction());
		jh.addKeyListener(new MyKey());
		
		setSize(500,300);
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
	}
	class MyAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton b=(JButton)e.getSource();
			if(b.getText().equals("(�� o�� )")){
				MjKim m=new MjKim();
				la.setText(m.speak()); 
				mj.setFocusable(true);
				mj.requestFocus();
			}
			else{
				JhKim j=new JhKim();
				la.setText(j.speak());
				jh.setFocusable(true);
				jh.requestFocus();
			}
		}
	}
	class MyKey extends KeyAdapter { 
		public void keyPressed(KeyEvent e) { 
			int keyCode = e.getKeyCode();
			JButton bt=(JButton)e.getSource();
			switch(keyCode) { 
			case KeyEvent.VK_UP: 
				bt.setLocation(bt.getX(), bt.getY() - 10); 
				break; 
			case KeyEvent.VK_DOWN: 
				bt.setLocation(bt.getX(), bt.getY() + 10); 
				if(bt.getText()=="(�� o�� )"&&bt.getY()==178&&bt.getX()==343) {
					bt.setText("^ 3~ ^");
					bt.setBackground(Color.orange);
					la.setText("�����: ��~ �������~!");
				}
				else if(bt.getText()=="( �� v�� )"&&bt.getY()==178&&bt.getX()==63) {
					bt.setText("@(^ v ^)@");
					bt.setBackground(Color.orange);
					la.setText("������:���ο� �Ǿ���� �� ���~!");
				}
				
				break; 
			case KeyEvent.VK_LEFT: 
				bt.setLocation(bt.getX() - 10, bt.getY()); 
				break; 
			case KeyEvent.VK_RIGHT: 
				bt.setLocation(bt.getX() + 10, bt.getY()); 
				break; 
			} 
		 } 
	}
	

	public static void main(String[] args) {
		new myproject();
	}
 }