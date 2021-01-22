'use strict'

CLIENT_NAME.addEventListener('blur', ()=> {
	try {
		CLIENT_NAME.classList.remove('error'); // remove the class 'error'
		return checkName();
	}
	catch (error) {
		console.log(error.message); // print error in console
		CLIENT_NAME.classList.add('error'); // add the class 'error' to style it
	}
})

CLIENT_LASTNAME.addEventListener('blur', ()=> {
	try {
		CLIENT_LASTNAME.classList.remove('error'); // remove the class 'error'
		return checkLastname();
	}
	catch (error) {
		console.log(error.message); // print error in console
		CLIENT_LASTNAME.classList.add('error'); // add the class 'error' to style it
	}
})

DNI.addEventListener('blur', ()=> {
	try {
		DNI.classList.remove('error');
		return checkDNI();
	}
	catch (error) {
		console.log(error.message);
		DNI.classList.add('error');
	}
})

PHONE.addEventListener('blur', ()=> {
	try {
		PHONE.classList.remove('error');
		return checkPhone();
	}
	catch (error) {
		console.log(error.message);
		PHONE.classList.add('error');
	}
})

DATE.addEventListener('blur', ()=> {
	try {
		DATE.classList.remove('error');
		return checkDate();
	}
	catch (error) {
		console.log(error.message)
		DATE.classList.add('error');
	}
})

CONTINENTS_SELECT.addEventListener('blur', ()=> {
	try {
		CONTINENTS_SELECT.classList.remove('error');
		return checkContinent();
	}
	catch (error) {
		console.log(error.message);
		CONTINENTS_SELECT.classList.add('error');
	}
})

COUNTRIES_SELECT.addEventListener('blur', ()=> {
	try {
		COUNTRIES_SELECT.classList.remove('error');
		return checkCountry();
	}
	catch (error) {
		console.log(error.message);
		COUNTRIES_SELECT.classList.add('error');
	}
})


DISCOUNT.addEventListener('change', ()=> {
	try {
		DISCOUNT.classList.remove('error');
		return checkDiscount();
	}
	catch (error) {
		console.log(error.message);
		DISCOUNT.classList.add('error');
	}	
})

/**
 * Check every input from the form
 * If the value is correct keep the value
 * @return {boolean} if all the inputs follow the requirements
 */
function validateAll() {
	let allOk = true;

	if (!CLIENT_EXISTS.checked) {
		try { CLIENT_NAME.value 	= checkName(); 		} catch (error) { CLIENT_NAME.classList.add('error'); 		allOk = false; }
		try { CLIENT_LASTNAME.value = checkLastname(); 	} catch (error) { CLIENT_LASTNAME.classList.add('error'); 	allOk = false; }
		try { DNI.value 			= checkDNI() 		} catch (error) { DNI.classList.add('error'); 				allOk = false; }
		try { PHONE.value 			= checkPhone(); 	} catch (error) { PHONE.classList.add('error'); 			allOk = false; }
	}

	try { DATE.valueAsDate 			= checkDate(); 		} catch (error) { DATE.classList.add('error'); 				allOk = true; }
	try { CONTINENTS_SELECT.value 	= checkContinent(); } catch (error) { CONTINENTS_SELECT.classList.add('error'); allOk = false; }
	try { COUNTRIES_SELECT.value 	= checkCountry(); 	} catch (error) { COUNTRIES_SELECT.classList.add('error');	allOk = false; }
	try { DISCOUNT.value 			= checkDiscount(); 	} catch (error) { DISCOUNT.classList.add('error'); 			allOk = false; }
	
	return allOk;
}

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
 * Check the name is not empty
 * @return {string} name
 */
function checkName() {
	return checkRequired(CLIENT_NAME, 'Name');
}

/**
 * Check the lastname is not empty
 * @return {string} lastname
 */
function checkLastname() {
	return checkRequired(CLIENT_LASTNAME, 'Name');
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
 * Check the date is not empty
 * @return {Date} date
 */
function checkDate() {
	checkRequired(DATE, 'Date');
	return DATE.valueAsDate;
}

/**
 * Check if X is not empty
 * @return {string} continent
 */
function checkContinent() {
	return checkRequired(CONTINENTS_SELECT, "Continent");
}

/**
 * Check if X is not empty
 * @return {string} country
 */
function checkCountry() {
	return checkRequired(COUNTRIES_SELECT, "Country");
}
/**
 * Check if the discount is a number and is not less than 0 or bigger than 50
 * @return {Number} discount
 */
function checkDiscount() {
	// get the value and cast it to type Number
	let discount = Number(checkRequired(DISCOUNT, "Discount"));
	// check is a number
	if (isNaN(discount)) {
		throw new Error("Discount must be a number");
	}
	if (discount < 0 || discount > 50) {
		throw new Error("Cannot apply a negative discount or bigger than 50%");
	}

	updateTotalPrice();
	return discount;
}