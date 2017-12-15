import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
	public static JPanel 		 panel1   = new JPanel( new GridBagLayout() );
	static JLabel label = new JLabel( "Press a button" );
	public static JProgressBar progBar = new JProgressBar();
	public static JTextArea   txtField =  new JTextArea();
	public final static JFrame frame   = new JFrame();
	public static JButton button1 = new JButton( new Button1Action() );
	
	
	public static void main( String[] args )
	{
	
		
		
		
		label.setOpaque( true );
		label.setHorizontalAlignment(0);
		
		txtField.setEditable(false);
		txtField.setEnabled(true);
		txtField.append("");
		txtField.setColumns(35);
		txtField.setRows(20);
		txtField.setBounds(20,20,20,20);
		progBar.setIndeterminate(false);
		
		panel1.add(txtField, new GridBagConstraints( 0, 0, 1, 1, 0.0, 0.0,
				   GridBagConstraints.CENTER,
				   GridBagConstraints.CENTER,
				   new Insets( 5,5,5,5 ), 0, 0 ) );
		panel1.add(button1, new GridBagConstraints( 1, 1 , 1, 1, 1.5, 1.5,
				   GridBagConstraints.EAST,
				   GridBagConstraints.EAST,
				   new Insets( 5,5,5,5 ), 2, 2 ) );
		panel1.add(progBar, new GridBagConstraints( 0, 1, 1, 1, 1.5, 1.5,
				   GridBagConstraints.WEST,
				   GridBagConstraints.WEST,
				   new Insets( 5,5,5,5 ), 5, 5 ) );
		
		
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
				//System.out.println(word);
				progBar.setIndeterminate(true);
				ExecutorService es = Executors.newSingleThreadExecutor();
				try
				{
					SwingUtilities.invokeLater( new Runnable() 
					{
						@Override
						public void run()
						{
							progBar.setIndeterminate(true);
						}
					});
					File fil = new File("sample.txt");
					Future<String> task = es.submit(new SearchCallable(fil, word ));
					String term = task.get();
					System.out.println(term);
				
					//UIMain.txtField.append(term);
					SwingUtilities.invokeLater( new Runnable() 
					{
						@Override
						public void run()
						{
							txtField.append("\n" + term);
							progBar.setIndeterminate(false);
						}
					});
				}
				
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
	
				
			}
			
		}
		
}
	

