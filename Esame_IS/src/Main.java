import ProjectManagement.entity.*;

import java.time.Month;
import java.time.LocalDate;

import ProjectManagament.control.*;

public class Main {

	public static void main(String[] args) {

		System.out.println("ciao");
		Cliente c1 = new Cliente("alberto","pass","81","5333");
		Cliente c2 = new Cliente("ele","es","22","11");
		
		ShopManagement gestione = new ShopManagement ();
		
		c1.aggiungiAlCarrello(gestione.getCatalogo().get(0), 1);
		c1.aggiungiAlCarrello(gestione.getCatalogo().get(1), 1);
		c1.aggiungiAlCarrello(gestione.getCatalogo().get(0), 1); 
		c2.aggiungiAlCarrello(gestione.getCatalogo().get(0), 1);
		
		gestione.effettuaPagamento(c1, 1,LocalDate.of(2020,Month.APRIL,10), StatoSpesa.ORDINATA);
		gestione.effettuaPagamento(c2,2,LocalDate.of(2019,Month.AUGUST,18), StatoSpesa.ORDINATA);
		
		
		
		
		gestione.effettuaPagamento(c1,2,LocalDate.of(2020,Month.JULY,15), StatoSpesa.ORDINATA);
		gestione.generaReport();
		

	}

}
