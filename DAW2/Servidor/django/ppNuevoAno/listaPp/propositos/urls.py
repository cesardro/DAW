from django.urls import path
from . import views

#Creando rutas
urlpatterns = [
    path('', views.propositos, name='propositos'),
    path('nuevo', views.nuevo, name='nuevo'),
    path('conseguido/<int:identificador>', views.conseguido, name='conseguido'),
    path('mover/<int:identificador>', views.mover, name='mover'),
    path('mover/modificar/<int:identificador>', views.modificar, name='modificar'),
    path('modProp/<int:identificador>', views.modProp, name='modProp'),
    path('modProp/actualizar/<int:identificador>', views.actualizar, name='actualizar'),
    path('resetear/<int:identificador>', views.resetear, name='resetear'),
    path('borrar/<int:identificador>', views.borrar, name='borrar'),
]