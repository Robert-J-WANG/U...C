from django.shortcuts import render

# Create your views here.
from django.urls import reverse_lazy
from django.views.generic import ListView, CreateView, UpdateView, DetailView, DeleteView

from blog.forms import BoatForm, UpdateBoatForm
from blog.models import Boat
import requests

class HomeView(ListView):
    model = Boat
    template_name = 'home.html'
class BoatDetail(DetailView):
    model = Boat
    template_name = 'boat/boat_detail.html'
class MyBoat(ListView):
    model = Boat
    template_name = 'boat/myboat.html'
class AddBoatView(CreateView):
    model = Boat
    form_class = BoatForm
    template_name = 'boat/add_boat.html'
    success_url = reverse_lazy('my-boat')
class UpdateBoatView(UpdateView):
    model = Boat
    form_class = UpdateBoatForm
    template_name = 'boat/update_boat.html'
    success_url = reverse_lazy('my-boat')
class DeleteBoatView(DeleteView):
    model = Boat
    template_name = 'boat/delete_boat.html'
    success_url = reverse_lazy('my-boat')

def  index(request):
    api_url = "http://api.openweathermap.org/data/2.5/weather?appid=359c651e9120433bf403e529363a3da4&q="
    city_name = "Auckland"

    URL= api_url + city

    response = request.get(url)
    content = response.json()
    city_weather = {
        'city': city_name,
        'temperature': content['main']['temp'],
        'description': content['weather'][0]['description'],
        'icon': content['weather'][0]['icon'],
    }

    return render(request,'weather.html',city_weather)