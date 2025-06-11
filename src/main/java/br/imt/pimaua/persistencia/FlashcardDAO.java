/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.imt.pimaua.persistencia;
import br.imt.pimaua.Flashcard;
import java.sql.ResultSet;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author Gustavo M.C
 */

public class FlashcardDAO {
       private static final String URL = "jdbc:mysql://mysql-32f32e55-muratajulio2-b7b5.i.aivencloud.com:21431/defaultdb";

  
    private static final String USER = "avnadmin" ;
    private static final String PASSWORD = "AVNS_mXvB2fDNsdVZeeDwyXH" ;
    
    public List <Flashcard> obterFlashcard() throws Exception{
        
       
        var flashcards = new ArrayList<Flashcard>();
        var sql = "SELECT * FROM Flashcard";
        try(
            var conexao = new br.imt.pimaua.persistencia.ConnectionFactory().obterConexao();
            var ps = conexao.prepareStatement(sql);
            var rs = ps.executeQuery();
        ){
            while(rs.next()){
                var pergunta = rs.getString("pergunta_flashcard");
                var resposta = rs.getString("resposta_flashcard");
                var id_flashcard = rs.getInt("id_flashcard");
                var dificuldade = rs.getString("dificuldade_flashcard");
                var materia = rs.getString("materia_flashcard") ;
                var flashcard = new Flashcard(pergunta, resposta, id_flashcard, dificuldade, materia);
                flashcards.add(flashcard);
            }
            return flashcards;
        }
    }
    public List<Flashcard> buscarPorDificuldade(String dificuldade) {
    List<Flashcard> flashcards = new ArrayList<>();
    String sql = "SELECT * FROM Flashcard WHERE dificuldade_flashcard = ?";

try {
    Connection conexao = new ConnectionFactory().obterConexao();
    PreparedStatement ps = conexao.prepareStatement(sql);

    ps.setString(1, dificuldade);
    ResultSet rs = ps.executeQuery();

    while (rs.next()) {
    System.out.println(">>> Linha encontrada no banco!");

    var pergunta = rs.getString("pergunta_flashcard");
    var resposta = rs.getString("resposta_flashcard");
    var id_flashcard = rs.getInt("id_flashcard");

    // Testa se as colunas existem
    dificuldade = rs.getString("dificuldade_flashcard");
    var materia = rs.getString("materia_flashcard");

    System.out.println(pergunta + " | " + resposta + " | " + dificuldade + " | " + materia);

    var flashcard = new Flashcard(pergunta, resposta, id_flashcard, dificuldade, materia);
    flashcards.add(flashcard);
}


    rs.close();
    ps.close();
    conexao.close();
} catch (Exception e) {
    e.printStackTrace();
}


    return flashcards;
}

    public void cadastrar(Flashcard flashcard) throws Exception {
        var sql = "INSERT INTO Flashcard (pergunta_flashcard, resposta_flashcard, dificuldade_flashcard, materia_flashcard) VALUES (?, ?, ?, ?)";

        try (
            var conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            var ps = conexao.prepareStatement(sql);
        ) {
            ps.setString(1, flashcard.getPergunta());
            ps.setString(2, flashcard.getResposta());
            ps.setString(3, flashcard.getDificuldade());
            ps.setString(4, flashcard.getMateria());
            
            ps.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace() ;
            throw e ;
        }
    }
}
