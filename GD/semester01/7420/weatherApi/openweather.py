import json
import requests
city = input("Please type city name here: ")
url = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=cdf05d929ed5cfa526764c43d2b832d2"
response = requests.get(url)
data = json.loads(response.text)
print(data)
print(data["main"]["temp"])
print(data["wind"]["deg"])