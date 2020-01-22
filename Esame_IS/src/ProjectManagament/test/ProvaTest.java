package ProjectManagament.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ProjectManagament.control.ShopManagement;
import ProjectManagement.entity.Cliente;
import ProjectManagement.entity.StatoSpesa;

public class ProvaTest {
	
	ShopManagement s;
	Cliente c1,c2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
	}

	@Before
	public void setUp() throws Exception {
		s = new ShopManagement();
		 c1 = new Cliente("Emanuele","pass1","366","5333");
		 c2 = new Cliente("Alberto","pass2","351","1710");
	}

	@After
	public void tearDown() throws Exception {
		s = null;
		c1 = null;
		c2 = null;
	}

	
	/*----------TEST1------*/
	@Test
	public void test1NoClienteSpeseMinoriDinUnProdUnaQuant() {
		
		
		
		c1.aggiungiAlCarrello(s.getCatalogo().get(0), 1);
		s.effettuaPagamento(c1, 1,LocalDate.of(2020,Month.MARCH,7), StatoSpesa.ORDINATA);
		c2.aggiungiAlCarrello(s.getCatalogo().get(0), 1);
		s.effettuaPagamento(c2,2,LocalDate.of(2020,Month.FEBRUARY,5), StatoSpesa.ORDINATA);
		
		int l;
		l = s.generaReport(); //output del programma
		assertEquals(0,l); // output atteso,output programma
  
	}
	
	
	/*----------TEST2-----*/
	@Test
	public void test2UnClienteSpeseUgualiAdNUnProdUnaQuant() {
		
		
		
		c1.aggiungiAlCarrello(s.getCatalogo().get(0), 1);
		s.effettuaPagamento(c1, 1,LocalDate.of(2020,Month.SEPTEMBER,1), StatoSpesa.ORDINATA);
		c1.aggiungiAlCarrello(s.getCatalogo().get(1), 1);
		s.effettuaPagamento(c1,2,LocalDate.of(2020,Month.JULY,15), StatoSpesa.ORDINATA);
		
		int l;
		l = s.generaReport(); //output del programma
		assertEquals(1,l); // output atteso,output programma
  
	}
	
	/*----------TEST3-----*/
	@Test
	public void test3UnClienteSpeseMaggaioriAdNUnProdUnaQuant() {
		
		
		
		c1.aggiungiAlCarrello(s.getCatalogo().get(0), 1);
		s.effettuaPagamento(c1, 1, LocalDate.of(2020,Month.JANUARY,7), StatoSpesa.ORDINATA);
		c1.aggiungiAlCarrello(s.getCatalogo().get(1), 1);
		s.effettuaPagamento(c1,2,LocalDate.of(2020,Month.JUNE,12), StatoSpesa.ORDINATA);
		c1.aggiungiAlCarrello(s.getCatalogo().get(2),1);
		s.effettuaPagamento(c1,2,LocalDate.of(2020,Month.JULY,15), StatoSpesa.ORDINATA);
		
		
		int l;
		l = s.generaReport(); //output del programma
		assertEquals(1,l); // output atteso,output programma
  
	}
	
	
	/*----------TEST4-----*/
	@Test
	public void test4UnClienteSpeseUgualiAdNPiuProdUnaQuant() {
		
		
		
		c1.aggiungiAlCarrello(s.getCatalogo().get(0), 1);
		c1.aggiungiAlCarrello(s.getCatalogo().get(1), 1);
		
		
		s.effettuaPagamento(c1,2,LocalDate.of(2020,Month.MAY,2), StatoSpesa.ORDINATA);
		c1.aggiungiAlCarrello(s.getCatalogo().get(0), 1);
		s.effettuaPagamento(c1,0,LocalDate.of(2020,Month.JULY,15), StatoSpesa.ORDINATA);
		
		
		
		int l;
		l = s.generaReport(); //output del programma
		assertEquals(1,l); // output atteso,output programma
  
	}
	
	/*----------TEST5-----*/
	@Test
	public void test5UnClienteSpeseUgualiAdNPiuProdPiuQuant() {
		
		
		
		c1.aggiungiAlCarrello(s.getCatalogo().get(0), 2);
		c1.aggiungiAlCarrello(s.getCatalogo().get(1), 2);
		
		
		s.effettuaPagamento(c1,2,LocalDate.of(2020,Month.MAY,1), StatoSpesa.ORDINATA);
		c1.aggiungiAlCarrello(s.getCatalogo().get(1), 2);
		s.effettuaPagamento(c1,0,LocalDate.of(2020,Month.MAY,15), StatoSpesa.ORDINATA);
		
		
		
		int l;
		l = s.generaReport(); //output del programma
		assertEquals(1,l); // output atteso,output programma
  
	}
	
	/*----------TEST6-----*/
	@Test
	public void test6UnClienteSpeseUgualiAdNunProdPiuQuant() {
		
		
		
		c1.aggiungiAlCarrello(s.getCatalogo().get(0), 2);
		s.effettuaPagamento(c1,2,LocalDate.of(2020,Month.JULY,8), StatoSpesa.ORDINATA);
		c1.aggiungiAlCarrello(s.getCatalogo().get(1), 1);
		s.effettuaPagamento(c1,2,LocalDate.of(2020,Month.AUGUST,23), StatoSpesa.ORDINATA);
		
		int l;
		l = s.generaReport(); //output del programma
		assertEquals(1,l); // output atteso,output programma
  
	}
	
	/*----------TEST7-----*/
	@Test
	public void test7PiuClienteSpeseUgualiAdNunProdUnaQuant() {
		
		
		
		c1.aggiungiAlCarrello(s.getCatalogo().get(0), 1);
		s.effettuaPagamento(c1,2,LocalDate.of(2020,Month.JANUARY,15), StatoSpesa.ORDINATA);
		c2.aggiungiAlCarrello(s.getCatalogo().get(1), 1);
		s.effettuaPagamento(c2,2,LocalDate.of(2020,Month.JANUARY,12), StatoSpesa.ORDINATA);
		c1.aggiungiAlCarrello(s.getCatalogo().get(2), 1);
		s.effettuaPagamento(c1,2,LocalDate.of(2020,Month.OCTOBER,21), StatoSpesa.ORDINATA);
		c2.aggiungiAlCarrello(s.getCatalogo().get(3), 1);
		s.effettuaPagamento(c2,2,LocalDate.of(2020,Month.MARCH,1), StatoSpesa.ORDINATA);
		
		int l;
		l = s.generaReport(); //output del programma
		assertEquals(2,l); // output atteso,output programma
  
	}
	
	/*----------TEST8-----*/
	@Test
	public void test8PiuClienteSpeseUgualiAdNPiuProdUnaQuant() {
		
		
		
		c1.aggiungiAlCarrello(s.getCatalogo().get(0), 1);
		c1.aggiungiAlCarrello(s.getCatalogo().get(1), 1);
		s.effettuaPagamento(c1,2,LocalDate.of(2020,Month.SEPTEMBER,15), StatoSpesa.ORDINATA);
		
		c1.aggiungiAlCarrello(s.getCatalogo().get(2), 1);
		c1.aggiungiAlCarrello(s.getCatalogo().get(3), 1);
		s.effettuaPagamento(c1,2,LocalDate.of(2020,Month.MARCH,2), StatoSpesa.ORDINATA);
		
		
		c2.aggiungiAlCarrello(s.getCatalogo().get(0), 1);
		c2.aggiungiAlCarrello(s.getCatalogo().get(1), 1);
		s.effettuaPagamento(c2,2,LocalDate.of(2020,Month.JUNE,9), StatoSpesa.ORDINATA);
		
		c2.aggiungiAlCarrello(s.getCatalogo().get(2), 1);
		c2.aggiungiAlCarrello(s.getCatalogo().get(3), 1);
		s.effettuaPagamento(c2,2,LocalDate.of(2020,Month.MARCH,11), StatoSpesa.ORDINATA);
		
		
		int l;
		l = s.generaReport(); //output del programma
		assertEquals(2,l); // output atteso,output programma
  
	}
	
	/*----------TEST9-----*/
	@Test
	public void test9PiuClienteSpeseUgualiAdNUnProdPiuQuant() {
		
		
		
		c1.aggiungiAlCarrello(s.getCatalogo().get(0), 2);
		s.effettuaPagamento(c1,2,LocalDate.of(2020,Month.JULY,2), StatoSpesa.ORDINATA);
		
		c1.aggiungiAlCarrello(s.getCatalogo().get(2), 2);
		s.effettuaPagamento(c1,2,LocalDate.of(2020,Month.NOVEMBER,30), StatoSpesa.ORDINATA);
		
		c2.aggiungiAlCarrello(s.getCatalogo().get(0), 2);
        s.effettuaPagamento(c2,2,LocalDate.of(2020,Month.MARCH,5), StatoSpesa.ORDINATA);
		
		c2.aggiungiAlCarrello(s.getCatalogo().get(2), 2);
		s.effettuaPagamento(c2,2,LocalDate.of(2020,Month.JANUARY,15), StatoSpesa.ORDINATA);
		
		int l;
		l = s.generaReport(); //output del programma
		assertEquals(2,l); // output atteso,output programma
  
	}
	

	/*----------TEST10-----*/
	@Test
	public void test10PiuClienteSpeseUgualiAdNPiuProdPiuQuant() {
		
		
		
		c1.aggiungiAlCarrello(s.getCatalogo().get(0), 2);
		c1.aggiungiAlCarrello(s.getCatalogo().get(1), 2);
		s.effettuaPagamento(c1,2,LocalDate.of(2020,Month.AUGUST,5), StatoSpesa.ORDINATA);
		
		c1.aggiungiAlCarrello(s.getCatalogo().get(2), 2);
		c1.aggiungiAlCarrello(s.getCatalogo().get(3), 2);
		s.effettuaPagamento(c1,2,LocalDate.of(2020,Month.DECEMBER,12), StatoSpesa.ORDINATA);
		
		
		c2.aggiungiAlCarrello(s.getCatalogo().get(0), 2);
		c2.aggiungiAlCarrello(s.getCatalogo().get(1), 2);
		s.effettuaPagamento(c2,2,LocalDate.of(2020,Month.SEPTEMBER,28), StatoSpesa.ORDINATA);
		
		c2.aggiungiAlCarrello(s.getCatalogo().get(2), 2);
		c2.aggiungiAlCarrello(s.getCatalogo().get(3), 2);
		s.effettuaPagamento(c2,2,LocalDate.of(2020,Month.NOVEMBER,25), StatoSpesa.ORDINATA);
		
		
		int l;
		l = s.generaReport(); //output del programma
		assertEquals(2,l); // output atteso,output programma
	}
	
	/*----------TEST11-----*/
	@Test
	public void test11UnClienteSpeseUgualiAdNZeroProdUnaQuant() {
		
		
	
		s.effettuaPagamento(c1,2,LocalDate.of(2020,Month.MARCH,15), StatoSpesa.ORDINATA);
		s.effettuaPagamento(c1,8,LocalDate.of(2020,Month.MAY,18), StatoSpesa.ORDINATA);
		
		
		int l;
		l = s.generaReport(); //output del programma
		assertEquals(1,l); // output atteso,output programma
	}
	
	
	/*----------TEST12-----*/
	@Test
	public void test12UnClienteSpeseUgualiAdNUnProdZeroQuant() {
		
		
		c1.aggiungiAlCarrello(s.getCatalogo().get(2), 0);
		s.effettuaPagamento(c1,2,LocalDate.of(2020,Month.JULY,15), StatoSpesa.ORDINATA);
		
		c1.aggiungiAlCarrello(s.getCatalogo().get(2), 0);
		s.effettuaPagamento(c1,2,LocalDate.of(2020,Month.APRIL,15), StatoSpesa.ORDINATA);
		

		
		
		int l;
		l = s.generaReport(); //output del programma
		assertEquals(1,l); // output atteso,output programma
	}
	
}
