package ex01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Historico {
	
	private static ArrayList<Historico> historico = new ArrayList<Historico>();
	
	public static ArrayList<Historico> getHistorico() {
		return historico;
	}
	
	public static void addHistorico(Historico h) {
		historico.add(h);
	}
	
	private String nomeCliente;
	private LocalDateTime dataHora;
	private Produto produtoConsumido;
	
	public Historico(String nomeCliente, LocalDateTime dataHora, Produto p) {
		this.setNomeCliente(nomeCliente);
		this.setDataHora(dataHora);
		this.setProdutoConsumido(p);
	}
	
	public Object[] getRow() {
		return new Object[] {
				this.getNomeCliente(),
				this.getProdutoConsumido(),
				this.getProdutoConsumido().getQuantidade(),
				this.getDataHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm"))
		};
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public Produto getProdutoConsumido() {
		return produtoConsumido;
	}

	public void setProdutoConsumido(Produto produtoConsumido) {
		this.produtoConsumido = produtoConsumido;
	}
	
}
