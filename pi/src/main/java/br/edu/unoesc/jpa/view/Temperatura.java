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
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Temperatura extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable jtable;


	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Temperatura frame = new Temperatura();
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
	

	public Temperatura() {
		addWindowListener(new WindowAdapter() {
			
			public void windowOpened(WindowEvent e) {
				this.PopularJTable("SELECT * FROM sensor_temperatura");

			}

			public void PopularJTable(String sql) {
				try {
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/pi", "root",
							"root");
					PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
					banco.execute();

					ResultSet resultado = banco.executeQuery(sql);

					DefaultTableModel model = (DefaultTableModel) jtable.getModel();
					model.setNumRows(0);

					while (resultado.next()) {
						model.addRow(new Object[] { resultado.getString("Registro"), resultado.getString("Data_Hora"),
								resultado.getString("temperatura")

						});
					}

				} catch (SQLException e) {
					System.out.println("O erro foi " + e);
				}

			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1110, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		jtable = new JTable();
		jtable.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null }, { null, null, null }, { null, null, null }, },
				new String[] { "Registro", "Data_Hora", "Temperatura" }));
		jtable.getColumnModel().getColumn(1).setMinWidth(30);
		jtable.setBounds(10, 40, 414, 196);
		contentPane.add(jtable);

	}
}
