
package br.imt.pimaua.persistencia;

import java.sql.Connection ;
import java.sql.DriverManager ;

public class ConnectionFactory {
    private String host = "mysql-32f32e55-muratajulio2-b7b5.i.aivencloud.com" ;
    private String port = "21431" ;
    private String db = "defaultdb";
    private String user = "avnadmin" ;
    private String password = "AVNS_mXvB2fDNsdVZeeDwyXH" ;
    
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
