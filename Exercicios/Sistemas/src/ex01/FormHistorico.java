package ex01;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FormHistorico {

	public static JFrame formulario;

	public FormHistorico() {

		formulario = new JFrame();
		formulario.setResizable(false);
		formulario.setSize(575, 320);
		formulario.setLocationRelativeTo(null);
		formulario.setTitle("Histórico");
		formulario.setLayout(null);

		DefaultTableModel dtm_model = new DefaultTableModel(
				new String[] { "Nome do Cliente", "Produto", "Quantidade", "Data e Hora" }, 0);
		JTable tab_historico = new JTable(dtm_model) {
			boolean[] canEdit = new boolean[] { false, false, false, false };

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		};
		JScrollPane sp_tabelaHistorico = new JScrollPane(tab_historico);
		sp_tabelaHistorico.setBounds(10, 10, 550, 275);

		for (Historico h : Historico.getHistorico()) {
			dtm_model.addRow(h.getRow());
		}

		tab_historico.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				Historico.getHistorico().remove(tab_historico.getSelectedRow());
				dtm_model.setNumRows(0);
				for (Historico h : Historico.getHistorico()) {
					dtm_model.addRow(h.getRow());
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {

			}
		});

		formulario.add(sp_tabelaHistorico);
		formulario.setVisible(true);

	}

	public static JFrame getFormulario() {
		return formulario;
	}

}
