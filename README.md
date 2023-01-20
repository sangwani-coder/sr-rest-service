# sr-rest-service
The srapi REST service is a programatically accessible data source for food Recipes. The API is designed to be easily integrated into web and mobiles apps.

## Technologies
* **Scripting Language**: Java
* **Framework**: Spring boot
* **UnitTests**: Jnuit
* **Build automation**: Maven
* **Database**: H2 Database

## Base URL
The Base URL is the root URL for all of the API, if you ever make a request to srapi and you get back a 404 NOT FOUND response then check the Base URL first.
The Base URL for swapi is **"srapi/v1/"**

## Authenication
No authentication is required to consume the API.

## Content Negotiation
When a client sends a request to the API, it can specify two HTTP Headers related to Content Negotiation
- Accept and
- Content-Type

### JSON
JSON is the default format provided by the API. If a client sends a request with _Accept_ header as 'application/json', or without specifying the _Accept_ header, the server responds with the JSON representation of the resource.

### XML
An API client can also send requests in Extensible Markup Language(XML). To get XML representaiton of the response you need to add the _Accept_ header **application/xml**.

To send a POST or PUT request with the XML request body you need to add the _Content-Type_ header **application/xml**.

## Resources
### Root
**NOT implemented**
The Root provides information on all available resources within the API.

### Known bugs
- POST and PUT requests with Content-Type 'application/xml' fails with 400 Bad request error.
- The request on the Base URL should return information on all available resources. However it returns a 404 error.
**Example request**

    curl http://localhost:8080/srapi/v1

**Example response**

    {
        "status": 404,
        "error": "Not Found",
        "path": "/srapi/v1"
    }

### Recipe
A Recipe resource is a single meal or recipe in the database.
**Endpoints**

* recipes/ -- get all recipe resources
* recipes/{id} -- get a single recipe matching id

## Get Requests
**Example request** 
Don't forget to include the base URL: _srapi/v1/<end_point>_ before the endpoints.

GET: 
    curl http://localhost:8080/srapi/v1/recipes/1

**Example response** 

    {
        "id":2,
        "recipeName":"Tuscan Chicken Skillet",
        "description":null,
        "createdAt":"2023-01-20T14:27:05.680635",
        "editedAt":"2023-01-20T14:27:05.680635",
        "creator":"Sangwani",
        "country":null,
        "prep":null,
        "cook":null,
        "servings":null,
        "category":"Lunch",
        "cookDirections":null,
        "nutrients":null,
        "ingredient":null,
        "_links":{
            "self":{"href":"http://localhost:8080/srapi/v1/recipes/2"},
            "recipes":{"href":"http://localhost:8080/srapi/v1/recipes"}
            }
    }

**Example request** 
Trying to access a recipe that does not exits raises a RecipeNotFoundError and returns a string.

GET: 
    curl http://localhost:8080/srapi/v1/recipes/5

**Example reponse**

    Could not find recipe with id 5

## Post Request
**Example request** 
Trying to access a recipe that does not exits raises a RecipeNotFoundError and returns a string.

GET: 
    curl http://localhost:8080/srapi/v1/recipes/5

**Example reponse**
<!-- example response -->

## Put Request
**Example request** 
<!-- example put request -->
**Example reponse**
<!-- example response -->

## Delete Request
**Example request** 
<!-- example delete request -->
**Example reponse**
<!-- example response -->

**Attributes**
- id --_integer_ primary key
- recipeName --_String_ the name of the recipe or meal
- description -- _String_ a short description of the recipe
- createdAt -- _LocalDateTime_ the time the resource was created
- editedAt --_LocalDateTime_ the time the resource was updated
- creator -- _String_ the name of the creator of the recipe
- country --_String_ the country where the creator lives
- prep --_String_ the time it takes to prepare the recipe
- cook --_String_ the time it takes for the meal to cook
- servings --_String_ the number of servings the dish can produce
- category --_Stgring_ the category (breakfast, lunch, dinner)
- ingredients --_Array_ the ingredients required to make the dish
- cookDirections --_HashMap_ the steps to prepare the meal
- nutrients --_Array_ nutrition informaiton


## Endpoints and Accepted Methods
|No.| Method | URI             |      Description |
|------------|-------------------|------------------|---------------|
|1. | GET | srapi/v1/ | get all information on available resouces |
|2. | GET | srapi/v1/recipes | get all the recipes in the database |
|3. | GET | srapi/v1/recipes/{id} | get a specific recipe that matches id |
|4. | POST | srapi/v1/recipes | create a new Recipe resource |
|5. | PUT | srapi/v1/recipes/{id}| update a resource that matches id, if not found create a new resource |
|6. | DELETE | srapi/v1/recipes{id}| delete a resource matched by id |

### Contributor(s)
Peter Zyambo (Twitter)[https://twitter.com/peter_zyambo]
