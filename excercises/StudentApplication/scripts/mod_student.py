import requests
import json

# change data
data = {
	'scores' : [100, 100]
}

url = 'http://localhost:9080/student/api/students/111-11-1111.json'
header = { 'Content-type' : 'application/json' }

r = requests.put(url, headers=header, data=json.dumps(data))
print r
