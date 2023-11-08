package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@RestController
@CronapiMetaData(type = "blockly")
@CronappSecurity
public class CompletarSuggestionId {

public static final int TIMEOUT = 300;

/**
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 08/11/2023, 17:32:33
 *
 */
@RequestMapping(path = "/api/cronapi/rest/CompletarSuggestionId:fillSuggestionId", method = RequestMethod.GET, consumes = "*/*")
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

}

