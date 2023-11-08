window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ConsultaUser = window.blockly.js.blockly.ConsultaUser || {};

/**
 * @function getUserLogin
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 08/11/2023, 11:34:03
 *
 */
window.blockly.js.blockly.ConsultaUser.getUserLoginArgs = [];
window.blockly.js.blockly.ConsultaUser.getUserLogin = async function() {

  //
  console.log('TESTE');
  //
  console.log(this.cronapi.util.getUser());
  //
  this.cronapi.screen.changeValueOfField("Suggestion.active.user", this.cronapi.util.getUser());
}
