package com.sainsburys.scrapper;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class MainTest {

	@Test
	public void testTotalAmount() throws IOException {

		List<Product> test = SainsburysApp.getProducts();

		double total = 39.5;

		double valueue = SainsburysApp.getTotalPrice(test);
		assertEquals(total, valueue, 0);
	}

	
	@Test
	public void testJSONConverter() throws IOException {

		List<Product> test = SainsburysApp.getProducts();


		String valueue = SainsburysApp.transformToJSON(test);
		assertEquals("[ {\n" + 
				"  \"title\" : \"Sainsbury's Strawberries 400g\",\n" + 
				"  \"unit_price\" : \"1.75\",\n" + 
				"  \"kcal_per_100g\" : \"Typical Values Per 100g % based on RI for Average Adult Energy 140kJ - 33kcal 2% Fat <0.5g - Saturates <0.1g - Carbohydrate 6.1g 2% Total Sugars 6.1g 7% Fibre 1.0g - Protein 0.6g 1% Salt <0.01g -\",\n" + 
				"  \"description\" : \"by Sainsbury's strawberries\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's Blueberries 200g\",\n" + 
				"  \"unit_price\" : \"1.75\",\n" + 
				"  \"kcal_per_100g\" : \"Per 100g Per 100g % based on RI for Average Adult Energy 189kJ - 45kcal 2% Fat <0.5g - Saturates <0.1g - Carbohydrate 9.1g 4% Total Sugars 9.1g 10% Fibre 1.5g - Protein 0.9g 2% Salt <0.01g -\",\n" + 
				"  \"description\" : \"by Sainsbury's blueberries\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's Raspberries 225g\",\n" + 
				"  \"unit_price\" : \"1.75\",\n" + 
				"  \"kcal_per_100g\" : \"Per 100g % based on RI for Average Adult Energy 133kJ - 32kcal 2% Fat <0.5g - Saturates <0.1g - Carbohydrate 4.6g 2% Total Sugars 4.6g 5% Fibre 2.5g - Protein 1.4g 3% Salt <0.01g -\",\n" + 
				"  \"description\" : \"by Sainsbury's raspberries\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's Blackberries, Sweet 150g\",\n" + 
				"  \"unit_price\" : \"1.50\",\n" + 
				"  \"kcal_per_100g\" : \"Typical Values Per 100g % based on RI for Average Adult Energy 134kJ - 32kcal 2% Fat <0.5g - Saturates <0.1g - Carbohydrate 5.1g 2% Total Sugars 5.1g 6% Fibre 3.1g - Protein 0.9g 2% Salt <0.01g -\",\n" + 
				"  \"description\" : \"by Sainsbury's blackberries\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's Blueberries 400g\",\n" + 
				"  \"unit_price\" : \"3.25\",\n" + 
				"  \"kcal_per_100g\" : \"Typical Values Per 100g % based on RI for Average Adult Energy 189kJ - 45kcal 2% Fat <0.5g - Saturates <0.1g - Carbohydrate 9.1g 4% Total Sugars 9.1g 10% Fibre 1.5g - Protein 0.9g 2% Salt <0.01g -\",\n" + 
				"  \"description\" : \"by Sainsbury's blueberries\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's Blueberries, SO Organic 150g\",\n" + 
				"  \"unit_price\" : \"2.00\",\n" + 
				"  \"kcal_per_100g\" : \"Per 100g % based on RI for Average Adult Energy 189kJ - 45kcal 2% Fat <0.5g - Saturates <0.1g - Carbohydrate 9.1g 4% Total Sugars 9.1g 10% Fibre 1.5g - Protein 0.9g 2% Salt <0.01g -\",\n" + 
				"  \"description\" : \"So Organic blueberries Plump and Refreshing\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's Raspberries, Taste the Difference 150g\",\n" + 
				"  \"unit_price\" : \"2.50\",\n" + 
				"  \"kcal_per_100g\" : \"Per 100g % based on RI for Average Adult Energy 133kJ - 32kcal 2% Fat <0.5g - Saturates <0.1g - Carbohydrate 4.6g 2% Total Sugars 4.6g 5% Fibre 2.5g - Protein 1.4g 3% Salt <0.01g -\",\n" + 
				"  \"description\" : \"Ttd raspberries\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's Cherries 400g\",\n" + 
				"  \"unit_price\" : \"2.50\",\n" + 
				"  \"kcal_per_100g\" : \"Typical Values Per 100g % based on RI for Average Adult Energy 222kJ - 52kcal 3% Fat <0.5g - Saturates <0.1g - Carbohydrate 11.5g 4% Total Sugars 11.5g 13% Fibre 0.9g - Protein 0.9g 2% Salt <0.01g -\",\n" + 
				"  \"description\" : \"by Sainsbury's Family Cherry Punnet\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's Blackberries, Tangy 150g\",\n" + 
				"  \"unit_price\" : \"1.50\",\n" + 
				"  \"kcal_per_100g\" : \"Per 100g per 100g serving % based on RI for Average Adult Energy 134kJ 0kJ - 32kcal 0kcal 2% Fat <0.5g <0.5g - Saturates <0.1g <0.1g - Carbohydrate 5.1g <0.5g 2% Total Sugars 5.1g <0.5g 6% Fibre 3.1g <0.5g - Protein 0.9g <0.5g 2% Salt <0.01g <0.01g -\",\n" + 
				"  \"description\" : \"by Sainsbury's blackberries\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's Strawberries, Taste the Difference 300g\",\n" + 
				"  \"unit_price\" : \"2.50\",\n" + 
				"  \"kcal_per_100g\" : \"Typical Values Per 100g Per serving % based on RI for Average Adult Energy 140kJ 112kJ - 33kcal 27kcal 1% Fat <0.5g <0.5g - Saturates <0.1g <0.1g - Carbohydrate 6.1g 4.9g 2% Total Sugars 6.1g 4.9g 5% Fibre 1.0g 0.8g - Protein 0.6g <0.5g - Salt <0.01g <0.01g -\",\n" + 
				"  \"description\" : \"Ttd strawberries\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's Cherry Punnet 200g\",\n" + 
				"  \"unit_price\" : \"1.50\",\n" + 
				"  \"kcal_per_100g\" : \"(as sold) per 100g % adult RI per 100g adult RI Energy kJ 222 - 8400 Energy kcal 52 3% 2000 Fat <0.5g <1% 70g of which saturates <0.1g <1% 20g Carbohydrate 11.5g 4% 260g of which sugars 11.5g 13% 90g of which starch <0.5g - - Fibre 0.9g - - Protein 0.9g 2% 50g Salt <0.01g <1% 6g\",\n" + 
				"  \"description\" : \"Description Cherries Succulent and sweet 1 of 5 a-day 10 cherries Class I\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's Mixed Berries 300g\",\n" + 
				"  \"unit_price\" : \"3.50\",\n" + 
				"  \"kcal_per_100g\" : null,\n" + 
				"  \"description\" : \"by Sainsbury's mixed berries\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's Mixed Berry Twin Pack 200g\",\n" + 
				"  \"unit_price\" : \"2.75\",\n" + 
				"  \"kcal_per_100g\" : null,\n" + 
				"  \"description\" : \"Description Mixed Berries 1 of 5 a-day 80g serving Class I Raspberries grown in Morocco Blueberries grown in Peru\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's Redcurrants 150g\",\n" + 
				"  \"unit_price\" : \"2.50\",\n" + 
				"  \"kcal_per_100g\" : \"Typical values Per 100g % based on RI for Average Adult Energy 300kJ - 71kcal 4% Fat <0.5g - Saturates <0.1g - Carbohydrate 13.8g 5% Total Sugars 7.4g 8% Starch 6.4g - Fibre 4.3g - Protein 1.4g 3% Salt <0.01g -\",\n" + 
				"  \"description\" : \"by Sainsbury's redcurrants\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's Cherry Punnet, Taste the Difference 200g\",\n" + 
				"  \"unit_price\" : \"2.50\",\n" + 
				"  \"kcal_per_100g\" : \"Typical Values Per 100g % based on RI for Average Adult Energy 203kJ - 48kcal 2% Fat <0.5g - Saturates <0.1g - Carbohydrate 11.5g 4% Total Sugars 11.5g 13% Fibre 1.5g - Protein 0.9g 2% Salt 0.00g -\",\n" + 
				"  \"description\" : \"Cherry Punnet\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's Blackcurrants 150g\",\n" + 
				"  \"unit_price\" : \"1.75\",\n" + 
				"  \"kcal_per_100g\" : null,\n" + 
				"  \"description\" : \"Description Union Flag\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's British Cherry & Strawberry Pack 600g\",\n" + 
				"  \"unit_price\" : \"4.00\",\n" + 
				"  \"kcal_per_100g\" : null,\n" + 
				"  \"description\" : \"Description British Cherry & Strawberry Mixed Pack 1 of 5 a-day - 80g serving Class I Union Flag\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's Strawberries 400g\",\n" + 
				"  \"unit_price\" : \"1.75\",\n" + 
				"  \"kcal_per_100g\" : \"Typical Values Per 100g % based on RI for Average Adult Energy 140kJ - 33kcal 2% Fat <0.5g - Saturates <0.1g - Carbohydrate 6.1g 2% Total Sugars 6.1g 7% Fibre 1.0g - Protein 0.6g 1% Salt <0.01g -\",\n" + 
				"  \"description\" : \"by Sainsbury's strawberries\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's Blueberries 200g\",\n" + 
				"  \"unit_price\" : \"1.75\",\n" + 
				"  \"kcal_per_100g\" : \"Per 100g Per 100g % based on RI for Average Adult Energy 189kJ - 45kcal 2% Fat <0.5g - Saturates <0.1g - Carbohydrate 9.1g 4% Total Sugars 9.1g 10% Fibre 1.5g - Protein 0.9g 2% Salt <0.01g -\",\n" + 
				"  \"description\" : \"by Sainsbury's blueberries\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's Raspberries 225g\",\n" + 
				"  \"unit_price\" : \"1.75\",\n" + 
				"  \"kcal_per_100g\" : \"Per 100g % based on RI for Average Adult Energy 133kJ - 32kcal 2% Fat <0.5g - Saturates <0.1g - Carbohydrate 4.6g 2% Total Sugars 4.6g 5% Fibre 2.5g - Protein 1.4g 3% Salt <0.01g -\",\n" + 
				"  \"description\" : \"by Sainsbury's raspberries\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's Blackberries, Sweet 150g\",\n" + 
				"  \"unit_price\" : \"1.50\",\n" + 
				"  \"kcal_per_100g\" : \"Typical Values Per 100g % based on RI for Average Adult Energy 134kJ - 32kcal 2% Fat <0.5g - Saturates <0.1g - Carbohydrate 5.1g 2% Total Sugars 5.1g 6% Fibre 3.1g - Protein 0.9g 2% Salt <0.01g -\",\n" + 
				"  \"description\" : \"by Sainsbury's blackberries\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's Blueberries 400g\",\n" + 
				"  \"unit_price\" : \"3.25\",\n" + 
				"  \"kcal_per_100g\" : \"Typical Values Per 100g % based on RI for Average Adult Energy 189kJ - 45kcal 2% Fat <0.5g - Saturates <0.1g - Carbohydrate 9.1g 4% Total Sugars 9.1g 10% Fibre 1.5g - Protein 0.9g 2% Salt <0.01g -\",\n" + 
				"  \"description\" : \"by Sainsbury's blueberries\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's Blueberries, SO Organic 150g\",\n" + 
				"  \"unit_price\" : \"2.00\",\n" + 
				"  \"kcal_per_100g\" : \"Per 100g % based on RI for Average Adult Energy 189kJ - 45kcal 2% Fat <0.5g - Saturates <0.1g - Carbohydrate 9.1g 4% Total Sugars 9.1g 10% Fibre 1.5g - Protein 0.9g 2% Salt <0.01g -\",\n" + 
				"  \"description\" : \"So Organic blueberries Plump and Refreshing\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's Raspberries, Taste the Difference 150g\",\n" + 
				"  \"unit_price\" : \"2.50\",\n" + 
				"  \"kcal_per_100g\" : \"Per 100g % based on RI for Average Adult Energy 133kJ - 32kcal 2% Fat <0.5g - Saturates <0.1g - Carbohydrate 4.6g 2% Total Sugars 4.6g 5% Fibre 2.5g - Protein 1.4g 3% Salt <0.01g -\",\n" + 
				"  \"description\" : \"Ttd raspberries\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's Cherries 400g\",\n" + 
				"  \"unit_price\" : \"2.50\",\n" + 
				"  \"kcal_per_100g\" : \"Typical Values Per 100g % based on RI for Average Adult Energy 222kJ - 52kcal 3% Fat <0.5g - Saturates <0.1g - Carbohydrate 11.5g 4% Total Sugars 11.5g 13% Fibre 0.9g - Protein 0.9g 2% Salt <0.01g -\",\n" + 
				"  \"description\" : \"by Sainsbury's Family Cherry Punnet\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's Blackberries, Tangy 150g\",\n" + 
				"  \"unit_price\" : \"1.50\",\n" + 
				"  \"kcal_per_100g\" : \"Per 100g per 100g serving % based on RI for Average Adult Energy 134kJ 0kJ - 32kcal 0kcal 2% Fat <0.5g <0.5g - Saturates <0.1g <0.1g - Carbohydrate 5.1g <0.5g 2% Total Sugars 5.1g <0.5g 6% Fibre 3.1g <0.5g - Protein 0.9g <0.5g 2% Salt <0.01g <0.01g -\",\n" + 
				"  \"description\" : \"by Sainsbury's blackberries\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's Strawberries, Taste the Difference 300g\",\n" + 
				"  \"unit_price\" : \"2.50\",\n" + 
				"  \"kcal_per_100g\" : \"Typical Values Per 100g Per serving % based on RI for Average Adult Energy 140kJ 112kJ - 33kcal 27kcal 1% Fat <0.5g <0.5g - Saturates <0.1g <0.1g - Carbohydrate 6.1g 4.9g 2% Total Sugars 6.1g 4.9g 5% Fibre 1.0g 0.8g - Protein 0.6g <0.5g - Salt <0.01g <0.01g -\",\n" + 
				"  \"description\" : \"Ttd strawberries\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's Cherry Punnet 200g\",\n" + 
				"  \"unit_price\" : \"1.50\",\n" + 
				"  \"kcal_per_100g\" : \"(as sold) per 100g % adult RI per 100g adult RI Energy kJ 222 - 8400 Energy kcal 52 3% 2000 Fat <0.5g <1% 70g of which saturates <0.1g <1% 20g Carbohydrate 11.5g 4% 260g of which sugars 11.5g 13% 90g of which starch <0.5g - - Fibre 0.9g - - Protein 0.9g 2% 50g Salt <0.01g <1% 6g\",\n" + 
				"  \"description\" : \"Description Cherries Succulent and sweet 1 of 5 a-day 10 cherries Class I\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's Mixed Berries 300g\",\n" + 
				"  \"unit_price\" : \"3.50\",\n" + 
				"  \"kcal_per_100g\" : null,\n" + 
				"  \"description\" : \"by Sainsbury's mixed berries\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's Mixed Berry Twin Pack 200g\",\n" + 
				"  \"unit_price\" : \"2.75\",\n" + 
				"  \"kcal_per_100g\" : null,\n" + 
				"  \"description\" : \"Description Mixed Berries 1 of 5 a-day 80g serving Class I Raspberries grown in Morocco Blueberries grown in Peru\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's Redcurrants 150g\",\n" + 
				"  \"unit_price\" : \"2.50\",\n" + 
				"  \"kcal_per_100g\" : \"Typical values Per 100g % based on RI for Average Adult Energy 300kJ - 71kcal 4% Fat <0.5g - Saturates <0.1g - Carbohydrate 13.8g 5% Total Sugars 7.4g 8% Starch 6.4g - Fibre 4.3g - Protein 1.4g 3% Salt <0.01g -\",\n" + 
				"  \"description\" : \"by Sainsbury's redcurrants\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's Cherry Punnet, Taste the Difference 200g\",\n" + 
				"  \"unit_price\" : \"2.50\",\n" + 
				"  \"kcal_per_100g\" : \"Typical Values Per 100g % based on RI for Average Adult Energy 203kJ - 48kcal 2% Fat <0.5g - Saturates <0.1g - Carbohydrate 11.5g 4% Total Sugars 11.5g 13% Fibre 1.5g - Protein 0.9g 2% Salt 0.00g -\",\n" + 
				"  \"description\" : \"Cherry Punnet\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's Blackcurrants 150g\",\n" + 
				"  \"unit_price\" : \"1.75\",\n" + 
				"  \"kcal_per_100g\" : null,\n" + 
				"  \"description\" : \"Description Union Flag\"\n" + 
				"}, {\n" + 
				"  \"title\" : \"Sainsbury's British Cherry & Strawberry Pack 600g\",\n" + 
				"  \"unit_price\" : \"4.00\",\n" + 
				"  \"kcal_per_100g\" : null,\n" + 
				"  \"description\" : \"Description British Cherry & Strawberry Mixed Pack 1 of 5 a-day - 80g serving Class I Union Flag\"\n" + 
				"} ]", valueue);
	}
}
