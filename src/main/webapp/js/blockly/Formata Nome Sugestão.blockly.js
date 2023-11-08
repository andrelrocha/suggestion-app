window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.FormataNomeSugestao = window.blockly.js.blockly.FormataNomeSugestao || {};

/**
 * @function formartSuggestionName
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 08/11/2023, 13:05:50
 *
 */
window.blockly.js.blockly.FormataNomeSugestao.formartSuggestionNameArgs = [];
window.blockly.js.blockly.FormataNomeSugestao.formartSuggestionName = async function() {
 var nomeSugestao, nomeNovo, nomeAntigo;
  //
  nomeAntigo = this.cronapi.screen.getValueOfField("Suggestion.active.suggestionName");
  //
  nomeNovo = String(this.cronapi.text.replaceAll(nomeAntigo, '\\b\\w\n', '-', ''));
  //
  this.cronapi.screen.changeValueOfField("Suggestion.active.text", nomeNovo);
  //
  console.log(nomeAntigo);
  //
  console.log(nomeNovo);
}
