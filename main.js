import { planetCoordinatesGenerator } from './PlanetsPosition.js';
const planets= 
        `[
            {
                "name": "Hoth",
                "industryPointsMultiplier": 2, 
                "sciencePointsMultiplier": 1,
                "size": 3,
                "xCord": 150,
                "yCord": 1000, 
                "owner": 1
            },
            {
                "name": "Naboo",
                "industryPointsMultiplier": 2, 
                "sciencePointsMultiplier": 3,
                "size": 2,
                "xCord": 290,
                "yCord": 250, 
                "owner": 2
            },
            {
                "name": "Tatooine",
                "industryPointsMultiplier": 3, 
                "sciencePointsMultiplier": 1,
                "size": 1,
                "xCord": 500,
                "yCord": 320, 
                "owner": 3
            },
            {
                "name": "Mustafar",
                "industryPointsMultiplier": 3, 
                "sciencePointsMultiplier": 1,
                "size": 2,
                "xCord": 200,
                "yCord": 390, 
                "owner": 1
            }
        ]`
planetCoordinatesGenerator(planets)

