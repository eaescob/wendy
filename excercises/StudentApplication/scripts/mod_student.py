import requests
import json

# change data
data = {
	'department' : 'Education',
	'degree' : 'Gay Sex',
	'scores' : [100, 100, 100]
}

url = 'http://localhost:9080/student/api/students/222-22-2222.json'
header = { 'Content-type' : 'application/json' }

r = requests.put(url, headers=header, data=json.dumps(data))
print r
