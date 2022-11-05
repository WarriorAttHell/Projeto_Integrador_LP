package br.edu.unoesc.jpa.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Nivel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable jtable1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nivel frame = new Nivel();
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


	public Nivel() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				this.PopularJTableN("SELECT * FROM  sensor_nivel");
			}
			
			public void PopularJTableN(String sql) {
				try {
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/pi", "root", "root");
					PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
					banco.execute();

					ResultSet resultado = banco.executeQuery(sql);
					
					DefaultTableModel modelN = (DefaultTableModel) jtable1.getModel();
					modelN.setNumRows(0);
					while(resultado.next()) {
						modelN.addRow(new Object[] {
								resultado.getString("registro"),
								resultado.getString("data_hora"),
								resultado.getString("nivel_reservatorio")
						});
					}
					banco.close();
					con.close();
				} catch (SQLException e) {
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
		
		jtable1 = new JTable();
		jtable1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"registro", "data_hora", "nivel"
			}
		));
		jtable1.setBounds(52, 41, 297, 168);
		contentPane.add(jtable1);
	}

}
