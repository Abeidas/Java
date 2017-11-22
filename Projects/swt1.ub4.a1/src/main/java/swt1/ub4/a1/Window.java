package swt1.ub4.a1;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Window {

	private JFrame frame;
	
	private JButton    dateiLaden;
	private JButton    dateiSpeichern;
	private JButton    vorschau;
	private JLabel     collage;
	private JTextField collageText;
	private ImageIcon  image;
    private JPanel     northPanel;

    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		dateiLaden     = new JButton("Datei Laden");
		dateiSpeichern = new JButton("Datei Speichern");
		vorschau       = new JButton("Vorschau");
		collageText    = new JTextField(".....");
		collage        = new JLabel("Collage");
		image          = new ImageIcon("image.jpg");
		
		northPanel = new JPanel();
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("POP-ART-COLLAGE");
		
		northPanel.setLayout(null);
		frame.add(northPanel);
		image
		
		vorschau.setBounds(600, 60, 180, 35);
		dateiLaden.setBounds(10, 20, 370, 35);
		dateiSpeichern.setBounds(410, 20, 370, 35);
		collageText.setBounds(150, 60, 400, 35);
		collage.setBounds(50, 60, 100, 35);
		
		northPanel.add(vorschau);
		northPanel.add(dateiLaden);
		northPanel.add(dateiSpeichern);
		northPanel.add(collageText);
		northPanel.add(collage);
		
	}
}
