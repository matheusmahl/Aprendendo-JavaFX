/**
 * 
 */
package br.mahl.javafx.conexao.interfaces;

import java.sql.Connection;

/**
 * @author MatheusMahl
 *
 */
public interface ConexaoDatabase {
	
	Connection getConexao();

}
