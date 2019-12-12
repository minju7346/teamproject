package myproject;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

abstract class Friend{
	int age;
	String name;
	public Friend() {
		System.out.println("안녕하세요!");
	}
	String speak() {return "";}
	String special() {return "";}
}
class MjKim extends Friend{
	Scanner s=new Scanner(System.in);
	public MjKim() {
		name="김민주";
		age=20;
	}
	@Override
	public String speak() {
		return "저는 "+name+"이고" +age+"살 입니다.  취미는"+this.special()+"입니다.";
		}
	public String special() {
		return "넷플릭스 정주행하기";
	}
}
class JhKim extends Friend{
	Scanner s=new Scanner(System.in);
	public JhKim() {
		name="김정현";
		age=21;
	}
	@Override
	public String speak() {
		return "저는  "+name+"이고  " +age+"살 입니다.  취미는 "+this.special()+"입니다.";
	}
	public String special() {
		return "칵테일 마시기";
	}
}
public class myproject extends JFrame{
	JLabel la=new JLabel("   저의 소중한 동기들을 소개합니다~ 동기를 선택하세요~");
	JButton mj=new JButton("(ㅠ oㅠ )");
	JButton jh=new JButton("( ㅠ vㅠ )");
	
	public myproject() {
		setTitle("동기를 소개합니다 ^v^");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel jp=new JPanel();
		JPanel jp2=new JPanel();
		jp.setBackground(Color.GRAY);
		jp2.setBackground(Color.PINK);
		jp.add(new JLabel("                                                               <학교 안>                                                                "));
		jp.add(mj);
		jp.add(jh);
		jp.add(new JLabel("         1.동기들의 얼굴을 선택한 후 자기소개를 들어주세요."));
		jp.add(new JLabel("     2.김민주를 선택한 후 역할맥주에 착지시켜주세요 !"));
		jp.add(new JLabel("        3.김정현를 선택한 후 피어싱 가게에 착지시켜주세요 !"));
		jp2.add(new JLabel(" [ 피어싱 가게  ]      "));
		jp2.add(new JLabel("        <건대 맛의 거리>     "));
		jp2.add(new JLabel("          [   역할  맥주  ]"));

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
			if(b.getText().equals("(ㅠ oㅠ )")){
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
				if(bt.getText()=="(ㅠ oㅠ )"&&bt.getY()==178&&bt.getX()==343) {
					bt.setText("^ 3~ ^");
					bt.setBackground(Color.orange);
					la.setText("김민주: 아~ 기분좋다~!");
				}
				else if(bt.getText()=="( ㅠ vㅠ )"&&bt.getY()==178&&bt.getX()==63) {
					bt.setText("@(^ v ^)@");
					bt.setBackground(Color.orange);
					la.setText("김정현:새로운 피어싱을 또 샀다~!");
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