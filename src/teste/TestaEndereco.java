package teste;

import dao.CidadesDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cidades;

/**
 *
 * @author Diego Munhoz
 */
public class TestaEndereco {

    public static void main(String[] args){
        
        CidadesDAO dao = new CidadesDAO();        
        Cidades cidades = new Cidades();
        cidades.setCidadeId(9999999);
        cidades.setDescCidade("Teste Inclusão Cidade");
        cidades.setFlgEstado("TT");
        try {
            dao.salvar(cidades);
            
        } catch (Exception ex) {
            Logger.getLogger(TestaEndereco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}