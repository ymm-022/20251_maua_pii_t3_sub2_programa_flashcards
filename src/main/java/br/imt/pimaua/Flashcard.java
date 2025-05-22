
package br.imt.pimaua;

public class Flashcard {
    //Atributos da classe.
    private String pergunta ;
    private String resposta ;
    private String id_flashcard ;
 
    //Construtor da classe.
    public Flashcard(String pergunta, String resposta, String id_flashcard){
        this.pergunta = pergunta ;
        this.resposta = resposta ;
        this.id_flashcard = id_flashcard ;      
    }
    
    //Metodos.
    //Getters / Setters.
    //p/ PERGUNTA:
    public String getPerguta(){
        return this.pergunta ;
    }
    public void setPergunta(String pergunta){
        this.pergunta = pergunta ;
    }
    
    //p/ RESPOSTA:
    public String getResposta(){
        return this.resposta ;
    }
    public void setResposta(String resposta){
        this.resposta = resposta ;
    }
    
    //p/ ID_FLASHCARD:
    public String getId(){
        return this.id_flashcard ;
    }
    public void setId(String id_flashcard){
        this.id_flashcard = id_flashcard ;
    }
    
    //Helpers (metodos que ajudam na organizacao nos codigos de testes).
    @Override //O @Override garante que voce esta sobrescrevendo um metodo e nao criando um completamente novo.
    public boolean equals(Object objeto) {
        if(objeto.getClass().equals(this.getClass())){  //A funcao equals() e utilizada para comparar objetos.
            Flashcard card = (Flashcard) objeto; //Casting: convertemos o parametro objeto de tipo Objeto para o tipo Flashcard.
            return this.id_flashcard.equals(card.getId()); //Compara o ID do objeto atual com o objeto passado como parametro.
        } else {
            return false;
        }
    }
}
