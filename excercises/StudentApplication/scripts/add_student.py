import requests
import json

# change data
data = {
	'firstname' : 'Emilio',
	'lastname' : 'Escobar',
	'address1' : '123 Elm St.',
	'city' : 'San Diego',
	'state' : 'CA',
	'country' : 'US',
	'department' : 'Engineering',
	'degree' : 'Computer Science',
	'ssn' : '111-11-1111', 
	'scores' : [98,76,86,88,89,92,96,99]
}

url = 'http://localhost:9080/student/api/students.json'
header = { 'Content-type' : 'application/json' }

r = requests.post(url, headers=header, data=json.dumps(data))
print r
