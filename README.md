# Valorant weapons API

Rest API for Valorant weapons.

[Heroku App](https://weapons-valorant-api.herokuapp.com/arsenal/)

## Endpoints

| Path                                   | Description                                                                                                                                                          |
|----------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| /arsenal [**GET**]                     | Request all weapons on the database. You can get them sorted by providing the **?/sort=** parameter with the values: specs, category, damage, rateOfFire and rating. |
| /arsenal/category/{category} [**GET**] | To request the weapons of a category, _{category}_ takes the values from the table below.                                                                            |
| /arsenal/{name} [**GET**]              | Request a weapon by name.                                                                                                                                            |
| /arsenal/category/ [**GET**]           | Request weapon categories                                                                                                                                            |

_(Category table)_

| Category                |
|-------------------------|
| Armas de mano           |
| Subametralladoras       |
| Escopetas               |
 | Rifles                  |
| Rifles de francotirador |
| Armas pesadas           |
| Melee                   |
