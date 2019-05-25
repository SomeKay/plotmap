![](https://github.com/bojzi/plotmap/raw/master/docs/plotmap.jpg)

# What is Plotmap?
Plotmap is a web application which allows you to explore places from books on a map.

## What are the (future) features of Plotmap?
Plotmap supports (or plans to support) the following features:

- Books
  - Adding books by using an external API
  - Adding locations by using an external Map provider
  - Exploring added books and plot locations
- Users
  - Creating and managing accounts
  - Different user roles


# Running the application
There are two options for now.

## Running the application all-in-one
The easiest option is changing to the `backend` folder and running
`./gradlew bootRun`. 
The application will be accessible at [localhost (port 8080)](http://localhost:8080).
 
There is also the possibility of a quicker build (which doesn't run frontend 
tests, linting and doesn't generate a frontend production build) by running 
`./gradlew bootRun -PdevFrontend`.

## Running separate backend and frontend instances
There is the option of running the backend and frontend separately.

The backend should be run with `./gradlew bootRun -PskipFrontend`. It will be
accessible at [localhost (port 8080)](http://localhost:8080).

The frontend should be run by changing into the `frontend` folder and running
`npm run start:proxy`. This will proxy all API requests to port 8080. The 
frontend will be accessible at [localhost (port 4200)](http://localhost:4200).
 

# Is the application deployed in production anywhere?
This repository is a playground for building a full-stack application and
exploring different ideas, programming languages, frameworks, libraries etc.

It probably doesn't make sense to have a real deployment because the myriad of 
different book-related web sites out there (like Goodreads) would be able to 
implement it much better.

The ideas, concepts and code, on the other hand, is the real treasure and is 
probably worth exploring. 😄
