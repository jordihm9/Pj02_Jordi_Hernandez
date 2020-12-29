'use strict'

// Elements from the document:
const CONTINENTS_SELECT = document.querySelector('#continentDst');
const COUNTRIES_SELECT = document.querySelector('#countryDst');

// when the windows finish loading, execute init function
window.onload = init();

function init() {
	clock();
	addContinentsOptions();
}

/**
 * Add options to the continent destination select element.
 */
function addContinentsOptions() {
	// loop over each continent in the array
	for (let continent of LOCATIONS.continents) {
		// add the option to the select element
		CONTINENTS_SELECT.options[CONTINENTS_SELECT.options.length] = new Option(continent.name, continent.name);
	}
}