package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@RestController
@CronapiMetaData(type = "blockly")
@CronappSecurity
public class CompletaCamposComment {

public static final int TIMEOUT = 300;

/**
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 10/11/2023, 15:24:46
 *
 */
@RequestMapping(path = "/api/cronapi/rest/CompletaCamposComment:completarCampos", method = RequestMethod.GET, consumes = "*/*")
public static void completarCampos() throws Exception {
  new Callable<Var>() {

   private Var completarSugestaoID = Var.VAR_NULL;
   private Var completarUserID = Var.VAR_NULL;
   private Var completarUsername = Var.VAR_NULL;

   public Var call() throws Exception {
    completarSugestaoID =
    Var.valueOf(fillSuggestionId());
    completarUserID =
    Var.valueOf(getUserByUserLogado());
    completarUsername =
    Var.valueOf(getUsernameByUserLogado());
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 10/11/2023, 15:24:46
 *
 */
@RequestMapping(path = "/api/cronapi/rest/CompletaCamposComment:fillSuggestionId", method = RequestMethod.GET, consumes = "*/*")
public static Var fillSuggestionId() throws Exception {
 return new Callable<Var>() {

   private Var suggestionId = Var.VAR_NULL;

   public Var call() throws Exception {
    suggestionId =
    Var.valueOf(
    cronapi.screen.Operations.getValueOfField(
    Var.valueOf("params.suggestionId")).getObjectAsString());
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.setVisibility"),
    Var.valueOf("suggestionId"),
    Var.valueOf("false"));
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
 * @since 10/11/2023, 15:24:46
 *
 */
@RequestMapping(path = "/api/cronapi/rest/CompletaUser:getUserByUserLogado", method = RequestMethod.GET, consumes = "*/*")
public static Var getUserByUserLogado() throws Exception {
 return new Callable<Var>() {

   private Var userId = Var.VAR_NULL;

   public Var call() throws Exception {
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.setVisibility"),
    Var.valueOf("userId"),
    Var.valueOf("false"));
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

/**
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 10/11/2023, 15:24:46
 *
 */
public static Var getUsernameByUserLogado() throws Exception {
 return new Callable<Var>() {

   private Var username = Var.VAR_NULL;

   public Var call() throws Exception {
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.setVisibility"),
    Var.valueOf("username"),
    Var.valueOf("false"));
    username =
    cronapi.database.Operations.getField(
    cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u \nfrom \n	User u  \nwhere \n	u.normalizedUserName = :normalizedUserName"),Var.valueOf("normalizedUserName",
    cronapi.util.Operations.getCurrentUserName())),
    Var.valueOf("this[0].userName"));
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
    Var.valueOf("Comment.active.username"), username);
    return Var.VAR_NULL;
   }
 }.call();
}

}

