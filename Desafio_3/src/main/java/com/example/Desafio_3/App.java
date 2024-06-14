package com.example.Desafio_3;

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

import com.example.entities.Cliente;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	List<Cliente> list = new ArrayList<Cliente>();
		
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
							
							Cliente cli = new Cliente();
							
							String[] vect = line.split(",");
							cli.setNome(vect[0]);
							cli.setQtdComprada(Double.parseDouble(vect[1]));
							
							list.add(cli);
							
							line = br.readLine();
						}
						
						for(Cliente c : list) {
							System.out.println(c.getNome() + "," +  c.getQtdComprada());
						}
						
					} catch (IOException e) {
						System.out.println("Error: " + e.getMessage());
					}
			    }
			    
			    else if(escolha == 2) {
			    		    	
			    		//Iniciado busca no Banco de dados
						try {
							Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/desafioCNI_3",
									"postgres", "123");
							if(conexao != null) {
								System.out.println("Conectado!");
								Statement stm = conexao.createStatement();	
								String sql = "SELECT name, qtdcomprada\r\n"
										+ "	FROM cliente;";
								try {
									ResultSet result = stm.executeQuery(sql);
									while (result.next()) {
										System.out.println(result.getString("name") + "," + result.getDouble("qtdcomprada"));
										
										Cliente cli = new Cliente();
										cli.setNome(result.getString("name"));
										cli.setQtdComprada(result.getDouble("qtdcomprada"));
										
										list.add(cli);
										
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
					
					pw.println("Nome do Cliente" + "|" +  "Qtd Comprada" + "|" + "Valor Aplicado" + "|" + "Valor Vanda");
					
					Double valorAplicado, valorVenda, valorTotal = 0.0;
					Double totalVendidas = 0.0;
					
					for(Cliente c : list) {
						
						if(c.getQtdComprada()<12) {
							valorAplicado = 10.83;
							valorVenda = valorAplicado*c.getQtdComprada();
						}
						else {
							valorAplicado = 10.00;
							valorVenda = valorAplicado*c.getQtdComprada();
						}
						pw.println(c.getNome() + "           " +  c.getQtdComprada() + "            " + valorAplicado + "             " + valorVenda);
						totalVendidas = totalVendidas + c.getQtdComprada();
						valorTotal = valorTotal + valorVenda;
					}
					
					pw.println("Total de Camisas Vendidas: " + totalVendidas);
					pw.println("Valor Total da Venda: R$ " + valorTotal);
				} 
				catch (FileNotFoundException e) {
					System.out.println("Error: " + e.getMessage());
				}
    }
}
