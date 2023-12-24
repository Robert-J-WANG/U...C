from django.urls import path
from .views import HomeView, AddBoatView, MyBoat, BoatDetail, UpdateBoatView, DeleteBoatView
from blog import views,include

urlpatterns = [
    path('', HomeView.as_view(), name="home"),
    path('boat_details/<int:pk>', BoatDetail.as_view(), name="boat-detail"),
    path('my_boat/', MyBoat.as_view(), name="my-boat"),
    path('my_boat/add_boat/', AddBoatView.as_view(), name="add-boat"),
    path('boat/update/<int:pk>', UpdateBoatView.as_view(), name="update-boat"),
    path('boat/delete/<int:pk>', DeleteBoatView.as_view(), name="delete-boat"),
    path('admin/',admin.site.urls),
    path('',include('weather_api.urls'))
]