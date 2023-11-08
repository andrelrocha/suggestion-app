window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.CompletarSuggestionId = window.blockly.js.blockly.CompletarSuggestionId || {};

/**
 * @function completeSuggestionID
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 08/11/2023, 14:37:29
 *
 */
window.blockly.js.blockly.CompletarSuggestionId.completeSuggestionIDArgs = [];
window.blockly.js.blockly.CompletarSuggestionId.completeSuggestionID = async function() {

  //
  this.cronapi.screen.setVisibility("suggestionId", 'false');
  //
  this.cronapi.screen.changeValueOfField("Comment.active.suggestionId", this.cronapi.screen.getValueOfField("params.suggestionId"));
  //
  this.cronapi.screen.changeValueOfField("vars.textarea6110", '');
}
