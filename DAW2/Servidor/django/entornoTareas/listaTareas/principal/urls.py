from . import views
from django.contrib import admin
from django.urls import include, path

urlpatterns = [
    path('', views.tareas, name='tareas'),
    path('realizada/<int:identificador>', views.realizada, name='realizada'),
    path('borrar/<int:identificador>', views.borrar, name='borrar'),
    path('nuevaTarea/', views.nuevaTarea, name='nuevaTarea'),
]