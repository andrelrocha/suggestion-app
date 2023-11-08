package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class ConsultaSeExisteSugestaoJaCriada {

public static final int TIMEOUT = 300;

/**
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 08/11/2023, 11:12:29
 *
 */
public static Var consultarSugestaoByName() throws Exception {
 return new Callable<Var>() {

   private Var suggestionName = Var.VAR_NULL;
   private Var existeSugestao = Var.VAR_NULL;
   private Var novoComentario = Var.VAR_NULL;

   public Var call() throws Exception {
    suggestionName =
    cronapi.screen.Operations.getValueOfField(
    Var.valueOf("Suggestion.active.suggestionName"));
    existeSugestao =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Suggestion"),Var.valueOf("select \n	s \nfrom \n	Suggestion s  \nwhere \n	s.suggestionName = :suggestionName"),Var.valueOf("suggestionName",suggestionName));
    System.out.println(suggestionName.getObjectAsString());
    System.out.println(existeSugestao.getObjectAsString());
    if (
    cronapi.logic.Operations.isNullOrEmpty(existeSugestao).getObjectAsBoolean()) {
      {}
    } else {
        novoComentario =
        cronapi.database.Operations.insert(Var.valueOf("app.entity.Comment"),Var.valueOf("suggestion",Var.VAR_NULL),Var.valueOf("user",Var.VAR_NULL),Var.valueOf("text",Var.VAR_NULL));
    }
    return Var.VAR_NULL;
   }
 }.call();
}

}

