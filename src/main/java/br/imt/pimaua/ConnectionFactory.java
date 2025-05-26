
package br.imt.pimaua;

import java.sql.Connection ;
import java.sql.DriverManager ;

public class ConnectionFactory {
    private String host = "mysql-gyozadb-pii-20251-maua.i.aivencloud.com" ;
    private String port = "24545" ;
    private String db = "20251_MAUA_PII_FLASHCARDS" ;
    private String user = "avnadmin" ;
    private String password = "AVNS_SkxHbc0w6rZJyVV_5XY" ;
    
    public Connection obterConexao() throws Exception{
        var s = String.format(
        "jdbc:mysql://%s:%s/%s",
        host, port, db 
        ) ;
        Connection c = DriverManager.getConnection(s, user, password) ;
        return c ;
    }
    
    public static void main(String [] args) throws Exception{
        var fabricaDeConexoes = new ConnectionFactory() ;
        Connection conexao = fabricaDeConexoes.obterConexao() ;
        if(conexao != null){
            System.out.println("Conectou!") ;
        }
        else{
            System.out.println("Não conectou...") ;
        }
    }
}
