package com.example.Desafio_4;

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
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.example.entities.Hora;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	List<Hora> list = new ArrayList<Hora>();
		
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
							
							Hora hora = new Hora();
							
							String[] vect = line.split(",");
							hora.setHoraInicio(vect[0]);
							hora.setHoraTermino(vect[1]);
							
							list.add(hora);
							
							line = br.readLine();
						}
						
						for(Hora h : list) {
							System.out.println(h.getHoraInicio() + "," +  h.getHoraTermino());
						}
						
					} catch (IOException e) {
						System.out.println("Error: " + e.getMessage());
					}
			    }
			    
			    else if(escolha == 2) {
			    		    	
			    		//Iniciado busca no Banco de dados
						try {
							Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/desafioCNI_4",
									"postgres", "123");
							
							DateFormat horaFormat = new SimpleDateFormat("HH:mm");
							
							if(conexao != null) {
								System.out.println("Conectado!");
								Statement stm = conexao.createStatement();	
								String sql = "SELECT hora_inicio, hora_termino\r\n"
										+ "	FROM public.hora;";
								try {
									ResultSet result = stm.executeQuery(sql);
									while (result.next()) {
										System.out.println(result.getString("hora_inicio") + "," + result.getString("hora_termino"));
										
										Hora hora = new Hora();
										hora.setHoraInicio(result.getString("hora_inicio"));
										hora.setHoraTermino(result.getString("hora_termino"));
										
										list.add(hora);
										
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
					
					pw.println("Núm. Partida" + "|" +  "Início" + "|" + "Término" + "|" + "Tempo Total");
					int numPartida = 1;
					
					for(Hora h : list) {
						
						String[] hors1 = h.getHoraInicio().split(":");
						
						//Passa hora para minutos e realizar o calculo abaixo
						Double horaInicio = 0.0;
						horaInicio = horaInicio + Double.parseDouble(hors1[0])*60;
						horaInicio = horaInicio + Double.parseDouble(hors1[1]);
						
						String[] hors2 = h.getHoraTermino().split(":");
						Double horaTermino = 0.0;
						horaTermino = horaTermino + Double.parseDouble(hors2[0])*60;
						horaTermino = horaTermino + Double.parseDouble(hors2[1]);
						
						Double diff = horaTermino-horaInicio;
						System.out.println(diff);
						int minutos, horas;
						
						minutos = (int) Math.round(diff % 60);
						horas = (int) Math.round((diff - (diff % 60))/ 60);
						
						if(horas>=12 && minutos>0) {
							pw.println((numPartida++) + "           " +  h.getHoraInicio() + "  " + h.getHoraTermino() + "  " + "Jogo considerado empatado");
						}
						else {
							pw.println((numPartida++) + "           " +  h.getHoraInicio() + "  " + h.getHoraTermino() + "  " + horas+":"+minutos);
						}
						
					}
					
				} 
				catch (FileNotFoundException e) {
					System.out.println("Error: " + e.getMessage());
				}
    }
}
