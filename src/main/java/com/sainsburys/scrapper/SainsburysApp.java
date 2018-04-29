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

	static String baseLink = "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/";
	static List<Product> products = new ArrayList<Product>();
	static String jsonInString = "";
	static double totalPrice = 0;
	static Product sainsburyPorduct = null;
	String output = "";

	public static void main(String[] args) throws IOException {

		System.out.println("{" + '\n' + "\"results : \" " 
				+ transformToJSON(getProducts()) + "" + '\n' + " \"total: \" "
				+ getTotalPrice(products) + '\n' + "}");

	}

	//This method scrape information from Sainsburys website and create an ArrayList of products 
	public static List<Product> getProducts() throws IOException {

		final Document document = Jsoup.connect(baseLink + "webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html").get();

		for (Element row : document.select("ul.productLister li")) {

			String title = row.select(".productNameAndPromotions a").text();

			final String price = row.select(".pricing").text();

			// Create new product and sets title, price, kcal and description
			if (!title.equals("") && !price.equals("")) {
				sainsburyPorduct = new Product();
				sainsburyPorduct.setTitle(title);
				sainsburyPorduct.setUnit_price(price.substring(1, 5));

				final String link = row.select("a[href]").attr("href");

				String newString = link.replace("../../../../../../", baseLink);

				if (!newString.equals("")) {
					final Document extraInformation = Jsoup.connect(newString).get();
					for (Element information : extraInformation.select(".tableWrapper table")) {

						final String kcal_per_100g = information.select(".nutritionTable").text();

						if (kcal_per_100g != null) {

							sainsburyPorduct.setKcal_per_100g(kcal_per_100g);

						} else {

						}

					}

					for (Element information : extraInformation.select(".mainProductInfoWrapper")) {

						final String description = information.selectFirst(".productText").text();

						sainsburyPorduct.setDescription(description);

					}

				}
				products.add(sainsburyPorduct);
			} else {
			}

		}

		transformToJSON(products);
		return products;

	}

	// This method transforms ArrayList into JSON String 
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

	// This method get returns total price of all products
	public static double getTotalPrice(List<Product> products) {

		for (int i = 0; i < products.size(); i++) {

			totalPrice = totalPrice + Double.valueOf(products.get(i).getUnit_price());

		}

		return totalPrice;

	}
}
