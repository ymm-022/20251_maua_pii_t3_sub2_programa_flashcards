
package br.imt.pimaua;

//Imports
import java.util.ArrayList ;
import java.util.List ; 

public class Baralho {
    //Atributos da classe.
    private String id_baralho ;
    private String nome ;
    private String materia ;
    private List<Flashcard> flashcard ;
    private String autor ;
    
    //Construtores da classe.
    //PADRAO:
    //O construtor padrao pode ser criado sem parametros, caso o usuario nao o usuario nao especifica-los
    public Baralho(){
        this.flashcard = new ArrayList<>() ;
    }
    //COM ATRIBUTOS:
    public Baralho(String id_baralho, String nome, String materia, String autor){
        this.id_baralho = id_baralho ;
        this.nome = nome ;
        this.materia = materia ;
        this.autor = autor ;                   
    }
    // Getters / Setters
    //p/ ID_BARALHO:
    public String getId_baralho(){
        return this.id_baralho ;
    }
    public void setId_baralho(String id_baralho){
        this.id_baralho = id_baralho ;
    }
    //p/ NOME:
    public String getNome(){
        return this.nome ;
    }
    public void setNome(String nome){
        this.nome = nome ;
    }
    //p/ MATERIA:
    public String getMateria(){
        return this.materia ;
    }
    public void setMateria(String materia){
        this.materia = materia ;
    }
    //p/ AUTOR:
    public String getAutor(){
        return this.autor ;
    }
    public void setAutor(String autor){
        this.autor = autor ;
    }
    
    public Flashcard getFlashcard(int index) {
        return flashcard.get(index);
    }
    
    //Metodos da classe:
    //Adicionar flashcard:
    public void adicionarFlashcard(Flashcard flashcard){
        if (flashcard != null){ //Validacao para evitar que ocorra um NullPointerException e que um valor null seja adicionado ao baralho.
            this.flashcard.add(flashcard) ;
        }
    }
    //Remove flashcard:
    public void removeFlashcard(Flashcard flashcard){
        if (flashcard != null){ //Validacao condicional para evitar que ocorra um NullPointerException.
            this.flashcard.remove(flashcard) ;
        }
    }
    
    @Override
    public String toString() { //O metodo toString() serve para obter uma representação em string de um objeto, facilitando a exibição de informações.
        return "BARALHO: (" + "ID: " + id_baralho +
                ", NOME: " + nome +  
                ", MATERIA: " + materia +
                ", AUTOR: " + autor + ")" ;
    }
    public String mostrarDetalhes() {
        StringBuilder sb = new StringBuilder(); //O StringBuilder facilita a exibição de informacoes, evitando criar objetos desnecsessários.
        sb.append("=== BARALHO ===\n");
        sb.append("ID: ").append(id_baralho).append("\n");
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("Matéria: ").append(materia).append("\n");
        sb.append("Autor: ").append(autor).append("\n");
        
        if (!flashcard.isEmpty()) { //Validacao condicional para evitar que o programa exiba uma seção vazia.
            sb.append("\n=== FLASHCARDS ===\n");
            for (int i = 0; i < flashcard.size(); i++) { //Loop para listar os flashcards.
                sb.append((i + 1)).append(flashcard.get(i).mostrarPergunta()).append("\n");
            }
        }
        return sb.toString();//Converte o String Builder em String final, retornando o texto formato completo.
    }
}
