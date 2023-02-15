from django.urls import path
from . import views

urlpatterns = [
    path('', views.index, name='index'),
    path('nuevo/', views.nuevo, name='nuevo'),
    path('nuevo/nuevoRegistro/', views.nuevoRegistro, name='nuevoRegistro'),
    path('borrar/<int:identificador>', views.borrar, name='borrar'),
    path('modifica/<int:identificador>', views.modifica, name='modifica'),
    path('modifica/modificaRegistro/<int:identificador>', views.modificaRegistro, name='modificaRegistro'),
]