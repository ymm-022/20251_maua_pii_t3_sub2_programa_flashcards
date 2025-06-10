
package br.imt.pimaua.testes;

import br.imt.pimaua.Flashcard ;
import br.imt.pimaua.Baralho ;
import org.junit.Test ;
import java.util.ArrayList ;
import java.util.List ;

public class BaralhoTeste {
    
    @Test
    public void addFlashcard(){
        String id = "1" ;
        String resposta = "resposta" ;
        String pergunta = "pergunta" ;
        String dificuldade = "dificuldade" ;
        Flashcard flashcard = new Flashcard(id, pergunta, resposta, dificuldade) ;
        String titulo = null;
        Baralho baralho = new Baralho(titulo) ;
        
        baralho.addFlashcard(flashcard) ;
        
        assert(baralho.getTamanho() == 1) ;
    }
    
    @Test
    public void addFlashcardBaralhoAntigo(){
        List<Flashcard> listaflashcards = new ArrayList<>() ;
        String id = "1" ;
        String resposta = "resposta" ;
        String pergunta = "pergunta" ;
        String dificuldade = "dificuldade" ;
        Flashcard flashcard = new Flashcard(id, resposta, pergunta, dificuldade) ;
        Flashcard flashcard2 = new Flashcard(id, resposta, pergunta, dificuldade) ;
        Flashcard flashcard3 = new Flashcard(id, resposta, pergunta, dificuldade) ;
        listaflashcards.add(flashcard) ;
        listaflashcards.add(flashcard2) ;
        Baralho baralho = new Baralho(listaflashcards) ; 
        
        baralho.addFlashcard(flashcard3) ;
        
        assert(baralho.getTamanho() == 3) ;
    }
    
    @Test
    public void removeFlashcard(){
        List<Flashcard> listaflashcards = new ArrayList<>() ;
        String idbaralho = "1" ;
        String resposta = "resposta" ;
        String pergunta = "pergunta" ;
        String dificuldade = "dificuldade" ;
        Flashcard flashcard = new Flashcard(idbaralho, resposta, pergunta, dificuldade) ;
        Flashcard flashcard2 = new Flashcard(idbaralho, resposta, pergunta, dificuldade) ;
        Flashcard flashcard3 = new Flashcard(idbaralho, resposta, pergunta, dificuldade) ;
        String titulo = null;
        var baralho = new Baralho(titulo) ;
        listaflashcards.add(flashcard) ;
        listaflashcards.add(flashcard2) ;
        listaflashcards.add(flashcard3) ;
             
        baralho.removeFlashcard(flashcard) ;
        
        assert(baralho.getTamanho() == 2) ;
    }
    
    @Test
    public void getFlashcard(){
        List<Flashcard> listaflashcards = new ArrayList<>() ;
        String idbaralho = "1" ;
        String resposta = "resposta" ;
        String pergunta = "pergunta" ;
        String dificuldade = "dificuldade" ;
        Flashcard flashcard = new Flashcard(idbaralho, resposta, pergunta, dificuldade) ;
        Flashcard flashcard2 = new Flashcard("2", "resposta2", "pergunta2", "dificuldade2") ;
        Flashcard flashcard3 = new Flashcard("3", "resposta3", "pergunta3", "dificuldade3") ;
        String titulo = null;
        Baralho baralho = new Baralho(titulo) ;
        listaflashcards.add(flashcard) ;
        listaflashcards.add(flashcard2) ;
        listaflashcards.add(flashcard3) ;
        
        assert(baralho.getFlashcard(0) == flashcard) ;
    }
    
    @Test
    public void getTamanho(){
        List<Flashcard> listaflashcards = new ArrayList<>() ;
        String idbaralho = "1" ;
        String resposta = "resposta" ;
        String pergunta = "pergunta" ;
        String dificuldade = "dificuldade" ;
        Flashcard flashcard = new Flashcard(idbaralho, resposta, pergunta, dificuldade) ;
        listaflashcards.add(flashcard) ;
        listaflashcards.add(flashcard) ;
        Baralho baralho = new Baralho(listaflashcards) ;
        
        baralho.addFlashcard(flashcard) ;       
        
        assert (baralho.getTamanho() == 3) ;
    }
 
}
