/*
 * Este sotfware foi feito para a UTFPR - Campus Curitiba;
 * O Código é livre para uso não comercial;
 * Desenvolvido através do Netbeans IDE.
 */
package com.marlonprudente.rmi.cliente;

import com.marlonprudente.rmi.interfaces.Cliente;
import com.marlonprudente.rmi.interfaces.Servidor;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Marlon Prudente <marlon.oliveira at alunos.utfpr.edu.br>
 */
public class Main {
    public static void main(String[] args) {
        Cliente cliente = null;
        Registry servicoNomesRMI;
        try{
            cliente = new ClienteImplements();
        }catch(RemoteException e){
            System.out.println("Main cliente: " + e);
        }
        
        try{
            servicoNomesRMI = LocateRegistry.getRegistry(2000);
            Servidor servidor = (Servidor)servicoNomesRMI.lookup("servidor");
            servicoNomesRMI.rebind("cliente", cliente);            

            Integer id, pId, hId, acentos, valorMaximo;
            String de, para, localizacao;
            Date dataCheckIn = null, dataCheckOut = null;
            
            while(true){
                System.out.println("1 - Visualizar todas as passagens");
                System.out.println("2 - Visualizar todos os hoteis");
                System.out.println("3 - Visualizar todos os pacotes");
                System.out.println("4 - Comprar passagem");
                System.out.println("5 - Reservar quarto");
                System.out.println("6 - Comprar pacote");
                System.out.println("7 - Registrar interesse em passagem");
                System.out.println("8 - Remover interesse em passagem");
                System.out.println("9 - Registrar interesse em hotel");
                System.out.println("10 - Remover interesse em hotel");
                System.out.println("11 - Registrar interesse em pacote");
                System.out.println("12 - Remover interesse em pacote");
                
                Scanner scanner = new Scanner(System.in);
                Integer op = scanner.nextInt();
                String input;
                switch(op){
                    case 1:
                        System.out.println("Lista de passagens:");
                        cliente.BuscarPassagens(servidor);
                        break;
                    case 2:
                        System.out.println("Lista de hoteis: ");
                        cliente.BuscarHoteis(servidor);
                        break;
                    case 3:
                        System.out.println("Lista de pacotes: ");
                        cliente.BuscarPacotes(servidor);
                        break;
                    case 4:                        
                        System.out.println("Digite o id da passagem que deseja comprar:");
                        input = scanner.next();
                        id = Integer.valueOf(input);
                        System.out.println("Digite a quantidade de acentos: ");
                        input = scanner.next();
                        acentos = Integer.valueOf(input);
                        System.out.println("Comprando passagem...");
                        cliente.ComprarPassagem(servidor, id, acentos);
                        break;
                    case 5:
                        System.out.println("Digite o id do hotel que deseja reservar quarto:");
                        input = scanner.next();
                        id = Integer.valueOf(input);
                        System.out.println("Digite a quantidade de pessoas: ");
                        input = scanner.next();
                        acentos = Integer.valueOf(input);
                        System.out.println("Digite a data de checkIn (dd/mm/yyyy)");
                        input = scanner.next();
                        try {
                            DateFormat df = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH);
                            dataCheckIn = df.parse(input);
                            } catch (ParseException e) {
                            System.out.println("Erro ao Inserir data de checkIn: " + e);
                            }
                        System.out.println("Digite a data de checkOut (dd/mm/yyyy)");
                        input = scanner.next();
                        try {
                            DateFormat df = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH);
                            dataCheckOut = df.parse(input);
                            } catch (ParseException e) {
                            System.out.println("Erro ao Inserir data de checkout: " + e);
                            }
                        cliente.ReservarQuartos(servidor, id, acentos, dataCheckIn, dataCheckOut);
                        break;
                    case 6:
                        System.out.println("Digite o id da passagem:");
                        input = scanner.next();
                        pId = Integer.valueOf(input);
                        System.out.println("Digite o id do hotel: ");
                        input = scanner.next();
                        hId = Integer.valueOf(input);
                        System.out.println("Digite a quantidade de pessoas: ");
                        input = scanner.next();
                        acentos = Integer.valueOf(input);
                        System.out.println("Digite a data de checkIn (dd/mm/yyyy)");
                        input = scanner.next();
                        try {
                            DateFormat df = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH);
                            dataCheckIn = df.parse(input);
                            } catch (ParseException e) {
                            System.out.println("Erro ao Inserir data de checkIn: " + e);
                            }
                        System.out.println("Digite a data de checkOut (dd/mm/yyyy)");
                        input = scanner.next();
                        try {
                            DateFormat df = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH);
                            dataCheckOut = df.parse(input);
                            } catch (ParseException e) {
                            System.out.println("Erro ao Inserir data de checkout: " + e);
                            }
                        System.out.println("Comprando pacote...");
                        cliente.ComprarPacote(servidor, pId, hId, acentos, dataCheckIn, dataCheckOut);                        
                        break;
                    case 7:
                        System.out.println("Digite o destino (XX): ");
                        input = scanner.next();
                        para = input;
                        System.out.println("Digite a origem (XX): ");
                        input = scanner.next();
                        de = input;
                        System.out.println("Digite o valor maximo que deseja pagar: ");
                        input = scanner.next();
                        valorMaximo = Integer.valueOf(input);
                        System.out.println("Inserindo interesse na passagem...");
                        cliente.RegistrarInteressePassagem(servidor, para, de, valorMaximo, "cliente");
                        break;
                    case 8:
                        System.out.println("Digite o destino (XX): ");
                        input = scanner.next();
                        para = input;
                        System.out.println("Digite a origem (XX): ");
                        input = scanner.next();
                        de = input;
                        System.out.println("Digite o valor maximo que desejava pagar: ");
                        input = scanner.next();
                        valorMaximo = Integer.valueOf(input);
                        System.out.println("Removendo seu interesse na passagem");
                        cliente.RemoverInteressePassagem(servidor, para, de, valorMaximo, "cliente");
                        break;
                    case 9:
                        System.out.println("Digite a localização do Hotel (XX): ");
                        input = scanner.next();
                        para = input;
                        System.out.println("Digite a quantidade de pessoas: ");
                        input = scanner.next();
                        acentos = Integer.valueOf(input);
                        System.out.println("Digite o valor maximo que deseja pagar: ");
                        input = scanner.next();
                        valorMaximo = Integer.valueOf(input);
                        System.out.println("Registrando interesse em Hotel...");
                        cliente.RegistrarInteresseQuarto(servidor, para, acentos, valorMaximo, "cliente");
                        break;
                    case 10:
                        System.out.println("Digite a localização do Hotel (XX): ");
                        input = scanner.next();
                        para = input;
                        System.out.println("Digite a quantidade de pessoas: ");
                        input = scanner.next();
                        acentos = Integer.valueOf(input);
                        System.out.println("Digite o valor maximo que deseja pagar: ");
                        input = scanner.next();
                        valorMaximo = Integer.valueOf(input);
                        System.out.println("Removendo interesse em Hotel...");
                        cliente.RemoverInteresseQuarto(servidor, para, acentos, valorMaximo, "cliente");
                        break;
                    case 11:                         
                        System.out.println("Digite o destino (XX): ");
                        input = scanner.next();
                        para = input;
                        System.out.println("Digite a origem (XX): ");
                        input = scanner.next();
                        de = input;
                        System.out.println("Digite a localizacao do Hotel (XX): ");
                        input = scanner.next();
                        localizacao = input;
                        System.out.println("Digite o valor maximo que deseja pagar: ");
                        input = scanner.next();
                        valorMaximo = Integer.valueOf(input);
                        System.out.println("Digite a quantidade de pessoas: ");
                        input = scanner.next();
                        acentos = Integer.valueOf(input);
                        System.out.println("Registrando interesse em pacote...");
                        cliente.RegistrarInteressePacote(servidor, para, de, localizacao, valorMaximo, acentos, "cliente");
                        //interesse pacote
                        break;
                    case 12:                        
                        System.out.println("Digite o destino (XX): ");
                        input = scanner.next();
                        para = input;
                        System.out.println("Digite a origem (XX): ");
                        input = scanner.next();
                        de = input;
                        System.out.println("Digite a localizacao do Hotel (XX): ");
                        input = scanner.next();
                        localizacao = input;
                        System.out.println("Digite o valor maximo que deseja pagar: ");
                        input = scanner.next();
                        valorMaximo = Integer.valueOf(input);
                        System.out.println("Digite a quantidade de pessoas: ");
                        input = scanner.next();
                        acentos = Integer.valueOf(input);
                        System.out.println("Removendo interesse em pacote: ");
                        cliente.RemoverInteressePacote(servidor, para, de, localizacao, valorMaximo, acentos, "cliente");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            }
            
            
            
        }catch(RemoteException e){
            System.out.println("Main cliente: " + e);
        }catch(NotBoundException e){
            System.out.println("Main cliente: " + e);
        }
    }
    
}
