# sr-rest-service
The srapi REST service is a programatically accessible data source for food Recipes. The API is designed to be easily integrated into web and mobiles apps.
It accepts CRUD operations.

## Technologies
* **Scripting Language**: Java
* **Framework**: Spring boot
* **UnitTests**: Jnuit
* **Build automation**: Maven
* **Database**: H2 Database

## Base URL
The Base URL is the root URL for all of the API, if you ever make a request to srapi and you get back a 404 NOT FOUND response then check the Base URL first.
The Base URL for swapi is **http://localhost:8080/srapi/v1/**

## Authenication
No authentication is required to query and get data.

## JSON
JSON is the standard formart provided by the API..

## Resources
### Root
**NOT implemented**
The Root provides information on all available resources within the API.
**Example request** 
curl http://localhost:8080/srapi/v1
**Example response** 
__NOT implemented__

### Recipe
A Recipe resource is a single meal or recipe in the database.
**Endpoints**
* recipes/ -- get all recipe resources
* recipes/{id} -- get a single recipe
**Example request** 
curl http://localhost:8080/srapi/recipes/1
**Example response** 

**Attributes**
- private Integer id -- rimary key
- private String recipeName -- the name of the recipeor meal
- private String description - a short description of the recipe
- private LocalDateTime createdAt - the time the resource was created
- private LocalDateTime editedAt -- the time the resource was updated
- private String creator -- the name of the creator of the recipe
- private String country -- the country where the creator lives
- private String prep -- the time it takes to prepare the recipe
- private String cook -- the time it takes for the meal to coo
- private String servings -- the number of servings 
- private String category -- the category (breakfast, lunch, dinner)
- private ArrayList<String> ingredients -- the ingredients required
- private ArrayList<String> cookDirections -- the steps to prepare the meal
- private ArrayList<String> nutrients -- nutrition informaiton

### Methods
* GET -- get all recipe resouces or a single recipe by id.
**Example request** 
curl http://localhost:8080/srapi/recipes/
curl http://localhost:8080/srapi/recipes/1

* PUT -- update a recipe matching id or create a new one if does not exist.
**Example request** 
curl http://localhost:8080/srapi/recipes/1

* POST -- create a new recipe resource.
**Example request** 
curl http://localhost:8080/srapi/recipes/1

* DELETE -- delete a recipe matching id from the database.
**Example request** 
curl http://localhost:8080/srapi/recipes/1

### Contributor(s)
Peter Zyambo
