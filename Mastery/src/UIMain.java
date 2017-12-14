import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class UIMain 
{
	static JLabel label = new JLabel( "Press a button" );

	
	public static void main( String[] args )
	{
		JPanel 		 panel1   = new JPanel( new GridBagLayout() );
		//public static JPanel 		 panel2   = new JPanel( new GridBagLayout() );
		final JFrame frame   = new JFrame();
		JTextArea   txtField =  new JTextArea();
		JButton button1 = new JButton( new Button1Action() );
		JProgressBar progBar = new JProgressBar();
		
		label.setOpaque( true );
		label.setHorizontalAlignment(0);
		
		txtField.setEditable(false);
		txtField.setEnabled(true);
		txtField.setText("");
		txtField.setColumns(35);
		txtField.setRows(20);
		txtField.setBounds(20,20,20,20);
		progBar.setIndeterminate(false);
		
		panel1.add(txtField, new GridBagConstraints( 0, 0, 1, 1, 0.0, 0.0,
				   GridBagConstraints.FIRST_LINE_START,
				   GridBagConstraints.BOTH,
				   new Insets( 5,5,5,5 ), 0, 0 ) );
		panel1.add(button1, new GridBagConstraints( 1, 2 , 1, 1, 1.5, 1.5,
				   GridBagConstraints.FIRST_LINE_END,
				   GridBagConstraints.EAST,
				   new Insets( 5,5,5,5 ), 0, 0 ) );
		panel1.add(progBar, new GridBagConstraints( 0, 1, 1, 1, 1.5, 1.5,
				   GridBagConstraints.FIRST_LINE_START,
				   GridBagConstraints.WEST,
				   new Insets( 5,5,5,5 ), 0, 0 ) );
		
		
		frame.add(panel1);
		//frame.add(panel2);
		frame.pack();
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setLocationRelativeTo( null); 
		frame.setResizable(true);
		frame.setSize(500, 500);

		SwingUtilities.invokeLater( new Runnable() 
		{
			@Override
			public void run()
			{
				frame.setVisible(true);
			}
		});
	}
		private static class Button1Action extends AbstractAction
		{
			public Button1Action()
			{
				super();
				putValue(AbstractAction.NAME, "Search");
			}

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				//JOptionPane.showMessageDialog(null, "Please Enter a word to look for");
				String word = JOptionPane.showInputDialog("Please Enter a word to look for");
				System.out.println(word);
				
				ExecutorService es = Executors.newSingleThreadExecutor();
				if (word.isEmpty())
				{
					
				}
				else
				{
					searchCallable("sample.txt", word);
				}
			}
			
		}

	}
	

