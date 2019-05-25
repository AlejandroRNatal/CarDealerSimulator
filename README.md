# CarDealerSimulator

## Overview (DISCLAIMER: Original URL is in GitLab!)
<p> This project is part of the introductory Data Structures course given on Fall2018.
This project was aimed to introduce students to the different structures with their respective strengths and weaknesses.
</p>

## Specifications
- RESTful API to serve Car JSON objects (GET, PUT, POST) with appropriate error handling.
-- When POST there should exist no duplicate objects(Comparators used here) eg. same ID and Person Object attached.
- Search and filtering options for Car JSON objects
- Follow the Factory, Manager, Driver model
- Implement the following DS: PositionalList(Linked List, Array), Queue, Comparators, Iterators.
- All code should be reusable (generics) and  implement inheritance to highest extent possible as to avoid boilerplate code later on.
- Inlcude JUnit tests under src\main\java\testers
- HTTP Server shall run on "http://localhost:8080/cardealer/"
- Use CURL to test HTTP Responses
