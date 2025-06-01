package br.imt.pimaua.persistencia;

import br.imt.pimaua.Baralho;
import br.imt.pimaua.Flashcard;
import java.util.ArrayList;
import java.util.List;

public class BaralhoDAO {
    public List <Baralho> obterBaralho() throws Exception{
        var baralhos = new ArrayList<Baralho>();
        var sql = "SELECT * FROM Baralho";
        try(
            var conexao = new br.imt.pimaua.persistencia.ConnectionFactory().obterConexao();
            var ps = conexao.prepareStatement(sql);
            var rs = ps.executeQuery();
        ){
            while(rs.next()){
                var idBaralho = rs.getInt("id_baralho");
                var nome = rs.getString("nome_baralho");
                var materia = rs.getString("nome_materia");
                var baralho = new Baralho(idBaralho, nome, materia);
                baralhos.add(baralho);
            }
            return baralhos;
        }
    }
    public void cadastrar(Baralho baralho) throws Exception {
        var sql = "INSERT INTO Baralho (id_baralho, nome_baralho) VALUES (?, ?)\nINSERT INTO Materia (nome_materia) VALUES (?)";

        try (
            var conexao = new br.imt.pimaua.persistencia.ConnectionFactory().obterConexao();
            var ps = conexao.prepareStatement(sql);
        ) {
            ps.setInt(1, baralho.getIdbaralho());
            ps.setString(2, baralho.getNome());
            ps.setString(3, baralho.getMateria());
            ps.executeUpdate();
        }
    }
}
