package br.edu.unoesc.jpa.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Luminosidade extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable jtable3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Luminosidade frame = new Luminosidade();
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
	public Luminosidade() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				this.PopularJTableL("SELECT * FROM sensor_luminosidade");
			}
			public void PopularJTableL(String sql) {
				try {
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/pi", "root", "root");
					PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
					banco.execute();

					ResultSet resultado = banco.executeQuery(sql);
					
					DefaultTableModel modelL = (DefaultTableModel) jtable3.getModel();
					modelL.setNumRows(0);
					while(resultado.next()) {
						modelL.addRow(new Object[] {
								resultado.getString("registro"),
								resultado.getString("data_hora"),
								resultado.getString("luminosidade")
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
		
		jtable3 = new JTable();
		jtable3.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Registro", "data_hora", "Luminosidade"
			}
		));
		jtable3.setBounds(35, 33, 363, 187);
		contentPane.add(jtable3);
	}

}
