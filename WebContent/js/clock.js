'use strict'

// elements from the document
let CLOCK = document.querySelector('#clock');

// get the double click event in the clock
CLOCK.addEventListener('dblclick', changeFormat);

// 12h or 24h format for the clock
let format;

/**
 * Get the actual time and date and update the clock element in the document every 100 miliseconds
 */
function clock() {
	setInterval(()=> {
		// get the actual date and time
		let now = new Date();

		// get the hour, minutes and seconds, append a 0 before if the number is less than 10 to force always 2 digits
		let h = now.getHours()		< 10 ? '0' + now.getHours()		: now.getHours();
		let m = now.getMinutes() 	< 10 ? '0' + now.getMinutes() 	: now.getMinutes();
		let s = now.getSeconds()	< 10 ? '0' + now.getSeconds() 	: now.getSeconds();

		// get the year, month and day of week
		let year 	= now.getFullYear();
		let month 	= now.getMonth();
		let day		= now.getDate();

		// update the clock element in the document
		CLOCK.innerHTML = `${h}:${m}:${s}<br>${day}/${month}/${year}`;
	}, 100);
}

/**
 * Change clock format from 12h to 24h and viceversa
 */
function changeFormat() {
	console.log('Changing clock format');
}