# GoOverlayDebug
This is a debug plugin for the GoOverlay app. This app does the following
* Sends a toast message for the following intents
  * net.waterfoul.gooverlay.pokemon_go.open
  * net.waterfoul.gooverlay.pokemon_go.close
  * net.waterfoul.gooverlay.pokemon_select.open
  * net.waterfoul.gooverlay.pokemon_select.close
  * net.waterfoul.gooverlay.single_pokemon.open
  * net.waterfoul.gooverlay.single_pokemon.close
* Sends a perodic toast with the scraped pokemon info between getting net.waterfoul.gooverlay.single_pokemon.open and net.waterfoul.gooverlay.single_pokemon.close
