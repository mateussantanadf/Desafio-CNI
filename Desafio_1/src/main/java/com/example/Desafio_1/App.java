package com.example.Desafio_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.entities.Valores;

public class App {

	public static void main(String[] args) {
		
		List<Valores> list = new ArrayList<Valores>();
		
		System.out.println("Selecione a fonte dos Dados:");
		System.out.println("1 Arquivo .txt");
		System.out.println("2 Banco de Dados");
		
		Scanner s = new Scanner(System.in);
	    int escolha = Integer.parseInt(s.next());
		
	    if(escolha == 1) {
			//Iniciando leitura do arquivo
	    	
	    	//Caminho do arquivo
			String path = ".\\Dados\\in.txt";
	    	
			try (BufferedReader br = new BufferedReader(new FileReader(path))) {
				
				String line = br.readLine();
				while (line != null) {
					
					String[] vect = line.split(",");
					Double valorA = Double.parseDouble(vect[0]);
					Double valorB = Double.parseDouble(vect[1]);
					
					Valores val = new Valores(valorA, valorB);
					list.add(val);
					
					line = br.readLine();
				}
				
				for(Valores v : list) {
					System.out.println(v.getValorA() + "," +  v.getValorB());
				}
				
			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}
	    }
	    
	    else if(escolha == 2) {
		
	    		//Iniciado busca no Banco de dados
				try {
					Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/desafioCNI_1",
							"postgres", "123");
					if(conexao != null) {
						System.out.println("Conectado!");
						Statement stm = conexao.createStatement();	
						String sql = "select value_a, value_b from valores";
						try {
							ResultSet result = stm.executeQuery(sql);
							while (result.next()) {
								System.out.println(result.getInt("value_a") + "," + result.getInt("value_b"));
								
								Double valorA = (double) result.getInt("value_a");
								Double valorB = (double) result.getInt("value_b");
								
								Valores val = new Valores(valorA, valorB);
								list.add(val);
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
					} else {
						System.out.println("Conexão falhou!");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
	    }		
		
		//Iniciando geração de arquivo		
		String pathOut = ".\\Dados\\out.txt";
		
		try (PrintWriter pw = new PrintWriter(new File(pathOut))) {
			
			pw.println("Valor Origem de A" + "|" +  "Valor Origem de B" + "|" + "Valor Final de A" + "|" + "Valor Final de B");
			
			for(Valores v : list) {
				
				pw.println(v.getValorA() + "              " +  v.getValorB() + "              " + v.getValorB() + "              " +  v.getValorA());
			}
		} 
		catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
}
