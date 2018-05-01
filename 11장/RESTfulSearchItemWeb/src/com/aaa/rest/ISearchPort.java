package com.aaa.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/services")
public interface ISearchPort {

	@GET
	@Path("setItems/{shopId}")
	public void setShopItems(@PathParam("shopId") String shop_id);
	
	@GET
	@Path("getInfo/{shopId}")
	@Produces({"application/json"})
	public Products getProductsInfo(@PathParam("shopId") String shop_id);
}