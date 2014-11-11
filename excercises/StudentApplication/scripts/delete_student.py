import requests
import json

#change ssn
url = 'http://localhost:9080/student/api/students/111-11-1111.json'

r = requests.delete(url)
print r
