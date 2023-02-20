from django.urls import path
from .views import ProfesorListView, ProfesorCreateView, ProfesorUpdateView, ProfesorDeleteView

urlpatterns = [
    path('', ProfesorListView.as_view(), name='listado'),
    path('creaProfesor', ProfesorCreateView.as_view(), name='profesorCrear'),
    path('modificaProfesor/<int:pk>', ProfesorUpdateView.as_view(), name='profesorModificar'),
    path('borraProfesor/<int:pk>', ProfesorDeleteView.as_view(), name='profesorBorrar'),
]