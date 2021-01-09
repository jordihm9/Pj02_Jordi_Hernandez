'use strict'

/**
 * Check if the value from the element given is empty or not.
 * @param {object} e element from the document
 * @param {string} name name of the element to show with the error if is not empty
 * @return {string} value from the element if it not empty
 */
function checkRequired(e, name) {
    if (e.value === '' || e.value === undefined) throw new Error(name + " is required.");
    return e.value;
}

/**
 * Check if the DNI is not empty and follow the format:
 * 8 digits (0-9) and an uppercase letter (A-Z)
 * @return {string} NIF
 */
function checkDNI() {
	let nif = checkRequired(DNI, 'DNI');
	// set with Regex the format
	let format = /^[0-9]{8}[A-Z]{1}$/;
	// test the format
	if (!format.test(nif)) {
		throw new Error("DNI must have 8 digits and an uppercase letter.");
	}
	return nif;
}

/**
 * Check if the phone is not empty
 * Remove any whitespace in between and check it has 9 digits
 * @return {string} phone
 */
function checkPhone() {
	let phone = checkRequired(PHONE, 'Phone');
	// remove any white spaces in between
	phone = phone.replace(/\s/g, '');
	// set with Regex the format
	let format = /^[0-9]{9}$/;
	// test the format
	if (!format.test(phone)) {
		throw new Error("Phone must have 9 digits.");
	}
	return phone;
}

/**
 * Check if both destination select inputs are not empty (continent and country)
 * @return {object} object with 2 properties: continent and country
 */
function checkDestination() {
	return {
		'continent': checkRequired(CONTINENTS_SELECT, 'Continent'),
		'country': checkRequired(COUNTRIES_SELECT, 'Country'),
	}
}
