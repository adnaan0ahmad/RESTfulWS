package com.java.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestAssuredClient {

	public static List<User> getListOfUsers() {
		Response r = RestAssured.get("http://jsonplaceholder.typicode.com/users");
		List<User> l = new ArrayList<User>();
		JSONArray j = new JSONArray(r.asString());
		for (Object ob : j) {
			JSONObject jOb = (JSONObject) ob;
			JSONObject jComp = jOb.getJSONObject("company");
			JSONObject jAd = jOb.getJSONObject("address");
			JSONObject jGeo = jAd.getJSONObject("geo");

			Geo g = new Geo(jGeo.getString("lat"), jGeo.getString("lng"));
			Address ad = new Address(jAd.getString("street"), jAd.getString("suite"), jAd.getString("city"),
					jAd.getString("zipcode"), g);
			Company c = new Company(jComp.getString("name"), jComp.getString("catchPhrase"), jComp.getString("bs"));

			User u = new User((Integer) jOb.get("id"), jOb.getString("name"), jOb.getString("username"),
					jOb.getString("email"), ad, jOb.getString("phone"), jOb.getString("website"), c);
			l.add(u);
		}
		return l;
	}

	public static User getUser(int id) {
		Response r = RestAssured.get("http://jsonplaceholder.typicode.com/users/" + id);
		JSONObject jOb = new JSONObject(r.asString());
		JSONObject jComp = jOb.getJSONObject("company");
		JSONObject jAd = jOb.getJSONObject("address");
		JSONObject jGeo = jAd.getJSONObject("geo");

		Geo g = new Geo(jGeo.getString("lat"), jGeo.getString("lng"));
		Address ad = new Address(jAd.getString("street"), jAd.getString("suite"), jAd.getString("city"),
				jAd.getString("zipcode"), g);
		Company c = new Company(jComp.getString("name"), jComp.getString("catchPhrase"), jComp.getString("bs"));

		User u = new User((Integer) jOb.get("id"), jOb.getString("name"), jOb.getString("username"),
				jOb.getString("email"), ad, jOb.getString("phone"), jOb.getString("website"), c);

		return u;
	}

}
