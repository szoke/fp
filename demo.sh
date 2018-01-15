#!/usr/bin/env bash
# Run this script to see the application in action

createUserAtZeroZero() {
    curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{
    "latitude": 0,
    "longitude": 0
    }' 'http://localhost:8080/users'
}

createUserGroupOne() {
    for i in 1 2 3 4 5
    do
       createUserAtZeroZero
    done
}

createUserAtHundredHundred() {
    curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{
    "latitude": 100,
    "longitude": 100
    }' 'http://localhost:8080/users'
}

createUserGroupTwo() {
    for i in 1 2 3 4 5
    do
       createUserAtHundredHundred
    done
}

echo -----------------------
echo --- FlashParty DEMO ---
echo -----------------------

echo
echo --- Creating user group 1...
createUserGroupOne

echo
echo --- Creating user group 2...
createUserGroupTwo

echo
echo --- Updating user 1
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{
  "latitude": 0,
  "longitude": 0
}' 'http://localhost:8080/users/1/geolocation'

echo
echo --- Retrieving all flash parties, expecting 2 each contating 5 users
curl -X GET --header 'Accept: application/json' 'http://localhost:8080/flashparties'

