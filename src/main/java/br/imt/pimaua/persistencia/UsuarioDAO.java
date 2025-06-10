package br.imt.pimaua.persistencia;
import br.imt.pimaua.Usuario ;
import br.imt.pimaua.persistencia.ConnectionFactory ;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    public List <Usuario> obterusuario() throws Exception{
         
        var usuarios = new ArrayList<Usuario>();
        var sql = "SELECT * FROM usuario";
        try(
            var conexao = new ConnectionFactory().obterConexao();
            var ps = conexao.prepareStatement(sql);
            var rs = ps.executeQuery();
        ){
            while(rs.next()){
                var idusuario = rs.getInt("id_usuario");
                var nome = rs.getString("nome_usuario");
                var email = rs.getString("email_usuario");
                var senha = rs.getInt("senha_usuario");
                var usuario = new Usuario(idusuario, nome, email, senha);
                usuarios.add(usuario);
            }
            return usuarios;
        }
    }
    public void cadastrar(Usuario usuario) throws Exception {
        var sql = "INSERT INTO usuario (id_usuario, nome_usuario, email_usuario, senha_usuario) VALUES (?, ?, ?, ?)";

        try (
            var conexao = new ConnectionFactory().obterConexao();
            var ps = conexao.prepareStatement(sql);
        ) {
            ps.setInt(1, usuario.getIdusuario());
            ps.setString(2, usuario.getNome());
            ps.setString(3, usuario.getEmail());
            ps.setInt(4, usuario.getSenha());
            ps.executeUpdate();
        }
    }  
    public boolean autenticar(String email, int senha) throws Exception {
    var usuarios = obterusuario(); // usa seu método existente

    for (Usuario usuario : usuarios) {
        if (usuario.getEmail().equals(email) && usuario.getSenha() == senha) {
            return true; // usuário encontrado
        }
    }
    return false; // nenhum usuário correspondente
}

}
