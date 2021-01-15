'use strict'

// when the windows finish loading, execute init function
window.onload = init();

function init() {
	clock();
	setDefaults();

	// Event Listeners
	
	// When a continent option has been chosen or changed
	CONTINENTS_SELECT.addEventListener('change', () => {
		let continent = CONTINENTS_SELECT.value; // get the continent selected
		addCountriesOptions(continent); // update the countries options

		let country = COUNTRIES_SELECT.value; // get the country selected
		updateCountryInfo(continent, country); // update the country information in document
	})

	// When a country option has been chosen or changed
	COUNTRIES_SELECT.addEventListener('change', () => {
		let continent = CONTINENTS_SELECT.value; // get the continent selected
		let country = COUNTRIES_SELECT.value; // get the country selected
		updateCountryInfo(continent, country); // update the country information in document
	})

	// decrease and increase the number of people
	document.querySelector('#decrease').addEventListener('click', ()=> {
		editPeople('decrease');
	})
	
	// decrease and increase the number of people
	document.querySelector('#increase').addEventListener('click', ()=> {
		editPeople('increase');
	})
}

function setDefaults() {
	// add the default option not selectable of the continents list
	CONTINENTS_SELECT.append(new Option('Select a continent', ''));
	CONTINENTS_SELECT[0].setAttribute('disabled', '');
	// add the default option not selectable of the countries list
	COUNTRIES_SELECT.append(new Option('Select a country', ''));
	COUNTRIES_SELECT[0].setAttribute('disabled', '');

	addContinentsOptions();

	// set the start date and end date the system date
	DATE.valueAsDate = new Date();

	// set the default for the people
	PEOPLE.value = 1;
	// set default price
	PRICE.value = 0 + " €";
}

/**
 * Add options to the continent destination select element.
 */
function addContinentsOptions() {
	// loop over each continent in the array
	for (const continent of LOCATIONS.continents) {
		// add the option to the select element
		CONTINENTS_SELECT.append(new Option(continent.name, continent.name));
	}
}

/**
 * Add options to the country destination sleect element, depending on the continent selected.
 * @param {string} continent 
 */
function addCountriesOptions(continent) {
	// remove all the existing countries options unless the first one (the default one)
	while (COUNTRIES_SELECT.options.length > 1) {
		COUNTRIES_SELECT.remove(COUNTRIES_SELECT.options.length - 1);
	}

	let countries = getCountriesOfContinent(continent);

	// check if the continent was found by checking if countries is not empty
	if (countries !== undefined) {
		// loop over each country in the array of countries from the continent
		for (const country of countries) {
			// add the name of the country in the countries select element
			COUNTRIES_SELECT.append(new Option(country.name));
		}
	} else {
		// set the option back to the default
		COUNTRIES_SELECT.value = COUNTRIES_SELECT[0];
	}

	// select the default option as active
	COUNTRIES_SELECT.selectedIndex = 0;
	// remove/clean the price and the country preview
	PRICE.value = 0 + " €";
	DST_PREVIEW.src = '';
}

/**
 * Update the price and image preview in the document depending on the country selected
 * @param {string} continent 
 * @param {stirng} country 
 */
function updateCountryInfo(continent, country) {
	let countries = getCountriesOfContinent(continent);

	// check if the continent was found by checking if countries is not empty
	if (countries !== undefined) {
		// search and get the country
		for (const c of countries) {
			if (c.name === country) {
				country = c;
			}
		}

		// check if the country was found in the array
		if (country instanceof Object) {
			// set the price
			PRICE.value = country.price;
			// set the preview
			DST_PREVIEW.src = country.image;
		} else {
			// remove the price and the country preview
			PRICE.value = 0;
			DST_PREVIEW.src = '';
		}
	} else {
		// set the option back to the default
		COUNTRIES_SELECT.value = COUNTRIES_SELECT[0];
	}
}

/**
 * Search and get the list of countries from a continent
 * @param {string} continent 
 * @return array of countries
 */
function getCountriesOfContinent(continent) {
	let countries; // to store the list of countries fro the selected continent

	// search and get the continent that match the passed as argument
	for (const c of LOCATIONS.continents) {
		if (c.name === continent) {
			countries = c.countries;
		}
	}

	return countries;
}

/**
 * Decrease or increase
 * @param {string} operation decrease or increase
 */
function editPeople(operation) {
	let people = PEOPLE.value; // get the actual value

	// increase or decrease depending on the operation
	if (operation === 'decrease') {
		people--;
	} else if (operation === 'increase') {
		people++;
	}

	// check that minim number posible is 1
	if (people >= 1) PEOPLE.value = people; // change with the new value
}