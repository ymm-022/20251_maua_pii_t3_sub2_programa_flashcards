
package br.imt.pimaua;

public class Flashcard {
    //Atributos da classe.
    private String pergunta ;
    private String resposta ;
    private int idflashcard ;
    private String dificuldade ;
 
    //Construtor da classe.
    public Flashcard(String pergunta, String resposta, int idflashcard, String dificuldade){
        this.pergunta = pergunta ;
        this.resposta = resposta ;
        this.idflashcard = idflashcard ;   
        this.dificuldade = dificuldade ;
    }
    
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
    public int getIdflashcard(){
        return this.idflashcard ;
    }
    //p/ DIFICULDADE:
    public String getDificuldade(){
        return this.dificuldade ;
    }
    public void setDificuldade(String dificuldade){
        this.dificuldade = dificuldade ;
    }
    
    //Metodos da classe:
    //Mostra a pergunta:
    public String mostrarPergunta(){
        return "QUESTÃO: " + idflashcard + " " + pergunta ;
    }
    //Mostra  resposta:
    public String mostrarResposta(){
        return "RESPOSTA: " + resposta + " " + "(DIFICULDADE: " + dificuldade + ")" ;
    }
    
    //Helpers (metodos que ajudam na organizacao nos codigos de testes).
    @Override //O @Override garante que voce esta sobrescrevendo um metodo e nao criando um completamente novo.
    public boolean equals(Object objeto) {
        if(objeto.getClass().equals(this.getClass())){  //A funcao equals() e utilizada para comparar objetos.
            Flashcard flashcard = (Flashcard) objeto; //Casting: convertemos o parametro objeto de tipo Objeto para o tipo Flashcard.
            return this.idflashcard.equals(flashcard.getIdflashcard()) ; //Compara o ID do objeto atual com o objeto passado como parametro.
        } else {
            return false;
        }
    }
    
    @Override
    public String toString(){ //O metodo toString() serve para obter uma representação em string de um objeto, facilitando a exibição de informações.
        return "FLASHCARD: (" + "ID: " + idflashcard + 
                ", PERGUNTA: " + pergunta + 
                ", RESPOSTA: " + resposta + 
                ", DIFICULDADE: " + dificuldade + ")" ; 
    }
}

