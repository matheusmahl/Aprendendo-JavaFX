/**
 * 
 */
package br.mahl.javafx.conexao;

import br.mahl.javafx.conexao.interfaces.ConexaoDatabase;
import br.mahl.javafx.enumeradores.TipoDatabase;

/**
 * @author MatheusMahl
 *
 */
public class DatabaseFactory {
	
	public static ConexaoDatabase getConexaoDatabase(TipoDatabase tipoDatabase) {			
		
		if (tipoDatabase == TipoDatabase.tdFirebird){
			return new ConexaoFirebird();		
		}
		
		return null;
	}

}
