'use strict'

// elements from the document
let CLOCK = document.querySelector('#clock');

// get the double click event in the clock
CLOCK.addEventListener('dblclick', changeFormat);

// 12h or 24h format for the clock
let format;
// day/night: a.m or p.m
let dn = '';

/**
 * Get the actual time and date and update the clock element in the document every 100 miliseconds
 */
function clock() {
	setInterval(()=> {
		// get the actual date and time
		let now = new Date();

		// get the hour, minutes and seconds
		let h		= now.getHours();
		let m		= now.getMinutes();
		let s		= now.getSeconds();
		// get the year, month and day of month
		let year 	= now.getFullYear();
		let month 	= now.getMonth()+1; // month starts at 0, so increment by 1
		let day		= now.getDate();

		// check if the format is 12h
		if (format === '12h') {
			if (h > 12) h-=12;
			// set AM or PM
			dn = h <= 12 ? 'a.m' : 'p.m';
		} else {
			dn = '';
		}

		// append 0 before if the number is less than 10 to force 2 digits
		h			= h 	< 10 ? '0' + h		: h;
		m			= m 	< 10 ? '0' + m 		: m;
		s			= s 	< 10 ? '0' + s 		: s;
		month 		= month	< 10 ? '0' + month	: month;
		day			= day	< 10 ? '0' + day	: day;

		// update the clock element in the document
		CLOCK.innerHTML = `${h}:${m}:${s} ${dn}<br>${day}/${month}/${year}`;
	}, 100);
}

/**
 * Change clock format from 12h to 24h and viceversa
 */
function changeFormat() {
	format = format === '12h' ? '24h' : '12h';
}