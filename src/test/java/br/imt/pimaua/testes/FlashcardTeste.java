
package br.imt.pimaua.testes;

import br.imt.pimaua.Flashcard ;
import org.junit.Test ;

public class FlashcardTeste {
    @Test
    public void getIdflashcard(){
        String id_flashcard = "1" ;
        var pergunta = "pergunta" ;
        var resposta = "resposta" ;
        var dificuldade = "dificuldade" ;
        var flashcard = new Flashcard(id_flashcard, pergunta, resposta, dificuldade) ;
        
        flashcard.setId_flashcard(id_flashcard) ;
        
        assert(flashcard.getId_flashcard().equals("1")) ;
    }
    
    @Test
    public void getPergunta(){
        String id_flashcard = "1" ;
        var pergunta = "pergunta" ;
        var resposta = "resposta" ;
        var dificuldade = "dificuldade" ;
        Flashcard flashcard = new Flashcard(id_flashcard, pergunta, resposta, dificuldade) ;
        
        flashcard.setPergunta(pergunta) ;
        
        assert(flashcard.getPerguta() == "pergunta") ;
    }
    
    @Test
    public void getResposta(){
        String id_flashcard = "1" ;
        var pergunta = "pergunta" ;
        var resposta = "resposta" ;
        var dificuldade = "dificuldade" ;
        Flashcard flashcard = new Flashcard(id_flashcard, pergunta, resposta, dificuldade) ;
        
        flashcard.setResposta(resposta) ;
        
        assert(flashcard.getResposta() == "resposta") ;
    }
    
    @Test
    public void testEquals(){
        var id_flashcard = "1" ;
        var pergunta = "pergunta" ;
        var resposta = "resposta" ;
        var dificuldade = "dificuldade" ;
        Flashcard flashcard1 = new Flashcard(id_flashcard, pergunta, resposta, dificuldade) ;
        Flashcard flashcard2 = new Flashcard(id_flashcard, pergunta, resposta, dificuldade) ;
        
        flashcard1.setId_flashcard(id_flashcard) ;
        
        assert(flashcard1 == flashcard2) ;
    }
    
    @Test 
    public void testEqualsFalse(){
        String id_flashcard1 = "1" ;
        var pergunta1 = "pergunta" ;
        var resposta1 = "resposta" ;
        var dificuldade1 = "dificuldade" ;
        Flashcard flashcard1 = new Flashcard(id_flashcard1, pergunta1, resposta1, dificuldade1) ;
        
        String id_flashcard2 = "2" ;
        var pergunta2 = "perguntas" ;
        var resposta2 = "respostas" ;
        var dificuldade2 = "dificuldades" ;
        Flashcard flashcard2 = new Flashcard(id_flashcard2, pergunta2, resposta2, dificuldade2) ;
        
        boolean flashcardE = flashcard1.equals(flashcard2) ;
        
        assert(!flashcardE) ;
    }
    
    @Test 
    public void testEqualsFalseObject(){
        String id_flashcard = "1" ;
        var pergunta = "pergunta" ;
        var resposta = "resposta" ;
        var dificuldade = "dificuldade" ;
        Flashcard flashcard = new Flashcard(id_flashcard, pergunta, resposta, dificuldade) ;   
        
        Object obj = new Object() ;
        
        boolean flashcardE = flashcard.equals(obj) ;
        
        assert(!flashcardE) ;
    }
}
