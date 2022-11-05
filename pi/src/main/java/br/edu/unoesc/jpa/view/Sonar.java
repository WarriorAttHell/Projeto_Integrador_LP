package br.edu.unoesc.jpa.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Sonar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable jtable2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sonar frame = new Sonar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	
	public Sonar() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				this.PopularJTableS("SELECT * FROM sensor_sonar");
			}
			public void PopularJTableS(String sql) {
				try {
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/pi", "root", "root");
					PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
					banco.execute();

					ResultSet resultado = banco.executeQuery(sql);
					
					DefaultTableModel modelS = (DefaultTableModel) jtable2.getModel();
					modelS.setNumRows(0);
					while(resultado.next()) {
						modelS.addRow(new Object[] {
								resultado.getString("registro"),
								resultado.getString("data_hora"),
								resultado.getString("quantidade_racao")
						});
					}
					banco.close();
					con.close();
				}catch (Exception e) {
					System.out.println("O erro foi " + e);
				}
			}
		});
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jtable2 = new JTable();
		jtable2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Registro", "data_hora", "sonar"
			}
		));
		jtable2.setBounds(28, 24, 371, 190);
		contentPane.add(jtable2);
	}

}
