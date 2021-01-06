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
					'price': 0,
					'image': 'images/countries/egypt.jpg'
				},
				{
					'name': 'Nigeria',
					'price': 0,
					'image': 'images/countries/nigeria.jpg'
				},
				{
					'name': 'Tanzania',
					'price': 0,
					'image': 'images/countries/tanzania.jpg'
				},
			]
		},
		{
			'name': 'Asia',
			'countries': [
				{
					'name': 'Bangladesh',
					'price': 0,
					'image': 'images/countries/bangladesh.jpg'
				},
				{
					'name': 'China',
					'price': 0,
					'image': 'images/countries/china.jpg'
				},
				{
					'name': 'India',
					'price': 0,
					'image': 'images/countries/india.jpg'
				},
				{
					'name': 'Japan',
					'price': 0,
					'image': 'images/countries/japan.jpg'
				},
				{
					'name': 'Turkey',
					'price': 0,
					'image': 'images/countries/turkey.jpg'
				},
			]
		},
		{
			'name': 'Australia & Oceania',
			'countries': [
				{
					'name': 'Australia',
					'price': 0,
					'image': 'images/countries/australia.jpg'
				},
				{
					'name': 'New Zealand',
					'price': 0,
					'image': 'images/countries/new-zealand.jpg'
				}
			]
		},
		{
			'name': 'Europe',
			'countries': [
				{
					'name': 'France',
					'price': 0,
					'image': 'images/countries/france.jpg'
				},
				{
					'name': 'Germany',
					'price': 0,
					'image': 'images/countries/germany.jpg'
				},
				{
					'name': 'Italy',
					'price': 0,
					'image': 'images/countries/italy.jpg'
				},
				{
					'name': 'Norway',
					'price': 0,
					'image': 'images/countries/norway.jpg'
				},
				{
					'name': 'Spain',
					'price': 0,
					'image': 'images/countries/spain.jpg'
				},
				{
					'name': 'United Kingdom',
					'price': 0,
					'image': 'images/countries/united-kingdom.jpg'
				},
			]
		},
		{
			'name': 'North America',
			'countries': [
				{
					'name': 'Canada',
					'price': 0,
					'image': 'images/countries/canada.jpg'
				},
				{
					'name': 'Mexico',
					'price': 0,
					'image': 'images/countries/mexico.jpg'
				},
				{
					'name': 'U.S.A',
					'price': 0,
					'image': 'images/countries/usa.jpg'
				},
			]
		},
		{
			'name': 'South America',
			'countries': [
				{
					'name': 'Brazil',
					'price': 0,
					'image': 'images/countries/brazil.jpg'
				},
				{
					'name': 'Peru',
					'price': 0,
					'image': 'images/countries/peru.jpg'
				},
			]
		}
	]
};