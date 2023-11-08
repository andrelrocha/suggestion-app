package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@RestController
@CronapiMetaData(type = "blockly")
@CronappSecurity
public class ConsultaSeExisteSugestaoJaCriada {

public static final int TIMEOUT = 300;

/**
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 08/11/2023, 14:15:10
 *
 */
@RequestMapping(path = "/api/cronapi/rest/ConsultaSeExisteSugestaoJaCriada:consultarSugestaoByName", method = RequestMethod.GET, consumes = "*/*")
public static Var consultarSugestaoByName() throws Exception {
 return new Callable<Var>() {

   private Var suggestionName = Var.VAR_NULL;
   private Var existeSugestao = Var.VAR_NULL;
   private Var novaSugestao = Var.VAR_NULL;

   public Var call() throws Exception {
    suggestionName =
    cronapi.screen.Operations.getValueOfField(
    Var.valueOf("Suggestion.active.suggestionName"));
    existeSugestao =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Suggestion"),Var.valueOf("select \n	s \nfrom \n	Suggestion s  \nwhere \n	s.suggestionName = :suggestionName"),Var.valueOf("suggestionName",suggestionName));
    if (
    cronapi.logic.Operations.isNullOrEmpty(existeSugestao).getObjectAsBoolean()) {
        novaSugestao =
        cronapi.database.Operations.insert(Var.valueOf("app.entity.Suggestion"),Var.valueOf("dateTime",
        cronapi.dateTime.Operations.getNow()),Var.valueOf("genre",
        cronapi.screen.Operations.getValueOfField(
        Var.valueOf("Suggestion.active.genre"))),Var.valueOf("suggestionName",
        cronapi.screen.Operations.getValueOfField(
        Var.valueOf("Suggestion.active.suggestionName"))),Var.valueOf("text",
        cronapi.screen.Operations.getValueOfField(
        Var.valueOf("Suggestion.active.text"))),Var.valueOf("userId",
        cronapi.screen.Operations.getValueOfField(
        Var.valueOf("Suggestion.active.userId"))));
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.openUrl"),
        Var.valueOf(
        cronapi.util.Operations.getBaseUrl().getObjectAsString() +
        Var.valueOf("#/home").getObjectAsString()), Var.VAR_NULL,
        Var.VAR_NULL,
        Var.VAR_NULL);
    } else {
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"),
        Var.valueOf("Já existe sugestão cadastrada com o mesmo nome, favor fazer um comentário"));
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.openUrl"),
        Var.valueOf(
        cronapi.util.Operations.getBaseUrl().getObjectAsString() +
        Var.valueOf("#/home/logged/comment").getObjectAsString()), Var.VAR_NULL,
        Var.VAR_NULL,
        Var.VAR_NULL);
    }
    return Var.VAR_NULL;
   }
 }.call();
}

}

