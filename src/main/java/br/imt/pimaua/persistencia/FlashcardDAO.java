/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.imt.pimaua.persistencia;
import br.imt.pimaua.Flashcard;
import java.sql.ResultSet;
import java.util.*;
import java.sql.PreparedStatement;
/**
 *
 * @author Gustavo M.C
 */
public class FlashcardDAO {
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
                var idFlashcard = rs.getInt("id_flashcard");
                var dificuldade = rs.getString("dificuldade_flashcard");
                var flashcard = new Flashcard(pergunta, resposta,idFlashcard, dificuldade);
                flashcards.add(flashcard);
            }
            return flashcards;
        }
    }
    public void cadastrar(Flashcard flashcard) throws Exception {
        var sql = "INSERT INTO Flashcard (pergunta_flashcard, resposta_flashcard, id_flashcard, dificuldade_flashcard) VALUES (?, ?, ?, ?)";

        try (
            var conexao = new br.imt.pimaua.persistencia.ConnectionFactory().obterConexao();
            var ps = conexao.prepareStatement(sql);
        ) {
            ps.setString(1, flashcard.getPergunta());
            ps.setString(2, flashcard.getResposta());
            ps.setInt(3, flashcard.getIdflashcard());
            ps.setString(4, flashcard.getDificuldade());
            ps.executeUpdate();
        }
    }
}
