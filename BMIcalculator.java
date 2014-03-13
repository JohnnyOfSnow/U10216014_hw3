import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitleBorder;

public class BMIcalculator extends JFrame {
  private JtextField jtfName = new JtextField();
	private JtextField jtfAge = new JtextField();
	private JtextField jtfWeight = new JtextField();
	private JtextField jtfHeight = new JtextField();
	private JtextField jtfBMI = new JtextField();
	private JtextField jtfStatus = new JtextField();
	
	private JButton jbtComputeBMI = new JButton("Compute result");
	
	public BMIcalculator() {
		JPanel p1 = new JPanel(new GridLayout(6,2));
		p1.add(new jLabel("Name"));
		p1.add(jtfName);
		p1.add(new jLabel("Age"));
		p1.add(jtfAge);
		p1.add(new jLabel("Weight"));
		p1.add(jtfWeight);
		p1.add(new jLabel("Height"));
		p1.add(jtfHeight);
		p1.add(new jLabel("BMI"));
		p1.add(jtfBMI);
		p1.add(new jLabel("Status"));
		p1.add(jtfStatus);
	}
}
