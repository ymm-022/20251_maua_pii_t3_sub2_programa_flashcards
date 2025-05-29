
package br.imt.pimaua.testes;

import br.imt.pimaua.Flashcard ;
import org.junit.Test ;

public class FlashcardTeste {
    @Test
    public void getId_flashcard(){
        String idflashcard = "1" ;
        var pergunta = "pergunta" ;
        var resposta = "resposta" ;
        var dificuldade = "dificuldade" ;
        Flashcard flashcard = new Flashcard(idflashcard, pergunta, resposta, dificuldade) ;
        
        assert(flashcard.getIdflashcard().equals("1")) ;
    }
    
    @Test
    public void getPergunta(){
        String idflashcard = "1" ;
        var pergunta = "pergunta" ;
        var resposta = "resposta" ;
        var dificuldade = "dificuldade" ;
        Flashcard flashcard = new Flashcard(idflashcard, pergunta, resposta, dificuldade) ;
        
        flashcard.setPergunta(pergunta) ;
        
        assert("pergunta".equals(flashcard.getPerguta())) ;
    }
    
    @Test
    public void getResposta(){
        String idflashcard = "1" ;
        var pergunta = "pergunta" ;
        var resposta = "resposta" ;
        var dificuldade = "dificuldade" ;
        Flashcard flashcard = new Flashcard(idflashcard, pergunta, resposta, dificuldade) ;
        
        flashcard.setResposta(resposta) ;
        
        assert("resposta".equals(flashcard.getResposta())) ;
    }
    
    @Test
    public void testEquals(){
        String idflashcard = "1" ;
        var pergunta = "pergunta" ;
        var resposta = "resposta" ;
        var dificuldade = "dificuldade" ;
        Flashcard flashcard1 = new Flashcard(idflashcard, pergunta, resposta, dificuldade) ;
        Flashcard flashcard2 = new Flashcard(idflashcard, pergunta, resposta, dificuldade) ;
        
        assert(flashcard1 == flashcard2) ;
    }
    
    @Test 
    public void testEqualsFalse(){
        String idflashcard1 = "1" ;
        var pergunta1 = "pergunta" ;
        var resposta1 = "resposta" ;
        var dificuldade1 = "dificuldade" ;
        Flashcard flashcard1 = new Flashcard(idflashcard1, pergunta1, resposta1, dificuldade1) ;
        
        String idflashcard2 = "2" ;
        var pergunta2 = "perguntas" ;
        var resposta2 = "respostas" ;
        var dificuldade2 = "dificuldades" ;
        Flashcard flashcard2 = new Flashcard(idflashcard2, pergunta2, resposta2, dificuldade2) ;
        
        boolean flashcardE = flashcard1.equals(flashcard2) ;
        
        assert(!flashcardE) ;
    }
    
    @Test 
    public void testEqualsFalseObject(){
        String idflashcard = "1" ;
        var pergunta = "pergunta" ;
        var resposta = "resposta" ;
        var dificuldade = "dificuldade" ;
        Flashcard flashcard = new Flashcard(idflashcard, pergunta, resposta, dificuldade) ;   
        
        Object obj = new Object() ;
        
        boolean flashcardE = flashcard.equals(obj) ;
        
        assert(!flashcardE) ;
    }
}
