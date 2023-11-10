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
 * @since 10/11/2023, 12:59:53
 *
 */
@RequestMapping(path = "/api/cronapi/rest/CompletaUserComment:fillUserId", method = RequestMethod.GET, consumes = "*/*")
public static Var fillUserId() throws Exception {
 return new Callable<Var>() {

   private Var userId = Var.VAR_NULL;

   public Var call() throws Exception {
    System.out.println(
    cronapi.util.Operations.getCurrentUserName().getObjectAsString());
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.setVisibility"),
    Var.valueOf("userId"),
    Var.valueOf("false"));
    userId =
    cronapi.database.Operations.getField(
    cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u \nfrom \n	User u  \nwhere \n	u.userName = :userName"),Var.valueOf("userName",
    cronapi.util.Operations.getCurrentUserName())),
    Var.valueOf("this[0].id"));
    System.out.println(userId.getObjectAsString());
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
    Var.valueOf("Suggestion.active.userId"), userId);
    return Var.VAR_NULL;
   }
 }.call();
}

}

