# Run this script to see the application in action

echo -----------------------
echo --- FlashParty DEMO ---
echo -----------------------

echo --- Creating users...
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{
  "latitude": 100,
  "longitude": 50
}' 'http://localhost:8080/users'

echo 
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{
  "latitude": 100,
  "longitude": 50
}' 'http://localhost:8080/users'

echo
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{
  "latitude": 150,
  "longitude": 50
}' 'http://localhost:8080/users'

echo
echo --- Hardcoded radius is 10.
echo --- User 1 and 2 are near so they are candidates to start a flash party. User 3 is too far away to be included.
echo --- Updating geo location of user 1 with the same values so that it will not actually move and expecting a flash party suggestions including user 1 and 2.
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{
  "latitude": 100,
  "longitude": 50
}' 'http://localhost:8080/users/1/geolocation'

echo
echo --- User 3 moves close enough to be included in the flash party suggestion.
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{
  "latitude": 105,
  "longitude": 50
}' 'http://localhost:8080/users/3/geolocation'

echo
echo --- User 1 gets too far away and is on their own. No surrounding users are there. Expecting empty the flash party suggestion.
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{
  "latitude": 10,
  "longitude": 10
}' 'http://localhost:8080/users/1/geolocation'

echo
echo --- User 1 is now on their own. No surrounding users are there. Expecting empty the flash party suggestion when moving 1 unit in both directions.
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{
  "latitude": 11,
  "longitude": 11
}' 'http://localhost:8080/users/1/geolocation'

echo
echo --- User 2 and 3 are still close to each other. Updating geo location of user 3 and expecting a flash party suggestion including user 2 and 3.
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{
  "latitude": 106,
  "longitude": 52
}' 'http://localhost:8080/users/3/geolocation'