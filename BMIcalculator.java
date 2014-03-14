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
		p1.setBorder(new TitleBorder("Enter the name, age, weight, and height."));

		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p2.add(jbtComputeBMI);

		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);

		jbtComputeBMI.addActionListener(new ButtonListener());
	}
		private class ButtonListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = String.parseString(jtfName.getText());
				int age = Integer.parseInt(jtfAge.getText());
				double weight = Double.parseDouble(jtfWeight.getText());
				double height = Double.parseDouble(jtfHeight.getText());

				BMI myBMI = new BMI(name, age, weight, height);

				jtfBMI.setText(String.format("%.2f",myBMI.getBMI()));
				jtfStatus.setText(String.format("%3s",myBMI.getStatus()));
			}
		}
		
		public static void main(String[] args) {
			BMIcalculator frame = new BMIcalculator();
			frame.pack();
			frame.setTitle("BMI Calculator");
			frame.setLocationRelative(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
}

class BMI {
  private String name;
  private int age;
  private double weight; // in pounds
  private double height; // in inches
  public static final double KILOGRAMS_PER_POUND = 0.45359237; 
  public static final double METERS_PER_INCH = 0.0254;  
  
  public BMI(String name, int age, double weight, double height) {
    this.name = name;
    this.age = age;
    this.weight = weight;
    this.height = height;
  }
  
  public BMI(String name, double weight, double height) {
    this(name, 20, weight, height);
  }
  
  public double getBMI() {
    double bmi = weight * KILOGRAMS_PER_POUND / 
      ((height * METERS_PER_INCH) * (height * METERS_PER_INCH));
    return Math.round(bmi * 100) / 100.0;
  }
  
  public String getStatus() {
    double bmi = getBMI();
    if (bmi < 18.5)
      return "Underweight";
    else if (bmi < 25)
      return "Normal";
    else if (bmi < 30)
      return "Overweight";
    else
      return "Obese";
  }
  
  public String getName() {
    return name;
  }
  
  public int getAge() {
    return age;
  }
  
  public double getWeight() {
    return weight;
  }
  
  public double getHeight() {
    return height;
  }
}
