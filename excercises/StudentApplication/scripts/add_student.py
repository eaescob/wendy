import requests
import json

# change data
data = {
	'firstname' : 'Emilio',
	'lastname' : 'Escobar',
	'address1' : '124 Elm ST.',
	'city' : 'San Diego',
	'state' : 'CA',
	'country' : 'US',
	'department' : 'Engineering',
	'degree' : 'Computer Science',
	'ssn' : '111-11-1111', 
	'scores' : [88, 87, 78, 92, 98, 90, 86, 80, 82]
}

url = 'http://localhost:9080/student/api/students.json'
header = { 'Content-type' : 'application/json' }

r = requests.post(url, headers=header, data=json.dumps(data))
print r
