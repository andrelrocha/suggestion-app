package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@RestController
@CronapiMetaData(type = "blockly")
@CronappSecurity
public class CompletaUser {

public static final int TIMEOUT = 300;

/**
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 08/11/2023, 12:16:02
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
    Var.valueOf("Suggestion.active.userId"), userId);
    return Var.VAR_NULL;
   }
 }.call();
}

}

