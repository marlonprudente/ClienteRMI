/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marlonprudente.rmi.cliente;

import com.marlonprudente.rmi.interfaces.Cliente;
import com.marlonprudente.rmi.interfaces.Servidor;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

/**
 *
 * @author Marlon Prudente <marlon.oliveira at alunos.utfpr.edu.br>
 */
public class ClienteImplements extends UnicastRemoteObject implements Cliente {
    
    protected ClienteImplements() throws RemoteException{
        super();
    }

    @Override
    public void BuscarPassagens(Servidor servidor) throws RemoteException {
        System.out.println("Buscando passagens...");
        for (String s : servidor.ConsultarPassagens()){
            System.out.println(s);
        }
    }

    @Override
    public void BuscarPassagens(Servidor servidor, String para, String de, Date dataInicial, Date dataPassagem, Integer quantidadePessoas) throws RemoteException {
        System.out.println("Buscando passagens...");        
        for (String s : servidor.ConsultarPassagens(para, de, dataInicial, dataPassagem, quantidadePessoas)){
            System.out.println(s);
        }
    }

    @Override
    public void BuscarHoteis(Servidor servidor) throws RemoteException {
        System.out.println("Buscando Hoteis...");
        for (String s : servidor.ConsultarHoteis()){
            System.out.println(s);
        }
    }

    @Override
    public void BuscarPacotes(Servidor servidor) throws RemoteException {
        System.out.println("Buscando pacotes...");
        for (String s : servidor.ConsultarPacotes()){
            System.out.println(s);
        }
        
    }

    @Override
    public void ComprarPassagem(Servidor servidor, Integer id, Integer quantidadePessoas) throws RemoteException {
        boolean comprou = servidor.VenderPassagem(id, quantidadePessoas);
        if(comprou){
            System.out.println("Você comprou " + quantidadePessoas + "acentos na viagem de id " + id);
        }else{
            System.out.println("Falha ao comprar " + quantidadePessoas + "acentos na viagem de id " + id);
        }
    }

    @Override
    public void ReservarQuartos(Servidor servidor, Integer id, Integer quantidadePessoas, Date dataCheckIn, Date dataCheckOut) throws RemoteException {
        boolean reservou = servidor.VenderQuartos(id, quantidadePessoas, dataCheckIn, dataCheckOut);
        
        if(reservou){
            System.out.println("Quarto no hotel id " + id + " reservado para " + quantidadePessoas + " pessoas." );
        }else{
            System.out.println("Falha ao reservar quarto no hotel de id " + id);
        }
    }

    @Override
    public void ComprarPacote(Servidor servidor, Integer passagemId, Integer hotelId, Integer quantidadePessoas, Date dataCheckIn, Date dataCheckOut) throws RemoteException {
        boolean comprou = servidor.VenderPacote(passagemId, hotelId, quantidadePessoas, dataCheckIn, dataCheckOut);
        if(comprou){
            System.out.println("Pacote comprado com sucesso!");
        }else{
            System.out.println("Falha ao comprar pacote.");
        }
    }

    @Override
    public boolean RegistrarInteressePassagem(Servidor servidor, String para, String de, Integer valorMaximo, String cliente) throws RemoteException {
        System.out.println("Registrando interesse em passagem.");
        boolean registrou = servidor.RegistrarInteressePassagem(para, de, valorMaximo, cliente);        
        return registrou;
    }

    @Override
    public boolean RegistrarInteresseQuarto(Servidor servidor, String localizacao, Integer quantidadePessoas, Integer valorMaximo, String cliente) throws RemoteException {
        System.out.println("Registrando interesse em quarto");
        boolean registrou = servidor.RegistrarInteresseQuarto(localizacao, quantidadePessoas, valorMaximo, cliente);
        
        return registrou;
    }

    @Override
    public boolean RegistrarInteressePacote(Servidor servidor, String para, String de, String localizacao, Integer valorMaximo, Integer quantidadePessoas, String cliente) throws RemoteException {
        System.out.println("Registrando interesse em pacote de viagens");
        boolean registrou = servidor.RegistrarInteressePacote(para, de, localizacao, valorMaximo, quantidadePessoas, cliente);
        
        return registrou;
    }

    @Override
    public boolean RemoverInteressePassagem(Servidor servidor, String para, String de, Integer valorMaximo, String cliente) throws RemoteException {
        System.out.println("Removendo interesse em passagem");
        boolean removeu = servidor.RemoverInteressePassagem(para, de, valorMaximo, cliente);        
        return removeu;
    }

    @Override
    public boolean RemoverInteresseQuarto(Servidor servidor, String localizacao, Integer quantidadePessoas, Integer valorMaximo, String cliente) throws RemoteException {
        System.out.println("Removendo interesse em quartos");
        boolean removeu = servidor.RemoverInteresseQuarto(localizacao, quantidadePessoas, valorMaximo, cliente);
        
        return removeu;
    }

    @Override
    public boolean RemoverInteressePacote(Servidor servidor, String para, String de, String localizacao, Integer valorMaximo, Integer quantidadePessoas, String cliente) throws RemoteException {
        System.out.println("Removendo interesse em pacote");
        boolean removeu = servidor.RemoverInteressePacote(para, de, localizacao, valorMaximo, quantidadePessoas);
        
        return removeu;
    }

    @Override
    public void Notificacao(String s) throws RemoteException {
        System.out.println("Um evento aconteceu: " + s);
    }
    
}
