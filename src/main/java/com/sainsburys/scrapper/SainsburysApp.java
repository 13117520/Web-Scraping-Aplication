package com.sainsburys.scrapper;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Author: Lukasz Adamski
 * 
 * Java console application that scrapes the Sainsbury’s grocery site’s Berries,
 * Cherries, Currants page and returns a JSON array of all the products on the
 * page.
 */

public class SainsburysApp {

	static double totalPrice = 0;
	static List<Product> products = new ArrayList<Product>();
	static Product emp = null;
	static String jsonInString = "";
	String output = "";
	static String baseLink = "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/";

	public static void main(String[] args) throws IOException {

		System.out.println("{" + '\n' + "\"results : \" " + transformToJSON(getProducts()) + "" + '\n' + " \"total: \" "
				+ getTotalPrice(products) + '\n' + "}");

	}

	public static List<Product> getProducts() throws IOException {

		final Document document = Jsoup
				.connect(baseLink + "webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html").get();

		for (Element row : document.select("ul.productLister li")) {

			String title = row.select(".productNameAndPromotions a").text();

			final String price = row.select(".pricing").text();

			if (!title.equals("") && !price.equals("")) {
				emp = new Product();
				emp.setTitle(title);
				emp.setUnit_price(price.substring(1, 5));

				final String link = row.select("a[href]").attr("href");

				String newString = link.replace("../../../../../../", baseLink);

				if (!newString.equals("")) {
					final Document extraInformation = Jsoup.connect(newString).get();
					for (Element information : extraInformation.select(".tableWrapper table")) {

						final String kcal_per_100g = information.select(".nutritionTable").text();

						if (kcal_per_100g != null) {

							emp.setKcal_per_100g(kcal_per_100g);

						} else {

						}

					}

					for (Element information : extraInformation.select(".mainProductInfoWrapper")) {

						final String description = information.selectFirst(".productText").text();

						emp.setDescription(description);

					}

				}
				products.add(emp);
			} else {
			}

		}

		transformToJSON(products);
		return products;

	}

	public static String transformToJSON(List<Product> products) {

		ObjectMapper mapper = new ObjectMapper();

		try {

			jsonInString = mapper.writeValueAsString(products);

			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(products);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonInString;
	}

	public static double getTotalPrice(List<Product> products) {

		for (int i = 0; i < products.size(); i++) {

			totalPrice = totalPrice + Double.valueOf(products.get(i).getUnit_price());

		}

		return totalPrice;

	}
}
