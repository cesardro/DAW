from django.urls import path
from . import views

#Creando rutas
urlpatterns = [
    path('grupos/<int:identificador>', views.grupos, name='grupos'),
]
