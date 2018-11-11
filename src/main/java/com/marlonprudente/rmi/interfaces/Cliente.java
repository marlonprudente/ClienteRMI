/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marlonprudente.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

/**
 *
 * @author Marlon Prudente <marlon.oliveira at alunos.utfpr.edu.br>
 */
public interface Cliente extends Remote{
    
   
    /**
     * 
     * @param servidor
     * @throws RemoteException 
     */
    public void BuscarPassagens(Servidor servidor) throws RemoteException;
    /**
     * 
     * @param servidor
     * @param para
     * @param de
     * @param dataInicial
     * @param dataPassagem
     * @param quantidadePessoas
     * @throws RemoteException 
     */
    public void BuscarPassagens(Servidor servidor, String para, String de, Date dataInicial, Date dataPassagem, Integer quantidadePessoas) throws RemoteException;
    /**
     * 
     * @param servidor
     * @throws RemoteException 
     */
    public void BuscarHoteis(Servidor servidor) throws RemoteException;
    /**
     * 
     * @param servidor
     * @throws RemoteException 
     */
    public void BuscarPacotes(Servidor servidor) throws RemoteException; //Verificar necessidade
    /**
     * 
     * @param servidor
     * @param id
     * @param quantidadePessoas
     * @throws RemoteException 
     */
    public void ComprarPassagem(Servidor servidor, Integer id, Integer quantidadePessoas) throws RemoteException;
    /**
     * 
     * @param servidor
     * @param id
     * @param quantidadePessoas
     * @param dataCheckIn
     * @param dataCheckOut
     * @throws RemoteException 
     */
    public void ReservarQuartos(Servidor servidor, Integer id, Integer quantidadePessoas, Date dataCheckIn, Date dataCheckOut) throws RemoteException;
    /**
     * 
     * @param servidor
     * @param passagemId
     * @param hotelId
     * @param quantidadePessoas
     * @param dataCheckIn
     * @param DataCheckOut
     * @throws RemoteException 
     */
    public void ComprarPacote(Servidor servidor, Integer passagemId, Integer hotelId, Integer quantidadePessoas, Date dataCheckIn, Date DataCheckOut) throws RemoteException;
    /**
     * 
     * @param servidor
     * @param para
     * @param de
     * @param valorMaximo
     * @param cliente
     * @return
     * @throws RemoteException 
     */
    public boolean RegistrarInteressePassagem(Servidor servidor, String para, String de, Integer valorMaximo, String cliente) throws RemoteException;
    /**
     * 
     * @param servidor
     * @param localizacao
     * @param quantidadePessoas
     * @param valorMaximo
     * @param cliente
     * @return
     * @throws RemoteException 
     */
    public boolean RegistrarInteresseQuarto(Servidor servidor, String localizacao, Integer quantidadePessoas, Integer  valorMaximo, String cliente) throws RemoteException;
    /**
     * 
     * @param servidor
     * @param para
     * @param de
     * @param localizacao
     * @param valorMaximo
     * @param quantidadePessoas
     * @param cliente
     * @return
     * @throws RemoteException 
     */
    public boolean RegistrarInteressePacote(Servidor servidor, String para, String de, String localizacao, Integer valorMaximo, Integer quantidadePessoas, String cliente) throws RemoteException;
    /**
     * 
     * @param servidor
     * @param para
     * @param de
     * @param valorMaximo
     * @param cliente
     * @return
     * @throws RemoteException 
     */
    public boolean RemoverInteressePassagem(Servidor servidor, String para, String de, Integer valorMaximo, String cliente) throws RemoteException;
    /**
     * 
     * @param servidor
     * @param localizacao
     * @param quantidadePessoas
     * @param valorMaximo
     * @param cliente
     * @return
     * @throws RemoteException 
     */
    public boolean RemoverInteresseQuarto(Servidor servidor, String localizacao, Integer quantidadePessoas, Integer valorMaximo, String cliente) throws RemoteException;
    /**
     * 
     * @param servidor
     * @param para
     * @param de
     * @param localizacao
     * @param valorMaximo
     * @param quantidadePessoas
     * @param cliente
     * @return
     * @throws RemoteException 
     */
    public boolean RemoverInteressePacote(Servidor servidor, String para, String de, String localizacao, Integer valorMaximo, Integer quantidadePessoas, String cliente) throws RemoteException;
    /**
     * 
     * @param s 
     * @throws java.rmi.RemoteException 
     */
    public void Notificacao(String s) throws RemoteException;
    
    
}
