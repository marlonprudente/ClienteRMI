/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marlonprudente.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Marlon Prudente <marlon.oliveira at alunos.utfpr.edu.br>
 */
public interface Servidor extends Remote{
    /**
     * 
     * @return
     * @throws RemoteException 
     */
    public List<String> ConsultarPassagens() throws RemoteException;
    /**
     * 
     * @param para
     * @param de
     * @param dataInicial
     * @param dataRetorno
     * @param acentos
     * @return
     * @throws RemoteException 
     */
    public List<String> ConsultarPassagens(String para, String de, Date dataInicial, Date dataRetorno, Integer acentos) throws RemoteException;
    /**
     * 
     * @param para
     * @param de
     * @param dataInicial
     * @param acentos
     * @return
     * @throws RemoteException 
     */
    public List<String> ConsultarPassagens(String para, String de, Date dataInicial, Integer acentos) throws RemoteException;    
    /**
     * 
     * @return
     * @throws RemoteException 
     */
    public List<String> ConsultarHoteis()  throws RemoteException;  
    /**
     * 
     * @return
     * @throws RemoteException 
     */
    public List<String> ConsultarPacotes()  throws RemoteException;   
    /**
     * 
     * @param id
     * @param nome
     * @param localizacao
     * @param quartos
     * @param pessoasPorQuarto
     * @param preco
     * @throws RemoteException 
     */
    public void AdicionarHotel(Integer id, String nome, String localizacao, Integer quartos, Integer pessoasPorQuarto, Integer preco) throws RemoteException;    
    /**
     * 
     * @param id
     * @param acentosDisponiveis
     * @param para
     * @param de
     * @param dataVoo
     * @param preco
     * @throws RemoteException 
     */
    public void AdicionarPassagem(Integer id, Integer acentosDisponiveis, String para, String de, Date dataVoo, Integer preco) throws RemoteException;
    /**
     * 
     * @param id
     * @param passagemId
     * @param quantidadePessoas
     * @param para
     * @param de
     * @param preco
     * @param dataVoo
     * @param hotelId
     * @param hotelNome
     * @param HotelLocalizacao
     * @param pessoasPorQuarto
     * @throws RemoteException 
     */
    public void AdicionarPacote(Integer id, Integer passagemId, Integer quantidadePessoas, String para, String de, Integer preco, Date dataVoo, Integer hotelId, String hotelNome, String HotelLocalizacao, Integer pessoasPorQuarto) throws RemoteException;
    /**
     * 
     * @param id
     * @param passagemId
     * @param hotelId
     * @param quantidadePessoas
     * @param preco
     * @throws RemoteException 
     */
    public void AdicionarPacote(Integer id, Integer passagemId, Integer hotelId, Integer quantidadePessoas, Integer preco) throws RemoteException;
    /**
     * 
     * @param id
     * @param acentos
     * @return true se obteve sucesso, false caso contrário
     * @throws RemoteException 
     */
    public boolean VenderPassagem(Integer id, Integer acentos) throws RemoteException;
    /**
     * 
     * @param id
     * @param quantidadePessoas
     * @param dataCheckIn
     * @param dataCheckOut
     * @return true se obteve sucesso, false caso contrário
     * @throws RemoteException 
     */
    public boolean VenderQuartos(Integer id, Integer quantidadePessoas, Date dataCheckIn, Date dataCheckOut) throws RemoteException;
    /**
     * 
     * @param passagemId
     * @param hotelId
     * @param quantidadePessoas
     * @param dataInicial
     * @param DataFinal
     * @return true se obteve sucesso, false caso contrário
     * @throws RemoteException 
     */
    public boolean VenderPacote(Integer passagemId, Integer hotelId, Integer quantidadePessoas, Date dataInicial, Date DataFinal) throws RemoteException;
    /**
     * 
     * @param para
     * @param de
     * @param valorMaximo
     * @param cliente
     * @return true se obteve sucesso, false caso contrário
     * @throws RemoteException 
     */
    public boolean RegistrarInteressePassagem(String para, String de, Integer valorMaximo, String cliente) throws RemoteException;
    /**
     * 
     * @param para
     * @param de
     * @param valorMaximo
     * @param cliente
     * @return true se obteve sucesso, false caso contrário
     * @throws RemoteException 
     */
    public boolean RemoverInteressePassagem(String para, String de, Integer valorMaximo, String cliente) throws RemoteException;
    /**
     * 
     * @param localizacao
     * @param quantidadePessoas
     * @param valorMaximo
     * @param cliente
     * @return true se obteve sucesso, false caso contrário
     * @throws RemoteException 
     */
    public boolean RegistrarInteresseQuarto(String localizacao, Integer quantidadePessoas, Integer valorMaximo, String cliente) throws RemoteException;
    /**
     * 
     * @param localizacao
     * @param quantidadePessoas
     * @param valorMaximo
     * @param cliente
     * @return true se obteve sucesso, false caso contrário
     * @throws RemoteException 
     */
    public boolean RemoverInteresseQuarto(String localizacao, Integer quantidadePessoas, Integer valorMaximo, String cliente) throws RemoteException;
    /**
     * 
     * @param para
     * @param de
     * @param localizacao
     * @param valorMaximo
     * @param quantidadePessoas
     * @param cliente
     * @return true se obteve sucesso, false caso contrário
     * @throws RemoteException 
     */
    public boolean RegistrarInteressePacote(String para, String de, String localizacao, Integer valorMaximo, Integer quantidadePessoas, String cliente) throws RemoteException;
    /**
     * 
     * @param para
     * @param de
     * @param localizacao
     * @param valorMaximo
     * @param quantidadePessoas
     * @return true se obteve sucesso, false caso contrário
     * @throws RemoteException 
     */
    public boolean RemoverInteressePacote(String para, String de, String localizacao, Integer valorMaximo, Integer quantidadePessoas) throws RemoteException;
}
