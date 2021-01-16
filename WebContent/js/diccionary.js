'use strict'

const DAYSOFWEEK = [
	'Saturday',
	'Monday',
	'Tuesday',
	'Wednesday',
	'Thursday',
	'Friday',
	'Sunday'
];

const MONTHS = [
	'January',
	'February',
	'March',
	'April',
	'May',
	'June',
	'July',
	'August',
	'September',
	'October',
	'November',
	'December'
];

const LOCATIONS = {
	'continents': [
		{
			'name': 'Africa',
			'countries': [
				{
					'name': 'Egypt',
					'price': 462.00,
					'image': 'images/countries/egypt.jpg'
				},
				{
					'name': 'Nigeria',
					'price': 246.00,
					'image': 'images/countries/nigeria.jpg'
				},
				{
					'name': 'Tanzania',
					'price': 383.00,
					'image': 'images/countries/tanzania.jpg'
				},
			]
		},
		{
			'name': 'Asia',
			'countries': [
				{
					'name': 'Bangladesh',
					'price': 555.00,
					'image': 'images/countries/bangladesh.jpg'
				},
				{
					'name': 'China',
					'price': 399.00,
					'image': 'images/countries/china.jpg'
				},
				{
					'name': 'India',
					'price': 137.00,
					'image': 'images/countries/india.jpg'
				},
				{
					'name': 'Japan',
					'price': 751.00,
					'image': 'images/countries/japan.jpg'
				},
				{
					'name': 'Turkey',
					'price': 488.00,
					'image': 'images/countries/turkey.jpg'
				},
			]
		},
		{
			'name': 'Australia & Oceania',
			'countries': [
				{
					'name': 'Australia',
					'price': 945.00,
					'image': 'images/countries/australia.jpg'
				},
				{
					'name': 'New Zealand',
					'price': 1031.00,
					'image': 'images/countries/new-zealand.jpg'
				}
			]
		},
		{
			'name': 'Europe',
			'countries': [
				{
					'name': 'France',
					'price': 110,
					'image': 'images/countries/france.jpg'
				},
				{
					'name': 'Germany',
					'price': 325.00,
					'image': 'images/countries/germany.jpg'
				},
				{
					'name': 'Italy',
					'price': 642.00,
					'image': 'images/countries/italy.jpg'
				},
				{
					'name': 'Norway',
					'price': 1256.00,
					'image': 'images/countries/norway.jpg'
				},
				{
					'name': 'Spain',
					'price': 185.00,
					'image': 'images/countries/spain.jpg'
				},
				{
					'name': 'United Kingdom',
					'price': 512.00,
					'image': 'images/countries/united-kingdom.jpg'
				},
			]
		},
		{
			'name': 'North America',
			'countries': [
				{
					'name': 'Canada',
					'price': 963.00,
					'image': 'images/countries/canada.jpg'
				},
				{
					'name': 'Mexico',
					'price': 368.00,
					'image': 'images/countries/mexico.jpg'
				},
				{
					'name': 'U.S.A',
					'price': 1269.00,
					'image': 'images/countries/usa.jpg'
				},
			]
		},
		{
			'name': 'South America',
			'countries': [
				{
					'name': 'Brazil',
					'price': 644.00,
					'image': 'images/countries/brazil.jpg'
				},
				{
					'name': 'Peru',
					'price': 547.00,
					'image': 'images/countries/peru.jpg'
				},
			]
		}
	]
};