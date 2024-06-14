package com.example.Desafio_2;

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

import com.example.entities.Vendedores;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
		List<Vendedores> list = new ArrayList<Vendedores>();
				
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
							String nome = vect[0];
							int qtdItens = Integer.parseInt(vect[1]);
							Double totalVendido = Double.parseDouble(vect[2]);
							Double salario = Double.parseDouble(vect[3]);
							
							Vendedores val = new Vendedores(nome, qtdItens, totalVendido, salario);
							list.add(val);
							
							line = br.readLine();
						}
						
						for(Vendedores v : list) {
							System.out.println(v.getNome() + "," +  v.getQtdItens() + "," + v.getTotalVendido() + "," + v.getSalario());
						}
						
					} catch (IOException e) {
						System.out.println("Error: " + e.getMessage());
					}
			    }
			    
			    else if(escolha == 2) {
			    		    	
			    		//Iniciado busca no Banco de dados
						try {
							Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/desafioCNI_2",
									"postgres", "123");
							if(conexao != null) {
								System.out.println("Conectado!");
								Statement stm = conexao.createStatement();	
								String sql = "SELECT name, qtditens, totalvendido, salario\r\n"
										+ "	FROM vendedores;";
								try {
									ResultSet result = stm.executeQuery(sql);
									while (result.next()) {
										System.out.println(result.getString("name") + "," + result.getInt("qtditens")+ "," + result.getInt("totalvendido")+ "," + result.getInt("salario"));
										
										Vendedores val = new Vendedores();
										val.setNome(result.getString("name"));
										val.setQtdItens(result.getInt("qtdItens"));
										val.setTotalVendido(result.getDouble("totalvendido"));
										val.setSalario(result.getDouble("salario"));
										
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
					
					pw.println("Vendedor" + "|" +  "Qtd Itens" + "|" + "Valor Vendido" + "|" + "Valor Comissão" + "|" + "Salário" + "|" + "Salário Final");
					
					for(Vendedores v : list) {
						
						Double comissao = (Double) v.getTotalVendido()*5/100;
						pw.println(v.getNome() + "     " +  v.getQtdItens() + "       " + v.getTotalVendido() + "        " +  comissao  + "         " +  v.getSalario() + "     " +  (v.getSalario()+(comissao)));
					}
				} 
				catch (FileNotFoundException e) {
					System.out.println("Error: " + e.getMessage());
				}
    }
}
