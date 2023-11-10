package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@RestController
@CronapiMetaData(type = "blockly")
@CronappSecurity
public class CompletaCamposUser {

public static final int TIMEOUT = 300;

/**
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 10/11/2023, 14:14:29
 *
 */
public static void completaCampos() throws Exception {
  new Callable<Var>() {

   private Var getUserId = Var.VAR_NULL;

   public Var call() throws Exception {
    getUserId =
    Var.valueOf(fillUserId());
    fillUsername();
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 10/11/2023, 14:14:29
 *
 */
@RequestMapping(path = "/api/cronapi/rest/CompletaUserComment:fillUserId", method = RequestMethod.GET, consumes = "*/*")
public static Var fillUserId() throws Exception {
 return new Callable<Var>() {

   private Var userId = Var.VAR_NULL;

   public Var call() throws Exception {
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.setVisibility"),
    Var.valueOf("userId"),
    Var.valueOf("false"));
    userId =
    cronapi.database.Operations.getField(
    cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u \nfrom \n	User u  \nwhere \n	u.userName = :userName"),Var.valueOf("userName",
    cronapi.util.Operations.getCurrentUserName())),
    Var.valueOf("this[0].id"));
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
    Var.valueOf("Suggestion.active.userId"), userId);
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 10/11/2023, 14:14:29
 *
 */
public static void fillUsername() throws Exception {
  new Callable<Var>() {

   private Var username = Var.VAR_NULL;

   public Var call() throws Exception {
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.setVisibility"),
    Var.valueOf("username"),
    Var.valueOf("false"));
    username =
    cronapi.database.Operations.getField(
    cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u \nfrom \n	User u  \nwhere \n	u.userName = :userName"),Var.valueOf("userName",
    cronapi.util.Operations.getCurrentUserName())),
    Var.valueOf("this[0].normalizedUserName"));
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
    Var.valueOf("Suggestion.active.username"), username);
   return Var.VAR_NULL;
   }
 }.call();
}

}

