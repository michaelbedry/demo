# Getting Started

The DemoMWI application is setup as a standard maven springboot application. 
The application was built using the maven install facility in eclipse

The application makes use of H2 in memory databse to store both the items and purchasedItems. The items table is pre-populated with 5 items and startup.

The surge pricing was implemented in a rest api call that made method calls (purchaseItem and updateItem)
from the PurchaseService. The PurchaseService would call the purchaseItem and then the service
would determine if 10 or more of that item were purchased within 1 hour, if so then the PurchaseService 
would call the updateItem method to update the price of that item but adding 10*  

JSON format was chosen as it is the standard for web applications.

	- The purchase endpoint (http://localhost:8080/private/purchase) 
		will return a JSON string similar to the following
		{
		  "id": 18,
    	       "itemId": 4,
    	       "datePurchased": "2021-04-09T23:27:29.854109",
    	       "price": 25.916,
           "priceUpdated": true
         }
        
    - The items endpoint (http://localhost:8080/items) will return a JSON string similar to the following
    		[
    {
        "id": 1,
        "name": "ITEM1",
        "description": "Test for Item1",
        "price": 23.56
    },
    {
        "id": 2,
        "name": "ITEM2",
        "description": "Test for Item2",
        "price": 23.56
    },
    ....
]
    
Standard username and password authentication was chosen as there is no forms required
and use of firebase or oauth facilities where overkill and not necessary

## Setup
### Download DemoMWI application from GitHub using the following URL
	- https://github.com/michaelbedry/demo.git
	
### Install and configure PostMan

	** Configure postman with the following authorization information
		-- Username:   demomwi@test.com
		-- Password:   demomwi


### Public Endpoints

	the DemoMWI application can be accessed via the following URLs
	
		- http://localhost:8080/items
			retrieves all items from the database
		- http://localhost:8080/items/{id}
			retrieve a specific item from database. The {id} parameter can be from 1 to 5.

### Private Endpoints

	the private endpoints for DemoMWI application requires the use of  
	using PostMan or SoapUI via the following URLs 
	
	You must execute the following urls 	
		-- http://localhost:8080/private/purchase
			adds an item to the purchase table,
			if the # of items purchased is > 10 then the price of that updated isupdated by 10%
						
			
				 