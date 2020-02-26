# SpringCarRental
Spring Car Rental application

#### JAVA 8 / Spring Boot / MySQL 8.0

# REST :

#### @GET

###### `/car/all ` list of all cars                   

###### `/car/{id}` car based on id

###### `/car/brand/{carBrand}` list of cars based on brand

###### `/car/platenumber/{plateNumber}` car based on plate number (is unique)

###### `/car/type/{carType}` list of cars based on type ("SUV", "SPORT", "CLASSIC", "VAN")

###### `/car/available/all`      list of all available cars (not reserved yet)

###### `/car/availiable/{brand}` list of all avaliable cars specyfic brand

###### `/user/all` list of all users

#### @POST

###### `/car/add` json {}

###### `/car/update` json minimal required {"carBrand" : , "carPlateNumber" : }    (id is immutable)

#### @DELETE

###### `/car/delete`




