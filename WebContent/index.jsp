<!-- JSP -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--  IMPORT JSTL LIBRARY -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
	<title>Wonderfull Travels</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- JAVASCRIPT -->
	<script src="js/diccionary.js"></script>
	<script src="js/doc-elements.js" defer></script>
	<script src="js/clock.js" defer></script>
	<script src="js/validations.js" defer></script>
	<script src="js/app.js" defer></script>
	<!-- STYLES -->
	<link rel="stylesheet" href="css/style.css">
	<!-- FONTS -->
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<!-- JetBrains Mono: -->
	<link href="https://fonts.googleapis.com/css2?family=JetBrains+Mono&display=swap" rel="stylesheet">
	<!-- AbeeZee: -->
	<link href="https://fonts.googleapis.com/css2?family=ABeeZee&display=swap" rel="stylesheet">
</head>

<body>
	<!-- HEADER -->
	<header>
		<nav>
			<h1 class="brand">Wonderfull Travels</h1>
			<!-- CLOCK -->
			<span id="clock" title="Double click to change format 12/24h"></span>
		</nav>
	</header>

	<!-- BODY -->
	<main>
		<!-- RESERVATION FORM -->
		<section id="reservation-form">
			<form method="post">
				<!-- CLIENT INFORMATION -->
				<fieldset id="client-info">
					<legend>Client Information</legend>
					<div>
						<div>
							<label>Existing client</label>
							<input type="checkbox" name="clientExists" id="clientExists">
						</div>
					</div>
					<div id="existing-client">
						<div class="input required">
							<label for="client">Client</label>
							<select name="client" id="client">
								<option disabled>-- Select existing client --</option>
								<c:forEach var="client" items="${clients}">
									<option value="${client.id}">${client.lastname}, ${client.name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<br><hr>
					<div id="new-client">
						<div class="inputs-group">
							<div class="input required">
								<label for="clientName">Name</label>
								<input type="text" name="clientName" id="clientName" autocomplete="off">
							</div>
							<div class="input required">
								<label for="clientLastname">Lastname</label>
								<input type="text" name="clientLastname" id="clientLastname" autocomplete="off">
							</div>
						</div>
						<div class="inputs-group">
							<div class="input required">
								<label for="dni">DNI</label>
								<input type="text" name="dni" id="dni" autocomplete="off">
							</div>
							<div class="input required">
								<label for="phone">Phone</label>
								<input type="text" name="phone" id="phone" autocomplete="off">
							</div>
						</div>
					</div>
				</fieldset>

				<!-- RESERVATION INFORMATION -->
				<fieldset id="reservation-info">
					<legend>Reservation Information</legend>
					<div>
						<div class="input required">
							<label for="startDate">Date</label>
							<input type="date" name="date" id="date">
						</div>
						<div class="inputs-group">
							<div class="input required">
								<label>Destination</label>
								<div id="destination" class="input">
									<select name="continentDst" id="continentDst"></select>
									<select name="countryDst" id="countryDst"></select>
								</div>
							</div>
						</div>
						<div class="input">
							<div id="numOfPeople" class="inputs-group">
								<div id="decrease" class="btn">-</div>
								<input type="text" name="people" id="people" readonly tabindex="-1">
								<div id="increase" class="btn">+</div>
							</div>
						</div>
						<div>
							<label for="price">Total Price</label>
							<input type="text" id="total-price" disabled>
							<input type="text" name="price" id="price" hidden>
						</div>
					</div>

					<!-- DESTINATION IMAGE PREVIEW -->
					<div id="destination-preview">
						<img alt="destination preview"></img>
					</div>
				</fieldset>

				<!-- SUBMIT -->
				<div id="submit">
					<input type="submit" name="saveReservation" value="Save" class="btn">
				</div>
			</form>
		</section>

		<!-- LIST OF RESERVATIONS -->
		<section id="reservation-list"></section>

	</main>

	<!-- FOOTER -->
	<footer></footer>

</body>

</html>