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
 * @since 10/11/2023, 14:13:41
 *
 */
@RequestMapping(path = "/api/cronapi/rest/ConsultaSeExisteSugestaoJaCriada:consultarSugestaoByName", method = RequestMethod.GET, consumes = "*/*")
public static Var consultarSugestaoByName() throws Exception {
 return new Callable<Var>() {

   private Var suggestionName = Var.VAR_NULL;
   private Var existeSugestao = Var.VAR_NULL;
   private Var novaSugestao = Var.VAR_NULL;
   private Var suggestionId = Var.VAR_NULL;
   private Var novoComentario = Var.VAR_NULL;

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
        Var.valueOf("Suggestion.active.userId"))),Var.valueOf("username",
        cronapi.screen.Operations.getValueOfField(
        Var.valueOf("Suggestion.active.username"))));
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.disableComponent"),
        Var.valueOf("btn_crud_post_41813"));
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"),
        Var.valueOf("Tudo certo! Sua sugestão foi cadastrada no sistema!"));
    } else {
        suggestionId =
        cronapi.database.Operations.getField(existeSugestao,
        Var.valueOf("this[0].id"));
        novoComentario =
        cronapi.database.Operations.insert(Var.valueOf("app.entity.Comment"),Var.valueOf("suggestionId",suggestionId),Var.valueOf("text",
        cronapi.screen.Operations.getValueOfField(
        Var.valueOf("Suggestion.active.text"))),Var.valueOf("userId",
        cronapi.screen.Operations.getValueOfField(
        Var.valueOf("Suggestion.active.userId"))),Var.valueOf("username",
        cronapi.screen.Operations.getValueOfField(
        Var.valueOf("Suggestion.active.username"))));
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("warning"),
        Var.valueOf("Já existe sugestão cadastrada com o mesmo nome, foi feito um comentário"));
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.openUrl"),
        Var.valueOf(
        cronapi.util.Operations.getBaseUrl().getObjectAsString() +
        Var.valueOf("#/home/logged/comment?suggestionId=").getObjectAsString() +
        suggestionId.getObjectAsString()), Var.VAR_NULL,
        Var.VAR_NULL,
        Var.VAR_NULL);
    }
    return Var.VAR_NULL;
   }
 }.call();
}

}

