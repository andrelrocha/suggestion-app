package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class CompletaCamposComment {

public static final int TIMEOUT = 300;

/**
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 10/11/2023, 12:49:16
 *
 */
public static void completarCampos() throws Exception {
  new Callable<Var>() {

   private Var completarSugestaoID = Var.VAR_NULL;
   private Var completarUserID = Var.VAR_NULL;

   public Var call() throws Exception {
    System.out.println(
    Var.valueOf("ANTESS DE CHAMAR P COMPLETAR SUGESTAO ID").getObjectAsString());
    completarSugestaoID =
    Var.valueOf(fillSuggestionId());
    System.out.println(
    Var.valueOf("DEPOIS DE CHAMAR P COMPLETAR SUGESTAO ID").getObjectAsString());
    completarUserID =
    Var.valueOf(getUserByUserLogado());
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 10/11/2023, 12:49:16
 *
 */
public static Var fillSuggestionId() throws Exception {
 return new Callable<Var>() {

   private Var suggestionId = Var.VAR_NULL;

   public Var call() throws Exception {
    System.out.println(
    Var.valueOf("CHAMOU fill suggestion").getObjectAsString());
    suggestionId =
    Var.valueOf(
    cronapi.screen.Operations.getValueOfField(
    Var.valueOf("params.suggestionId")).getObjectAsString());
    System.out.println(suggestionId.getObjectAsString());
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.setVisibility"),
    Var.valueOf("suggestionId"),
    Var.valueOf("true"));
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
    Var.valueOf("Comment.active.suggestionId"), suggestionId);
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
    Var.valueOf("vars.suggestionName"),
    cronapi.database.Operations.getField(
    cronapi.database.Operations.query(Var.valueOf("app.entity.Suggestion"),Var.valueOf("select \n	s \nfrom \n	Suggestion s  \nwhere \n	s.id = :id"),Var.valueOf("id",suggestionId)),
    Var.valueOf("this[0].suggestionName")));
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 10/11/2023, 12:49:16
 *
 */
public static Var getUserByUserLogado() throws Exception {
 return new Callable<Var>() {

   private Var userId = Var.VAR_NULL;

   public Var call() throws Exception {
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.setVisibility"),
    Var.valueOf("userId"),
    Var.valueOf("true"));
    userId =
    cronapi.database.Operations.getField(
    cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u \nfrom \n	User u  \nwhere \n	u.normalizedUserName = :normalizedUserName"),Var.valueOf("normalizedUserName",
    cronapi.util.Operations.getCurrentUserName())),
    Var.valueOf("this[0].id"));
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
    Var.valueOf("Comment.active.userId"), userId);
    return Var.VAR_NULL;
   }
 }.call();
}

}

