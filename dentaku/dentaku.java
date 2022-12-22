import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;


class dentaku3 extends JFrame {

JTextField result = new JTextField("",20);
double stackedValue = 0.0;
boolean isStacked = false;
boolean afterCalc = false;
String currentOp = "";


public static void main(String args[]){
dentaku3 frame = new dentaku3("電卓");
frame.setVisible(true);
}

dentaku3(String title){
setTitle(title);
setBounds(100, 100, 260, 240);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JButton help = new JButton("ヘルプ");
      getContentPane().add(help);

JPanel p = new JPanel();
p.add(help);
JPanel key = new JPanel();
key.setLayout(new GridLayout(5,1));

JPanel keisan = new JPanel();


p.add(result);

key.add(new NumberButton("7"),0);
key.add(new NumberButton("8"),1);
key.add(new NumberButton("9"),2);
key.add(new NumberButton("4"),3);
key.add(new NumberButton("5"),4);
key.add(new NumberButton("6"),5);
key.add(new NumberButton("1"),6);
key.add(new NumberButton("2"),7);
key.add(new NumberButton("3"),8);
key.add(new NumberButton("0"),9);
key.add(new NumberButton("."),10);
key.add(new CalcButton("+"),11);
key.add(new CalcButton("-"),12);
key.add(new CalcButton("*"),13);
key.add(new CalcButton("/"),14);



keisan.add(new ClearButton());
keisan.add(new CalcButton("計算"));


Container contentPane = getContentPane();

contentPane.add(p, BorderLayout.NORTH);
contentPane.add(key, BorderLayout.CENTER);
contentPane.add(keisan, BorderLayout.SOUTH);
}



public class NumberButton extends JButton implements ActionListener {

public NumberButton(String keyTop){
super(keyTop);
this.addActionListener(this);
}
public void actionPerformed(ActionEvent evt) {
String keyNumber = this.getText();
appendResult(keyNumber);
}
}


public void appendResult(String c) {
if( ! afterCalc )
result.setText(result.getText() + c);
else {
result.setText(c);
afterCalc =false;
}
}

public class ClearButton extends JButton implements ActionListener {

public ClearButton() {
super("リセット");
this.addActionListener(this);
}

public void actionPerformed(ActionEvent evt) {
result.setText("");
stackedValue = 0.0;
isStacked = false;
boolean afterCalc = false;
currentOp = "";
}
}


public class CalcButton extends JButton implements ActionListener{

public CalcButton(String op){
super(op);
this.addActionListener(this);
}

public void actionPerformed(ActionEvent e){
if(isStacked){
double resultValue = (Double.valueOf(result.getText())).doubleValue();
if ( currentOp.equals("+"))
stackedValue += resultValue;
else if( currentOp.equals("-"))
stackedValue -= resultValue;
else if( currentOp.equals("*"))
stackedValue *= resultValue;
else if( currentOp.equals("/"))
stackedValue /= resultValue;
result.setText(String.valueOf(stackedValue));
}

currentOp = this.getText();
stackedValue = (Double.valueOf(result.getText())).doubleValue();

afterCalc =true;

if( currentOp.equals("計算")){
isStacked = false;}
else
isStacked = true;
}
}
}
