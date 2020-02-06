import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Client {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Push Counter and Style Buttons");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		PushCounterPanel panel = new PushCounterPanel();
		frame.getContentPane().add(panel);
		
		frame.pack();
		frame.setVisible(true);

	}
}

	class PushCounterPanel extends JPanel {
		private int count;
		private JButton push;
		private JLabel label;
		
		public PushCounterPanel() {
			count = 0;
			
			push  = new JButton("Push Me!");
			label = new JLabel();
			push.addActionListener(new ButtonListener());
			add(push);
			add(label);
			
			setBackground(Color.green);
			setPreferredSize(new Dimension(300,40));
		
			
			JFrame frame = new JFrame("Style Options:");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().add(new StyleOptionsPanel());
			frame.pack();
			frame.setVisible(true);

		}
		public class StyleOptionsPanel extends JPanel {
			
		private JLabel saying;
		private JCheckBox bold, italic;
		//-----------------------------------------------------------------
		// Sets up a panel with a label and some check boxes that
		// control the style of the label's font.
		//-----------------------------------------------------------------
		public StyleOptionsPanel()
		{
		saying = new JLabel("Say it with style!");
		saying.setFont(new Font("Helvetica", Font.PLAIN, 36));
		bold = new JCheckBox("Bold");
		bold.setFont(new Font("Bold", Font.BOLD, 20));
		bold.setBackground(Color.cyan);
		italic = new JCheckBox("Italic");
		italic.setFont(new Font("Italic", Font.ITALIC, 20));
		italic.setBackground(Color.cyan);
		StyleListener listener = new StyleListener();
		bold.addItemListener(listener);
		italic.addItemListener(listener);
		add(saying);
		add(bold);
		add(italic);
	
		setBackground(Color.cyan);
		setPreferredSize(new Dimension(300, 100));
		}
		private class StyleListener implements ItemListener
		{
		//--------------------------------------------------------------
		// Updates the style of the label font style.
		//--------------------------------------------------------------
		public void itemStateChanged(ItemEvent event)
		{
		int style = Font.PLAIN;
		if (bold.isSelected())
		style = Font.BOLD;
		if (italic.isSelected())
		style += Font.ITALIC;
		
		saying.setFont(new Font("Calibri", style, 42));
		}
		}
		}
		private class ButtonListener implements ActionListener {
			
			public void actionPerformed(ActionEvent event) {
		
			count++;
			label.setText("pushes: " + count);

			}
		}
			
	}
	
	
	
	 
	
	


