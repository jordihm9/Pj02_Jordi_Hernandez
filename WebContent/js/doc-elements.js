'use strict'

// Save in variables most used elements from the document
// Form Inputs
// client side
const CLIENT_NAME 		= document.querySelector('#clientName');
const CLIENT_LASTNAME	= document.querySelector('#clientLastname');
const DNI 				= document.querySelector('#dni');
const PHONE 				= document.querySelector('#phone');
// reservation side
const DATE				= document.querySelector('#date');
const CONTINENTS_SELECT	= document.querySelector('#continentDst');
const COUNTRIES_SELECT 	= document.querySelector('#countryDst');
const PEOPLE			= document.querySelector('#people');
const PRICE				= document.querySelector('#price');
const DST_PREVIEW		= document.querySelector('#destination-preview img');