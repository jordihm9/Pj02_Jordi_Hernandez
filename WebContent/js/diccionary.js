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
					'name': 'Algeria',
					'price': 0,
					'image': '/images/countries/algeria.jpg'
				},
				{
					'name': 'Benin',
					'price': 0,
					'image': '/images/countries/benin.jpg'
				},
				{
					'name': 'Cameroon',
					'price': 0,
					'image': '/images/countries/cameroon.jpg'
				},
				{
					'name': 'Egypt',
					'price': 0,
					'image': '/images/countries/egypt.jpg'
				},
				{
					'name': 'Nigeria',
					'price': 0,
					'image': '/images/countries/nigeria.jpg'
				},
				{
					'name': 'Tanzania',
					'price': 0,
					'image': '/images/countries/tanzania.jpg'
				},
			]
		},
		{
			'name': 'Asia',
			'countries': [
				{
					'name': 'Bangladesh',
					'price': 0,
					'image': '/images/countries/bangladesh.jpg'
				},
				{
					'name': 'China',
					'price': 0,
					'image': '/images/countries/china.jpg'
				},
				{
					'name': 'India',
					'price': 0,
					'image': '/images/countries/india.jpg'
				},
				{
					'name': 'Japan',
					'price': 0,
					'image': '/images/countries/japan.jpg'
				},
				{
					'name': 'Thailand',
					'price': 0,
					'image': '/images/countries/thailand.jpg'
				},
				{
					'name': 'Turkey',
					'price': 0,
					'image': '/images/countries/turkey.jpg'
				},
			]
		},
		{
			'name': 'Australia & Oceania',
			'countries': [
				{
					'name': 'Australia',
					'price': 0,
					'image': '/images/countries/australia.jpg'
				},
				{
					'name': 'Fiji',
					'price': 0,
					'image': '/images/countries/fiji.jpg'
				},
				{
					'name': 'New Zeland',
					'price': 0,
					'image': '/images/countries/new-zeland.jpg'
				},
				{
					'name': 'Papua New Guinea',
					'price': 0,
					'image': '/images/countries/papua-new-guinea.jpg'
				},
				{
					'name': 'Solomon Islands',
					'price': 0,
					'image': '/images/countries/solomon-islands.jpg'
				},
				{
					'name': 'Tonga',
					'price': 0,
					'image': '/images/countries/tonga.jpg'
				},
			]
		},
		{
			'name': 'Europe',
			'countries': [
				{
					'name': 'France',
					'price': 0,
					'image': '/images/countries/france.jpg'
				},
				{
					'name': 'Germany',
					'price': 0,
					'image': '/images/countries/germany.jpg'
				},
				{
					'name': 'Italy',
					'price': 0,
					'image': '/images/countries/italy.jpg'
				},
				{
					'name': 'Norway',
					'price': 0,
					'image': '/images/countries/norway.jpg'
				},
				{
					'name': 'Spain',
					'price': 0,
					'image': '/images/countries/spain.jpg'
				},
				{
					'name': 'United Kingdom',
					'price': 0,
					'image': '/images/countries/united-kingdom.jpg'
				},
			]
		},
		{
			'name': 'North America',
			'countries': [
				{
					'name': 'Canada',
					'price': 0,
					'image': '/images/countries/canada.jpg'
				},
				{
					'name': 'Costa Rica',
					'price': 0,
					'image': '/images/countries/costa-rica.jpg'
				},
				{
					'name': 'Honduras',
					'price': 0,
					'image': '/images/countries/honduras.jpg'
				},
				{
					'name': 'Jamaica',
					'price': 0,
					'image': '/images/countries/jamaica.jpg'
				},
				{
					'name': 'Mexico',
					'price': 0,
					'image': '/images/countries/mexico.jpg'
				},
				{
					'name': 'U.S.A',
					'price': 0,
					'image': '/images/countries/usa.jpg'
				},
			]
		},
		{
			'name': 'South America',
			'countries': [
				{
					'name': 'Argentina',
					'price': 0,
					'image': '/images/countries/argentina.jpg'
				},
				{
					'name': 'Brazil',
					'price': 0,
					'image': '/images/countries/brazil.jpg'
				},
				{
					'name': 'Chile',
					'price': 0,
					'image': '/images/countries/chile.jpg'
				},
				{
					'name': 'Peru',
					'price': 0,
					'image': '/images/countries/peru.jpg'
				},
				{
					'name': 'Uruguay',
					'price': 0,
					'image': '/images/countries/uruguay.jpg'
				},
				{
					'name': 'Venezuela',
					'price': 0,
					'image': '/images/countries/venezuela.jpg'
				},
			]
		}
	]
};