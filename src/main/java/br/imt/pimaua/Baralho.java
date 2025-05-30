
package br.imt.pimaua;

//Imports
import java.util.ArrayList ;
import java.util.List ; 

public class Baralho {
    //Atributos da classe.
    private int idbaralho ;
    private String nome ;
    private String materia ;
    private List<Flashcard> flashcards ;
    
    //Construtores da classe.
    //PADRAO:
    //O construtor padrao pode ser criado sem parametros, caso o usuario nao o usuario nao especifica-los
    public Baralho(){
        this.flashcards = new ArrayList<>() ;
    }

    //COM ATRIBUTOS:
    public Baralho(int idbaralho, String nome, String materia){
        this.idbaralho = idbaralho ;
        this.nome = nome ;
        this.materia = materia ;   
        this.flashcards = new ArrayList<>();
    }

    // Getters / Setters
    //p/ ID_BARALHO:

    public int getIdbaralho(){
        return this.idbaralho ;
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
    
    public Flashcard getFlashcard(int index) {
        return flashcards.get(index);
    }
    
    //Metodos da classe:
    //Adicionar flashcard:
    public void addFlashcard(Flashcard flashcard){
        if (flashcard != null){ //Validacao para evitar que ocorra um NullPointerException e que um valor null seja adicionado ao baralho.
            this.flashcards.add(flashcard) ;
        }
    }
    //Remove flashcard:
    public void removeFlashcard(Flashcard flashcard){
        if (flashcard != null){ //Validacao condicional para evitar que ocorra um NullPointerException.
            this.flashcards.remove(flashcard) ;
        }
    }
    public int getTamanho(){
        return flashcards.size() ;
    }
    
    @Override
    public String toString() { //O metodo toString() serve para obter uma representação em string de um objeto, facilitando a exibição de informações.
        return "BARALHO: (" + "ID: " + idbaralho +
                ", NOME: " + nome +  
                ", MATERIA: " + materia + ")" ;
    }
    public String mostrarDetalhes() {
        StringBuilder sb = new StringBuilder(); //O StringBuilder facilita a exibição de informacoes, evitando criar objetos desnecsessários.
        sb.append("=== BARALHO ===\n");
        sb.append("ID: ").append(idbaralho).append("\n");
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("Matéria: ").append(materia).append("\n");
        
        if (!flashcards.isEmpty()) { //Validacao condicional para evitar que o programa exiba uma seção vazia.
            sb.append("\n=== FLASHCARDS ===\n");
            for (int i = 0; i < flashcards.size(); i++) { //Loop para listar os flashcards.
                sb.append((i + 1)).append(flashcards.get(i).mostrarPergunta()).append("\n");
            }
        }
        return sb.toString();//Converte o String Builder em String final, retornando o texto formato completo.
    }
}
