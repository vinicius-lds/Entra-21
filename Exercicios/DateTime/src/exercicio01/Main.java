package exercicio01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
	
	public static void main(String[] args) {
		
		LocalDateTime data = LocalDateTime.now();
		System.out.println(data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm")));
		
	}
	
}
